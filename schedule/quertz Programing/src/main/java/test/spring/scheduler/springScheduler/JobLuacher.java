//package test.spring.scheduler;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//
//import java.text.ParseException;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * Quartz Scheduler 실행
// */
//class JobLuacher {
//    public static void main(String[] args) {
//        try {
//
//            // Scheduler 생성
//            SchedulerFactory factory = new StdSchedulerFactory();
//            Scheduler scheduler = factory.getScheduler();
//
////            scheduler.getListenerManager().addJobListener(new MyScheduleListener());
////            scheduler.getListenerManager().addTriggerListener(new MyTriggerListener());
//
//            // Scheduler 실행
//            scheduler.start();
//
//            // JOB Data 객체 생성
//            JobDataMap jobDataMap = new JobDataMap();
//            jobDataMap.put("message", "Hello, Quartz!!!");
//
//            // JOB Executor Class
//            Class<? extends Job> jobClass = SampleJobExecutor.class;
//
//            // JOB 생성
//            JobDetail jobDetail = JobBuilder.newJob(jobClass)
//                    .withIdentity("job_name", "job_group")
//                    .setJobData(jobDataMap)
//                    .build();
//
//            // SimpleTrigger 생성
//            // 4초마다 반복하며, 최대 5회 실행
//            SimpleScheduleBuilder simpleSch = SimpleScheduleBuilder.repeatSecondlyForTotalCount(5, 4);
//            SimpleTrigger simpleTrigger = (SimpleTrigger) TriggerBuilder.newTrigger()
//                    .withIdentity("simple_trigger", "simple_trigger_group")
//                    .withSchedule(simpleSch)
//                    .forJob(jobDetail)
//                    .build();
//
//            // CronTrigger 생성
//            // 15초주기로 반복( 0, 15, 30, 45 )
//            CronScheduleBuilder cronSch = CronScheduleBuilder.cronSchedule(new CronExpression("0/15 * * * * ?"));
//            CronTrigger cronTrigger = (CronTrigger) TriggerBuilder.newTrigger()
//                    .withIdentity("cron_trigger", "cron_trigger_group")
//                    .withSchedule(cronSch)
//                    .forJob(jobDetail)
//                    .build();
//
//            // JobDtail : Trigger = 1 : N 설정
//            Set<Trigger> triggerSet = new HashSet<Trigger>();
//            triggerSet.add(simpleTrigger);
//            triggerSet.add(cronTrigger);
//
//            // Schedule 등록
//            scheduler.scheduleJob(jobDetail, triggerSet, false);
//
//        } catch (ParseException | SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//}
