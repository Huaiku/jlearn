package org.samples.annotations;

import org.springframework.stereotype.Repository;

@Repository
public class MovieRepository implements BasicRepository{
	public String getMovieName() {
		return "King..";
	}
}
