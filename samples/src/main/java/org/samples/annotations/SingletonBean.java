package org.samples.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

@Component
public abstract class SingletonBean {
	private static final Logger logger = LoggerFactory.getLogger(SingletonBean.class);
	
	public void print() {
		PrototypeBean bean = methodInject();
		logger.info("Bean SingletonBean's HashCode : {}",bean.hashCode());
		bean.say();
	}
	
	@Lookup
	protected abstract PrototypeBean methodInject();
}
