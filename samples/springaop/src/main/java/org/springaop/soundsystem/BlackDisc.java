package org.springaop.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class BlackDisc implements CompactDisc{

	@Override
	public Integer playTrack(int trackNumber) {
		return ++trackNumber;
	}
}
