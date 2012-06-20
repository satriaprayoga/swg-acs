/**
 * 
 */
package com.swg.acs.domain.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.Resource;


/**
 * @author Puradidjaja
 *
 */
public abstract class ACSContext {	
	
	private static ApplicationContext applicationContext;
	
	static{
		applicationContext=new ClassPathXmlApplicationContext("classpath*:META-INF/test-context.xml");
	}
	
	public static ApplicationContext getApplicationContext(){
		return applicationContext;
	}
	
	public static <T> T springConfiguredBean(Class<T> bean){
		return applicationContext.getBean(bean);
	}	

	public static Resource springConfiguredResource(String location){
		return applicationContext.getResource(location);
	}

}
