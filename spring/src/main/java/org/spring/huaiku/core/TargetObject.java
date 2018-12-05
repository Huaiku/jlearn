package org.spring.huaiku.core;

import org.springframework.beans.factory.annotation.Required;

public class TargetObject {
	public void print() {
		System.out.println("Hello world...");
	}
	
	private String name;
	
	@Required
	public void setName() {
		
	}
}
