package org.spring.huaiku.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

/**
 * @Author huaiku
 * @Date 2018年11月14日
 * @description bean register monitor
 */
@Component
public class MonitorApplicationContext implements ApplicationContextAware {
	private static final Logger logger = LoggerFactory.getLogger(MonitorApplicationContext.class);
    
    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
    
    public String[] getAllBeans() {
    	logger.info("get all registered beans name!");
    	return this.applicationContext.getBeanDefinitionNames();
    }
    
}