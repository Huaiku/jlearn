package org.samples.annotations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class StoreHandler {
	private static final Logger logger= LoggerFactory.getLogger(StoreHandler.class);
	
	@Autowired private Store<Integer> integerStore;
	@Autowired private Store<String> stringStore;
	
	public StoreHandler() {
		logger.info("bean 注册...");
	}
	public void test() {
		logger.info("test bean type");
		logger.info("IntegerStore get():{},StringStore get():{}",integerStore.get(),stringStore.get());
	}
	
	@PostConstruct
	public void beforeRegister() {
		logger.info("bean注册之后执行的方法....");
	}
	
	@PreDestroy
	public void beforeDestory() {
		logger.info("bean销毁之前执行的操作....");
	}
}
