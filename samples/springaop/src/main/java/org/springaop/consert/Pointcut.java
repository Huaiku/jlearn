package org.springaop.consert;

public interface Pointcut {
	static String performancePointcut = "execution(** org.springaop.consert.Performance.perform(..))";
	static String performanceTrackCounter = "execution(* org.springaop.soundsystem.CompactDisc.playTrack(int)) && args(trackNumber)";
}
