package org.springaop.soundsystem;

import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springaop.consert.Pointcut;

@Component
@Aspect
public class TrackCounter {

	private static final Logger logger = LoggerFactory.getLogger(TrackCounter.class);
	private Map<Integer, Integer> trackCounters = new HashMap<Integer, Integer>();

	@Before(Pointcut.performanceTrackCounter)
	public void countTrack(int trackNumber) {
		int currentNumber = getCounter(trackNumber);
		logger.info("fected key:{},value:{}", new Object[] { trackNumber, currentNumber });
		trackCounters.put(trackNumber, ++currentNumber);
	}

	/**
	 * @param trackNumber
	 * @return
	 */
	private Integer getCounter(int trackNumber) {
		logger.info("get counter ,key :{}", new Object[] { trackNumber });
		return trackCounters.containsKey(trackNumber) ? trackCounters.get(trackNumber) : 0;
	}
}
