package test.spring.scheduler.reloadSchedulr.utils;

import kr.co.aim.eas.framework.core.support.Reloadable;
import kr.co.aim.eos.entity.manager.support.EntitySuperManager;
import kr.co.aim.eos.entity.manager.support.RuntimeEntityManager;

import org.springframework.beans.factory.annotation.Autowired;

public class ReloadableContext
{
	private static ReloadableContext reloadableContext;
	
	public ReloadableContext()
	{
		reloadableContext = this;
	}
	
	public static ReloadableContext getInstance()
	{
		return reloadableContext;
	}
	
	@Autowired
	private EntitySuperManager entitySuperManager;
	
	public Reloadable getReloadable(String name)
	{
		return this.entitySuperManager.getEntityManager(name, Reloadable.class);
	}
	
	public RuntimeEntityManager<?> getRuntimeEntityCleaner(String name)
	{
		return this.entitySuperManager.getEntityManager(name, RuntimeEntityManager.class);
	}
}
