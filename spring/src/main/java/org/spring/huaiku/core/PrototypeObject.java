package org.spring.huaiku.core;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 * 
 * @description this is a prototype bean
 * @author huaiku
 * @date Nov 14, 2018-6:19:48 PM
 */
@Component
@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class PrototypeObject {

	public String getClassName() {
		return this.getClass().getName();
	}
}
