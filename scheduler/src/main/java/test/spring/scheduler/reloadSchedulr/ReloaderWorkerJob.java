package test.spring.scheduler.reloadSchedulr;

import java.util.Map.Entry;

import kr.co.aim.eas.framework.core.utils.TimeUtils;
import kr.co.aim.eos.entity.manager.reloadSchedulr.utils.ReloadableContext;
import kr.co.aim.eos.entity.manager.support.EntityQuery;
import kr.co.aim.eos.entity.manager.support.RuntimeEntityManager;
import kr.co.aim.eos.entity.manager.support.InMemory.Operators.QueryOperators;

import org.apache.commons.lang3.math.NumberUtils;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Spear
 *
 */
public class ReloaderWorkerJob implements Job
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException 
	{
		try
		{
			JobDataMap dataMap = context.getJobDetail().getJobDataMap();
			
			long currentTime = TimeUtils.getCurrentTime().getTime();
			
			for(Entry<String, Object> entry : dataMap.entrySet())
			{
/*				Reloadable reloadable = ReloadableContext.getInstance().getReloadable(entry.getKey());
				if(reloadable != null)
				{
					reloadable.reload();
				}*/
				
				RuntimeEntityManager<?> runtimeEntityManager = ReloadableContext.getInstance().getRuntimeEntityCleaner(entry.getKey());
				if(runtimeEntityManager != null)
				{
					long baseTime = currentTime - NumberUtils.toLong(entry.getValue().toString());
					runtimeEntityManager.clear(new EntityQuery("CreateTime", new EntityQuery(QueryOperators.LTE.toString(), baseTime)));
				}
			}
			
		}
		catch (Exception e) 
		{
			log.error(e.getMessage(), e);
		}
		
	}
	
}
