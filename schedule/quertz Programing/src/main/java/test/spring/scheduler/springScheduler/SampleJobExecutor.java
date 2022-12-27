//package test.spring.scheduler;
//
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.HashSet;
//import java.util.Set;
//
//import org.quartz.CronExpression;
//import org.quartz.CronScheduleBuilder;
//import org.quartz.CronTrigger;
//import org.quartz.Job;
//import org.quartz.JobBuilder;
//import org.quartz.JobDataMap;
//import org.quartz.JobDetail;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//
//
///**
// * Quartz Job
// */
//public class SampleJobExecutor implements Job {
//
//    private static final SimpleDateFormat TIMESTAMP_FMT = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSSS");
//
//    @Override
//    public void execute(JobExecutionContext ctx) throws JobExecutionException {
//        JobDataMap jobDataMap = ctx.getJobDetail().getJobDataMap();
//
//        String currentDate = TIMESTAMP_FMT.format(new Date());
//        String triggerKey = ctx.getTrigger().getKey().toString();
//        String message = jobDataMap.getString("message");
//
//        System.out.println(String.format("[%s][%s] %s", currentDate, triggerKey, message ));
//    }
//}
//
