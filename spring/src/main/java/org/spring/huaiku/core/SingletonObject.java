package org.spring.huaiku.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.stereotype.Component;

/**
 * 
 * @description this is a singleton bean
 * @author huaiku
 * @date Nov 14, 2018-6:22:32 PM
 */  
@Component
public abstract class SingletonObject {
	private static Logger logger = LoggerFactory.getLogger(SingletonObject.class);
	
	//@Autowired
	//private PrototypeObject object;
	
	public void print() {
		PrototypeObject object = objectSupplier();
		logger.info("the class name ==> {},Hashcode==>{}",object.getClassName(),object.hashCode());
	}
	
	@Lookup
	protected abstract PrototypeObject objectSupplier();
}


