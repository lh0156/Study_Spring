package test.spring.scheduler.thread;

import java.time.LocalDateTime;

public class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.print("Called at: " + LocalDateTime.now());
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
    }
}