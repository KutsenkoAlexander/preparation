package my.study.coder.path.concurrency;

import my.study.coder.path.concurrency.exception.InsufficientFundsException;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import static java.lang.System.err;
import static java.lang.System.out;

public class Operations {

    public static final int WAIT_TIME = 1000;

    public static void main(String[] args) {
        Account a = new Account(WAIT_TIME);
        Account b = new Account(2000);

        new Thread(() -> transfer(a, b, 500)).start();
        transfer(b, a, 300);
    }

    private static void transfer(Account a, Account b, int amount) throws InsufficientFundsException {
        out.println("Start transaction");

        if (a.getBalance() < amount) {
            throw new InsufficientFundsException();
        }

        Lock lockA = a.getLock();
        Lock lockB = b.getLock();
        try {
            if (lockA.tryLock(WAIT_TIME, TimeUnit.MICROSECONDS)) {
                try {
                    lockA.lock();
                    Thread.sleep(100);
                    if (lockB.tryLock(WAIT_TIME, TimeUnit.MICROSECONDS)) {
                        try {
                            lockB.lock();
                            a.withdraw(amount);
                            b.deposit(amount);
                        } finally {
                            lockB.unlock();
                        }
                    } else {
                        b.increaseFailCounter();
                        err.println("Error waiting lock B. Fails: " + b.getFailCounter());
                    }
                } finally {
                    lockA.unlock();
                }
            } else {
                a.increaseFailCounter();
                err.println("Error waiting lock A. Fails: " + a.getFailCounter());
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        out.println("Finish transaction");
    }
}
