//package test.spring.scheduler.reloadSchedulr;
//
//import kr.co.aim.eas.framework.core.support.Reloadable;
//import kr.co.aim.eos.entity.manager.reloadSchedulr.utils.LogConstants;
//import kr.co.aim.eos.entity.manager.reloadSchedulr.utils.ReloadableContext;
//
//import org.apache.commons.lang3.time.StopWatch;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
///*
// * 일반적인 Thread를 만들어 Scheduler 동작을 시킴
// *
// */
//public class NormalScheduler implements UserScheduler
//{
//	private final Logger log = LoggerFactory.getLogger(this.getClass());
//
//	private ReloadSchedulerConfig reloadSchedulerConfig;
//
//	private Thread normalSchedulerThread;
//
//	public NormalScheduler(ReloadSchedulerConfig reloadSchedulerConfig)
//	{
//		this.reloadSchedulerConfig = reloadSchedulerConfig;
//
//		this.normalSchedulerThread = new Thread(new NormalSchedulerWorker());
//		normalSchedulerThread.setDaemon(true);
//		normalSchedulerThread.setName("NormalScheduler-Thread");
//	}
//
//	@Override
//	public void start()
//	{
//		if(this.normalSchedulerThread != null)
//		{
//			this.normalSchedulerThread.start();
//
//			log.debug(String.format("Start Delay=%s, repeatInterval=%s, repeatCount=%s", this.reloadSchedulerConfig.getStartDelay(), this.reloadSchedulerConfig.getRepeatInterval(), this.reloadSchedulerConfig.getRepeatCount()));
//		}
//		else
//		{
//			throw new NullPointerException("normalSchedulerThread or normalSchedulerWorker is null");
//		}
//	}
//
//	@Override
//	public void stop()
//	{
//		if(this.normalSchedulerThread != null)
//		{
//			this.normalSchedulerThread.interrupt();
//			log.debug("Stop Normal Scheduler.");
//		}
//		else
//		{
//			log.debug("normalSchedulerThread is null.");
//		}
//	}
//
//	class NormalSchedulerWorker implements Runnable
//	{
//		private StopWatch stopWatch = new StopWatch();
//		StringBuilder logStringBuilder = new StringBuilder("Reload Manager List.").append("\n");
//
//		@Override
//		public void run()
//		{
//			try
//			{
//				Thread.sleep(reloadSchedulerConfig.getStartDelay());
//			}
//			catch (Exception e)
//			{
//				log.debug("Error Normal Scheduler Threrad Start");
//				return;
//			}
//
//			long totalTime = 0;
//
//			while(!Thread.currentThread().isInterrupted() && reloadSchedulerConfig.isNextTurn())
//			{
//
//				try
//				{
//					for(String managerName : reloadSchedulerConfig.getManagerInfo().keySet())
//					{
//						stopWatch.start();
//
//						try
//						{
//							Reloadable reloadable =  ReloadableContext.getInstance().getReloadable(managerName);
//							if(reloadable != null)
//							{
//								reloadable.reload();
//
//								stopWatch.stop();
//								logStringBuilder.append(LogConstants.SUCCESS).append(LogConstants.MANAGER_NAME).append(managerName).append(LogConstants.DOT).append(LogConstants.ELAPSED_MILLISECONDS).append(stopWatch.getTime()).append(LogConstants.WORD_BREAK);
//							}
//							else
//							{
//								stopWatch.stop();
//								logStringBuilder.append(LogConstants.FAIL).append(LogConstants.MANAGER_NAME).append(managerName).append(LogConstants.DOT).append(LogConstants.ELAPSED_MILLISECONDS).append(stopWatch.getTime()).append(LogConstants.WORD_BREAK);
//							}
//						}
//						catch (Exception e)
//						{
//							stopWatch.stop();
//							logStringBuilder.append(LogConstants.FAIL).append(LogConstants.MANAGER_NAME).append(managerName).append(LogConstants.DOT).append(LogConstants.ELAPSED_MILLISECONDS).append(stopWatch.getTime());
//						}
//						finally
//						{
//							totalTime += stopWatch.getTime();
//							stopWatch.reset();
//						}
//
//					}//end for
//				}
//				catch (Exception e)
//				{
//					log.error(e.getMessage(), e);
//				}
//				finally
//				{
//					logStringBuilder.append("Total ")
//					.append(LogConstants.ELAPSED_MILLISECONDS)
//					.append(totalTime).append("ms. ")
//					.append("repeatInterval=").append(reloadSchedulerConfig.getRepeatInterval()).append(" ")
//					.append(reloadSchedulerConfig.getIntervalUnit().toString()).append(" ")
//					.append("nextStartTime=").append(reloadSchedulerConfig.getNextSchedule()).append(" ")
//					.append("remainRepeatCount=").append(reloadSchedulerConfig.getRepeatCount() == 0 ? "INFINITE" : reloadSchedulerConfig.getRemaincount());
//
//					totalTime = 0;
//
//					log.debug(logStringBuilder.toString());
//					logStringBuilder.setLength(0);
//					logStringBuilder.append("Reload Manager List Count=").append(reloadSchedulerConfig.getManagerInfo().size()).append(LogConstants.WORD_BREAK);
//
//					try
//					{
//						Thread.sleep(reloadSchedulerConfig.getRepeatInterval());
//					}
//					catch (InterruptedException e)
//					{
//						break;
//					}
//				}
//
//			}//end while
//
//			log.debug("Normal Scheduler Threrad Dead.");
//
//		}//end run method
//
//	}
//
//}
