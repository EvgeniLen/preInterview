package ru.lenivtsev.lesson3.exercise2;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class CounterUser extends Thread {
    private final Counter counter;
    private final Lock lock;
    boolean lockAcquired = false;

    public CounterUser(Counter counter, Lock lock) {
        this.counter = counter;
        this.lock = lock;
    }

    @Override
    public void run() {
        try {
            while (!isInterrupted()) {
                if (lock.tryLock(5, TimeUnit.SECONDS)) {
                    lockAcquired = true;
                    counter.increase();
                }
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            if (lockAcquired) {
                lock.unlock();
             }
        }
    }
}
