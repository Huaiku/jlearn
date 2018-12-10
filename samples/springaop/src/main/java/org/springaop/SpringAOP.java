package org.springaop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springaop.consert.ClassicalMusic;
import org.springaop.soundsystem.BlackDisc;
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

	@Bean
	public CommandLineRunner test(final ClassicalMusic music,final BlackDisc disk) {
		return args -> {
			//music.perform();
			logger.info("测试开始....");
			disk.playTrack(1);
			disk.playTrack(1);
			disk.playTrack(1);
			disk.playTrack(2);
			disk.playTrack(3);
			disk.playTrack(4);
		};
	}
}
