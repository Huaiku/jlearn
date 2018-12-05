package org.spring.huaiku.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
public class BeanAnnotation {
	
	@Lazy(value=true)
	@Bean
	public TargetObject targetObject() {
		return new TargetObject();
	}
	
	@Autowired
	@Qualifier("interfaceObjectImpl1")
	private InterfaceObject object;
	
	@Autowired
	@Qualifier("interfaceObjectImpl2")
	private InterfaceObject object2;
	
	public void print() {
		object.say("This is the first object");
	}
	
	public void print2() {
		object2.say("This is the second object");
	}
	
	
	@Autowired
	@Qualifier("subImplement1")
	private ParentObject pojSub1;
	
	@Autowired
	@Qualifier("subImplement2")
	private ParentObject pojSub2;
	
	public void say() {
		pojSub1.say();
		pojSub2.say();
	}
}
