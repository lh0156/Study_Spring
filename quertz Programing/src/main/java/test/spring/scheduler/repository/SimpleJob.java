//package test.spring.scheduler;
//
//import org.quartz.Job;
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.stereotype.Component;
//
//@Component
//public class SimpleJob implements Job {
//
//    private static final Logger log = LoggerFactory.getLogger(SimpleJob.class);
//
//    public void execute(JobExecutionContext context) throws JobExecutionException {
//        log.info("매 시간 실행 될 작업 작성 공간");
//    }
//}