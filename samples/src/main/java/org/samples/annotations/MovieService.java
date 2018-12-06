package org.samples.annotations;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);

	/* 
	 * 此处使用@Qualifier注解来标记了默认候选bean为movieRepository,则在Ioc容器注入时将
	 * 注入名称为movieRepository的bean
	 * 虽然MovieCatalogRepository类标记了@Primary，但是这只是在没有指定候选bean时默认的选择
	 * 当指定了候选Bean时，会注入候选的Bean
	 * 
	 */ 
	@Autowired @Qualifier("movieRepository") private BasicRepository repository;

	public void printName() {
		logger.info("打印默认注入的bean");
		logger.info("Bean Name:{},Bean HashCode:{}", this.repository.getClass().getName(),
				this.repository.getClass().hashCode());
	}
}
