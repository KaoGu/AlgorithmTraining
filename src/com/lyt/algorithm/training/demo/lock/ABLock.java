package com.lyt.algorithm.training.demo.lock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

class LockInfo {
    private String name;
    public LockInfo(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return name;
    }
}

public class ABLock {

    public static AtomicInteger lockSuccesNum = new AtomicInteger();

    public static boolean lock(String user, Object left, Object right) {
        synchronized (left) {
            System.out.println(user + " lock " + left + " success");
            sleep(3);
            synchronized (right) {
                System.out.println(user + " lock " + left + " success");
                sleep(3);
                lockSuccesNum.incrementAndGet();
                return true;
            }
        }
    }

    public static void main(String[] args) {
        LockInfo left = new LockInfo("A");
        LockInfo right = new LockInfo("B");
        new Thread(() -> {
            lock("lilei", left, right);
        }).start();
        new Thread(() -> {
            lock("liliang", right, left);
        }).start();
        while (2 != lockSuccesNum.get()) {
            sleep(2);
        }
        System.out.println("OVER");
    }

    private static void sleep(int timeout) {
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
        }
    }
}
