package test.spring.scheduler.reloadSchedulr;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import kr.co.aim.eas.framework.core.utils.FileUtils;
import kr.co.aim.eas.framework.core.utils.TimeUtils;
import kr.co.aim.eas.framework.core.utils.XmlUtils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;
import org.jdom.Document;
import org.jdom.Element;
import org.quartz.DateBuilder.IntervalUnit;

import com.google.common.collect.Maps;
import com.mchange.lang.IntegerUtils;

/**
 * Scheduler 에 대한 정보를 가지고 있는 객체
 * 
 * @author Spear
 *
 */
public class ReloadSchedulerConfig
{
	public enum Type { thread, simple, cron };
	
	private Type type = Type.thread;
	private long startDelay = 0;
	private long repeatInterval = 0;
	private IntervalUnit intervalUnit = IntervalUnit.MILLISECOND;
	private int repeatCount = 0;
	private int remainCount = 0;
	private String cronExpression = StringUtils.EMPTY;
	
	//ManagerName, memoryUseTime
	private Map<String, Long> managerInfo = Maps.newHashMap();
	
	private ReloadSchedulerConfig() {};
	
	@SuppressWarnings("unchecked")
	public static synchronized ReloadSchedulerConfig load(String filePath) throws FileNotFoundException
	{
		if (FileUtils.exists(filePath) == false)
		{
			throw new FileNotFoundException(filePath);
		}
		
		Document doc = XmlUtils.makeDocumentFilePath(filePath);
		if (doc == null)
		{
			throw new NullPointerException("Cannot parse document. " + filePath);
		}
		
		ReloadSchedulerConfig reloadSchedulerConfig = new ReloadSchedulerConfig();
		
		List<Element> managerProperties = XmlUtils.selectSingleNode(doc, "/configuration/manager").getChildren();
		for(Element e : managerProperties)
		{
//			reloadSchedulerConfig.managerNames.add(e.getAttribute("name").getValue());
			reloadSchedulerConfig.managerInfo.put(e.getAttribute("name").getValue(), NumberUtils.toLong(e.getAttribute("useTime").getValue()));
		}
		
		Element schedulerElements = XmlUtils.selectSingleNode(doc, "/configuration/scheduler");
		reloadSchedulerConfig.type = Type.valueOf(schedulerElements.getChildTextTrim("type"));
		
		reloadSchedulerConfig.startDelay = IntegerUtils.parseInt(schedulerElements.getChildTextTrim("startDelay"), 3600000);
		
		if(reloadSchedulerConfig.startDelay < 3600000)
		{
			reloadSchedulerConfig.startDelay = 3600000;
		}
		
		reloadSchedulerConfig.repeatInterval = NumberUtils.toLong(schedulerElements.getChildTextTrim("repeatInterval"));
		
		if(reloadSchedulerConfig.repeatInterval < 3600000)
		{
			reloadSchedulerConfig.repeatInterval = 3600000;
		}
		
//		reloadSchedulerConfig.intervalUnit = IntervalUnit.valueOf(schedulerElements.getChildTextTrim("intervalUnit"));
		
		reloadSchedulerConfig.repeatCount = IntegerUtils.parseInt(schedulerElements.getChildTextTrim("repeatCount"), 0);
		
		reloadSchedulerConfig.cronExpression = schedulerElements.getChildTextTrim("cronExpression");

		reloadSchedulerConfig.remainCount = reloadSchedulerConfig.repeatCount;
		
		return reloadSchedulerConfig;
	}

	public synchronized Type getType() 
	{
		return type;
	}

	public synchronized  long getStartDelay() {
		return startDelay;
	}

	public synchronized long getRepeatInterval() {
		return repeatInterval;
	}

	public synchronized IntervalUnit getIntervalUnit() {
		return intervalUnit;
	}

	public synchronized int getRepeatCount() 
	{
		return repeatCount;
	}

	
	public synchronized String getCronExpression() {
		return cronExpression;
	}

	public synchronized Map<String, Long> getManagerInfo() {
		return managerInfo;
	}
	
	public synchronized String getNextSchedule()
	{
		long nextDate = TimeUtils.getCurrentTime().getTime() + repeatInterval;
		
		return TimeUtils.getTimeToString(new Date(nextDate), "yyyy-MM-dd HH:mm:ss");
	}

	public synchronized boolean isNextTurn() 
	{
		if(repeatCount == 0)
		{
			return true;
		}
		
		if(remainCount-- > 0)
		{
			return true;
		}
		
		return false;
	}
	
	public synchronized int getRemaincount()
	{
		return remainCount;
	}
}
