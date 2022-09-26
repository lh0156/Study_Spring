package test.spring.scheduler.product;

import kr.co.aim.eas.framework.core.support.FileChangeListener;
import kr.co.aim.eas.framework.core.support.FileChangeWatcher;
import org.apache.commons.lang3.StringUtils;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 
 * @author Spear
 *
 */
public class EntityReloadManager implements FileChangeListener
{
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	private UserScheduler userScheduler;
	
	private FileChangeWatcher fileChangeWatcher;
	
	@Autowired
	private Environment env;
	
	@SuppressWarnings("unused")
	private void init() throws FileNotFoundException, SchedulerException
	{
		String filePath = env.getProperty("dbreload.configuration");
		if(StringUtils.isBlank(filePath))
		{
			log.debug("No dbreload.configuration argument");
			return;
		}
		
		this.userScheduler = UserScheduleMaker.make(ReloadSchedulerConfig.load(filePath));
		
		if(this.userScheduler != null)
		{
			this.userScheduler.start();
			
			this.fileChangeWatcher = new FileChangeWatcher(filePath, this);
			this.fileChangeWatcher.start();
		}
	}

	@Override
	public void onFileChange(File file) 
	{
		try
		{
		    this.userScheduler.stop();
		    		
			this.userScheduler = UserScheduleMaker.make(ReloadSchedulerConfig.load(file.getCanonicalPath()));
			
			if(this.userScheduler != null)
			{
				this.userScheduler.start();
			}
		}
		catch (Exception e) 
		{
			log.error(e.getMessage(), e);
		}
	}
	
}
