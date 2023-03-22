package ru.lenivtsev.lesson3.exercise2;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();
        Lock lock = new ReentrantLock();
        Thread thread1 = new Thread(new CounterUser(counter, lock));
        Thread thread2 = new Thread(new CounterUser(counter, lock));
        Thread thread3 = new Thread(new CounterUser(counter, lock));
        thread1.start();
        thread2.start();
        thread3.start();


        try {
            Thread.sleep(10);
            thread1.interrupt();
            thread2.interrupt();
            thread3.interrupt();
        } catch (InterruptedException e) {
            System.out.println("Threads has been interrupted");
        }


    }

}
