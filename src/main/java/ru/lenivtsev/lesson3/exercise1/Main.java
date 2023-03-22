package ru.lenivtsev.lesson3.exercise1;

public class Main {
    public static final Object o = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            while (true) {
                print("ping");
            }
        }).start();

        new Thread(() -> {
            while (true) {
                print("pong");
            }
        }).start();
    }

    public static void print(String s) {
        synchronized (o){
            System.out.println(s);
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            o.notify();
            try {
                o.wait(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
