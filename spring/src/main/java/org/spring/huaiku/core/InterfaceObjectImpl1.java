package org.spring.huaiku.core;

import org.springframework.stereotype.Component;

@Component
public class InterfaceObjectImpl1 implements InterfaceObject {

	@Override
	public void say(String message) {
		System.out.println("I'm InterfaceObjectImpl1");
	}

}
