package org.spring.huaiku;

import java.util.Arrays;

import org.spring.huaiku.core.BeanAnnotation;
import org.spring.huaiku.core.MonitorApplicationContext;
import org.spring.huaiku.core.ParentObject;
import org.spring.huaiku.core.SingletonObject;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * 
 * @description all about spring framework
 * @author huaiku
 * @date Nov 14, 2018-10:20:33 AM
 */
@SpringBootApplication
public class SpringHuaiku {
	public static void main(String[] args) {
		SpringApplication.run(SpringHuaiku.class, args);
	}

	@Bean public CommandLineRunner init(final MonitorApplicationContext monitor) {
		return (args) -> {
			Arrays.stream(monitor.getAllBeans()).forEach(System.out::println);

		};
	}

	@Bean public CommandLineRunner methodInjectTest(final SingletonObject object) {
		return (args) -> {
			int i = 0;
			while (i <= 5) {
				i++;
				object.print();
				Thread.sleep(2000);
			}
		};
	}
	
	@Bean public CommandLineRunner qualifierTest(final BeanAnnotation object) {
		return (args) -> {
			object.print();
			object.print2();
			
			object.say();
		};
	}
}
