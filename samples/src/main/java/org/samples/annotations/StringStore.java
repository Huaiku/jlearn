package org.samples.annotations;

import org.springframework.stereotype.Component;

@Component
public class StringStore implements Store<String>{
	@Override
	public String get() {
		return "String..";
	}
}
