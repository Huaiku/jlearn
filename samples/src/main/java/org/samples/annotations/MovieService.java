package org.samples.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
	
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	private final MovieRepository movieRepository;
	
	@Autowired public MovieService(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}
	
	public void printName() {
		String name = this.movieRepository.getMovieName();
		logger.info("Movie Name: {}",name);
	}
}
