//package test.spring.scheduler.generalQuartz;
//
//import org.quartz.JobExecutionContext;
//import org.quartz.JobExecutionException;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.scheduling.quartz.QuartzJobBean;
//import org.springframework.stereotype.Component;
//
//@Component
//public class HankerJobA extends QuartzJobBean {
//
//    private static final Logger log = LoggerFactory.getLogger(HankerJobA.class);
//
//    @Override
//    protected void executeInternal(JobExecutionContext jobExecutionContext) throws JobExecutionException {
//        log.info("매 시간 실행 될 작업 작성 공간");
//    }
//}