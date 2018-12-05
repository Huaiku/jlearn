package org.samples;

import org.samples.annotations.MovieService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Bean public CommandLineRunner test(final MovieService movieService) {
		return (args)-> {
			movieService.printName();
		};
	}
}
