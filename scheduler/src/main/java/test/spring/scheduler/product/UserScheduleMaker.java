package test.spring.scheduler.product;

import org.apache.commons.lang.NullArgumentException;
import org.quartz.SchedulerException;

/**
 * 
 * 
 * @author Spear
 *
 */
public abstract class UserScheduleMaker 
{
	/**
	 * ReloadSchedulerConfig 의 Type에 해당하는 UserScheduler 객체를 생성하여 반환 합니다.
	 * 
	 * @param config
	 * @return
	 * @throws SchedulerException 
	 */
	public static UserScheduler make(ReloadSchedulerConfig config) throws SchedulerException
	{
		if(config == null)
		{
			throw new NullArgumentException("config");
		}
		
		switch(config.getType())
		{
			case thread:
				return new NormalScheduler(config);
			case cron:
				return new CronScheduler(config);
		}
		
		return null;
	}
	
}
