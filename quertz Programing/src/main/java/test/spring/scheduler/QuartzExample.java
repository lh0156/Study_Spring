package test.spring.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

public class QuartzExample {

    public void run() throws Exception {
        // create the scheduler
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();

        Scheduler scheduler = schedulerFactory.getScheduler();
 
        // define the job and tie it to the SimpleJob class
        JobDetail job = JobBuilder.newJob(SimpleJob.class)
                .withIdentity("myJob19", "myGroup19")
                .build();


        // create the trigger and define its schedule to run every 3 seconds

        // Trigger trigger = TriggerBuilder.newTrigger()
        //         .withIdentity("myTrigger17", "myGroup17")
        //         .withSchedule(SimpleScheduleBuilder.simpleSchedule()
        //                 .withIntervalInSeconds(10)
        //                 .repeatForever())
        //         .build();

        String cron = "0 0/1 * 1/1 * ? *";
        CronTrigger trigger = newTrigger()
                .withIdentity("myTrigger19", "myGroup19")
                .withSchedule(cronSchedule(cron))
                .build();
 
        // add the job details to the scheduler and associate it with the trigger
        scheduler.scheduleJob(job, trigger);
 
        // start the scheduler
        scheduler.start();
 
        // wait long enough to see the job execution
        Thread.sleep(10000);
 
        // shutdown the scheduler
        scheduler.shutdown(false);
    }
 
    public static void main(String[] args) throws Exception {
        // run the example
        QuartzExample example = new QuartzExample();
        example.run();
    }
}