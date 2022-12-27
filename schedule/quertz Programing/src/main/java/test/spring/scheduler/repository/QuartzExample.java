//package test.spring.scheduler;
//
//import org.quartz.*;
//import org.quartz.impl.StdSchedulerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.quartz.SchedulerFactoryBean;
//
//import javax.annotation.PostConstruct;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import static org.quartz.CronScheduleBuilder.cronSchedule;
//import static org.quartz.CronScheduleBuilder.cronScheduleNonvalidatedExpression;
//import static org.quartz.JobBuilder.newJob;
//import static org.quartz.TriggerBuilder.newTrigger;
//
//public class QuartzExample {
//
//    @Autowired
//    private Scheduler scheduler;
//
//    private String cronCode = "0 0/1 * 1/1 * ? *";
//
//    @PostConstruct
//    public void start() {
//        JobDetail jobDetail = buildJobDetail(SimpleJob.class, new HashMap());
//
//        try {
//            scheduler.scheduleJob(jobDetail, buildJobTrigger(cronCode));
//        } catch (SchedulerException e) {
//            e.printStackTrace();
//        }
//    }
//
//    // 트리거 생성 메소드
//    public Trigger buildJobTrigger(String scheduleExp) {
//        return newTrigger().withSchedule(cronSchedule(scheduleExp)).build();
//    }
//
//    // Job
//    public JobDetail buildJobDetail(Class job, Map params) {
//        JobDataMap jobDataMap = new JobDataMap();
//        jobDataMap.putAll(params);
//
//        return newJob(job).usingJobData(jobDataMap).build();
//    }
//
//
//
//}