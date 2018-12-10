package org.springaop.groovy

import org.springframework.stereotype.Component

interface Pointcut {
	// 切点表达式,可重用切面
	String performancePointcut = 'execution(** org.springaop.consert.Performance.perform(..))';
	String performanceTrackCounter = 'execution(* org.springaop.soundsystem.CompactDisc.playTrack(int)) && args(trackNumber)';
}
