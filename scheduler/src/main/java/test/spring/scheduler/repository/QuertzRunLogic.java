//package test.spring.scheduler.repository;
//
//import org.quartz.CronTrigger;
//import org.quartz.JobDetail;
//import org.quartz.Scheduler;
//import org.quartz.SchedulerFactory;
//import org.quartz.impl.StdSchedulerFactory;
//import test.spring.scheduler.SimpleJob;
//
//import static org.quartz.CronScheduleBuilder.cronSchedule;
//import static org.quartz.JobBuilder.newJob;
//import static org.quartz.TriggerBuilder.newTrigger;
//
//public class QuertzRunLogic {
//
//    public void run() throws Exception {
//
//        // create the scheduler
//        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
//        Scheduler scheduler = schedulerFactory.getScheduler();
//
//        // define the job and tie it to the SimpleJob class
////        JobDetail job = JobBuilder.newJob(SimpleJob.class)
////                .withIdentity("myJob", "myGroup")
////                .build();
//
//        JobDetail job = newJob(SimpleJob.class)
//                .withIdentity("myJob5", "myGroup5")
//                .build();
//
//        // create the trigger and define its schedule to run every 3 seconds
////        Trigger trigger = newTrigger()
////                .withIdentity("myTrigger5", "myGroup5")
////                .withSchedule(SimpleScheduleBuilder.simpleSchedule()
////                        .withIntervalInSeconds(3)
////                        .repeatForever())
////                .build();
//
//        CronTrigger cronTrigger = newTrigger().withIdentity("myTrigger5", "myGroup5").withSchedule(cronSchedule("1 * * * * *")).build();
//
//
//
//        // add the job details to the scheduler and associate it with the trigger
//        scheduler.scheduleJob(job, cronTrigger);
//
//        // start the scheduler
//        scheduler.start();
//
//        // wait long enough to see the job execution
//        Thread.sleep(1000);
//
//        // shutdown the scheduler
//        scheduler.shutdown(true);
//    }
//
//}
