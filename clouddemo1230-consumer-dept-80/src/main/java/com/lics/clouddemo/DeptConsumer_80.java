package com.lics.clouddemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.lics.myrule.MySelfRule;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
//@RibbonClient(name="MICROSERVICECLOUD-DEPT",configuration=MySelfRule.class)
//注意MySelfRule这个类不能放在@ComponentScan这个注解所在的包及子包下 @ComponentScan这个注解包含在@SpringBootApplication中，可以点进去查看
public class DeptConsumer_80 {
	public static void main(String[] args) {
		SpringApplication.run(DeptConsumer_80.class, args);
	}
}
