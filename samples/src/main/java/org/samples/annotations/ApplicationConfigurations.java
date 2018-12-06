package org.samples.annotations;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApplicationConfigurations {
	
	@Bean public PropertyPlaceholderConfigurer yamlPropertyPlaceholderBean() {
		// 解析 yaml
		YamlPropertiesFactoryBean yamlProperty = new YamlPropertiesFactoryBean();
		yamlProperty.setResources(new ClassPathResource("test.yml"));
		// 配置 PropertyPlaceholder
		PropertyPlaceholderConfigurer yamlPropertyPlaceholder = new PropertyPlaceholderConfigurer();
		yamlPropertyPlaceholder.setProperties(yamlProperty.getObject());
		yamlPropertyPlaceholder.setFileEncoding("UTF-8");
		
		return yamlPropertyPlaceholder;
	}
	
	@Bean public YmlConfigTestBean ymlConfigTestBean(@Value("${huaiku.email}")String email,@Value("${huaiku.address}")String address) {
		return new YmlConfigTestBean(email,address);
	}
}
