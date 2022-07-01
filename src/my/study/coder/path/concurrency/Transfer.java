package my.study.coder.path.concurrency;

import my.study.coder.path.concurrency.exception.InsufficientFundsException;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

import static java.lang.System.err;
import static java.lang.System.out;

public class Transfer implements Callable<Boolean> {

    public static final int WAIT_TIME = 2000;

    private Account accountFrom;
    private Account accountTo;
    private int amount;
    private int id;

    public Transfer(Account accountFrom, Account accountTo, int amount, int id) {
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
        this.amount = amount;
        this.id = id;
    }

    @Override
    public Boolean call() throws Exception {
        out.println("Start transaction with ID:" + id);

        if (accountFrom.getBalance() < amount) {
            throw new InsufficientFundsException();
        }

        Lock lockA = accountFrom.getLock();
        Lock lockB = accountTo.getLock();

        try {
            if (lockA.tryLock(WAIT_TIME, TimeUnit.MICROSECONDS)) {
                try {
                    lockA.lock();
                    if (lockB.tryLock(WAIT_TIME, TimeUnit.MICROSECONDS)) {
                        try {
                            lockB.lock();
                            accountFrom.withdraw(amount);
                            Thread.sleep(new Random().nextInt(5) * 10);
                            accountTo.deposit(amount);
                        } finally {
                            lockB.unlock();
                        }
                    } else {
                        accountTo.increaseFailCounter();
                        err.println("Error waiting lock accountTo with ID:" + id + " Fails: " + accountTo.getFailCounter());
                        return false;
                    }
                } finally {
                    lockA.unlock();
                }
            } else {
                accountFrom.increaseFailCounter();
                err.println("Error waiting lock accountFrom with ID: "+ id +" Fails: " + accountFrom.getFailCounter());
                return false;
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        out.println("Finish transaction with ID:" + id);

        return true;
    }

    public int getId() {
        return id;
    }
}
