package test.spring.scheduler.reloadSchedulr;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.quartz.CronTrigger;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 
 * @author Spear
 *
 */
public class CronScheduler implements UserScheduler 
{
	private ReloadSchedulerConfig reloadSchedulerConfig;
	private JobDetail jobDetail;
	private CronTrigger trigger;
	private Scheduler scheduler;
	
	public CronScheduler(ReloadSchedulerConfig reloadSchedulerConfig) throws SchedulerException
	{
		this.reloadSchedulerConfig = reloadSchedulerConfig;
		
		this.init();
	}

	@Override
	public void start() 
	{
		try 
		{
			this.scheduler.start();
		}
		catch (SchedulerException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public void stop() 
	{
		try 
		{
			this.scheduler.shutdown();
		}
		catch (SchedulerException e)
		{
			e.printStackTrace();
		}
	}

	private void init() throws SchedulerException
	{
		this.makeJobDetail();
		this.makeCronTrigger();
		this.makeScheduler();
	}

	private void makeJobDetail() throws SchedulerException
	{
		this.jobDetail = JobBuilder.newJob().ofType(ReloaderWorkerJob.class)
				.storeDurably()
				.withIdentity("Qrtz_Job_Detail")
				.withDescription("Invoke Sample Job service...")
				.build();
		
		for(Entry<String, Long> entry : this.reloadSchedulerConfig.getManagerInfo().entrySet())
		{
			this.jobDetail.getJobDataMap().put(entry.getKey(), entry.getValue());
		}
	}
	
	private void makeCronTrigger()
	{
		if(this.reloadSchedulerConfig != null)
		{
			String expression;
			
			if(StringUtils.isBlank(this.reloadSchedulerConfig.getCronExpression()))
			{
				expression = "0 0 1 * * ?";
			}
			else
			{
				expression = this.reloadSchedulerConfig.getCronExpression();
			}
			
			this.trigger = newTrigger().withIdentity("trigger1", "group1").withSchedule(cronSchedule(expression)).build();
		}
	}
	
	private void makeScheduler() throws SchedulerException
	{
		SchedulerFactory sf = new StdSchedulerFactory();
		this.scheduler = sf.getScheduler();
		
		this.scheduler.scheduleJob(this.jobDetail, this.trigger);
	}
	
}
