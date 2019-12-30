package com.lics.clouddemo.cfgbean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {//相当于spring的配置文件 application.xml
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
}
