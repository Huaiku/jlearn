package org.springaop.consert;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ClassicalMusic implements Performance {

	private static final Logger logger = LoggerFactory.getLogger(ClassicalMusic.class);
	
	@Override
	public void perform() {
		logger.info("音乐开始，异常完美的音乐风暴，古典音乐优雅而美丽 ...");
	}

}
