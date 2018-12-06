package org.samples;

import org.samples.annotations.YmlConfigTestBean;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SampleApplication {
	private static final Logger logger = LoggerFactory.getLogger(SampleApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(SampleApplication.class, args);
	}

	@Bean public CommandLineRunner test(final YmlConfigTestBean bean) {
		return (args)-> {
			logger.info("打印....");
			bean.print();
		};
	}
}
