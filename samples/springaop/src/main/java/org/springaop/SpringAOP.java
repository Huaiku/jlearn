package org.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaop.user.UserHandler;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringAOP {

	private static final Logger logger = LoggerFactory.getLogger(SpringAOP.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringAOP.class, args);
	}

	@Bean public CommandLineRunner test(final UserHandler handler) {
		return args -> {
			String userName = handler.getUserName();
			logger.info("user name: {}",userName);
			logger.info("proxy:{},{}",handler,handler.getClass());
		};
	}
}
