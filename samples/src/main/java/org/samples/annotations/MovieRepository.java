package org.samples.annotations;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository {
	public String getMovieName() {
		return "King..";
	}
}
