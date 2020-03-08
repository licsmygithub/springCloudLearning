package com.lics.clouddemo.cfgbean;


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;

@Configuration
public class ConfigBean {//相当于spring的配置文件 applicationContext.xml
	@Bean
	@LoadBalanced////Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端   负载均衡的工具。
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	@Bean
	public IRule myRule() {
		return new RandomRule();//用随机算法替代轮询算法
		//return new RetryRule();//轮询算法，如果有一个服务挂掉了，前几次仍然会访问这个挂掉的服务，但经过几次之后，就不会再去访问这个挂掉的服务。
	}
}
