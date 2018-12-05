package org.spring.huaiku.core;

import org.springframework.stereotype.Component;

@Component
public class SubImplement1 extends ParentObject {
	public void say() {
		System.out.println("haha ...SubImplement1");
	}
}
