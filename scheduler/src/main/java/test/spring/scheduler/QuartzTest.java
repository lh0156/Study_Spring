package test.spring.scheduler;  // file: QuartzTest.java
  import org.quartz.JobDetail;
  import org.quartz.Scheduler;
  import org.quartz.SchedulerException;
  import org.quartz.Trigger;
  import org.quartz.impl.StdSchedulerFactory;
  import static org.quartz.JobBuilder.*;
  import static org.quartz.TriggerBuilder.*;
  import static org.quartz.SimpleScheduleBuilder.*;

  public class QuartzTest {

      public static void main(String[] args) {

          try {
              // Grab the Scheduler instance from the Factory
              Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();

              // and start it off
              scheduler.start();

              JobDetail job = newJob(QuartzJob1.class)
                      .withIdentity("job1", "group1")
                      .build();

              Trigger trigger = newTrigger()
                      .withIdentity("trigger1", "group1")
                      .startNow()
                      .withSchedule(simpleSchedule()
                              .withIntervalInSeconds(40)
                              .repeatForever())
                      .build();

              scheduler.scheduleJob(job, trigger);


              scheduler.shutdown();

          } catch (SchedulerException se) {
              se.printStackTrace();
          }
      }
  }