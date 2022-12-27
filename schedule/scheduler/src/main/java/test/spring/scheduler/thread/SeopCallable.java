package test.spring.scheduler.thread;

import java.time.LocalTime;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class SeopCallable {

    static class MyCallable implements Callable<String> {

        @Override
        public String call() throws Exception {
            String result = "Called at " + LocalTime.now();
            return result;
        }
    }

    public static void main(String[] args) {
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask(myCallable);
        Thread thread = new Thread(futureTask);
        thread.start();
    }

}
