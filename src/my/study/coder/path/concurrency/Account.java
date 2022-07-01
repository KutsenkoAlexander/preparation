package my.study.coder.path.concurrency;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private int balance;
    private final Lock lock;
    private AtomicInteger failCounter;

    public Account(int balance) {
        this.balance = balance;
        this.lock = new ReentrantLock();
        this.failCounter = new AtomicInteger();
    }

    public void withdraw(int amount) {
        balance -= amount;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public int getBalance() {
        return balance;
    }

    public Lock getLock() {
        return lock;
    }

    public void increaseFailCounter() {
        failCounter.incrementAndGet();
    }

    public int getFailCounter() {
        return failCounter.get();
    }
}
