package org.spring.huaiku.core;

import org.springframework.beans.factory.annotation.Required;

@SuppressWarnings("deprecation")
public class TargetObject {
	public void print() {
		System.out.println("Hello world...");
	}
	
	@Required
	public void setName() {
		
	}
}
