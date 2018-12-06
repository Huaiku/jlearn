package org.samples.annotations;

import org.springframework.stereotype.Component;

@Component
public class IntegerStore implements Store<Integer>{
	@Override
	public Integer get() {
		return 1;
	}
}
