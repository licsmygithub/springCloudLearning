package com.lics.clouddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lics.clouddemo.entity.Dept;
import com.lics.clouddemo.service.DeptService;

@RestController
public class DeptController {
	
	@Autowired
	private DeptService deptService;
	@Autowired
	private DiscoveryClient client;
	
	@RequestMapping(value = "dept/add",method = RequestMethod.POST)
	private boolean add(@RequestBody Dept dept) { 
		Long dno = deptService.getMaxDno();
		dept.setDeptno(dno+1);
		return deptService.add(dept);
	}
	
	@RequestMapping(value = "dept/get/{id}",method = RequestMethod.GET)
	private Dept get(@PathVariable("id") Long id) {
		return deptService.get(id);
	}
	
	@RequestMapping(value = "dept/list",method = RequestMethod.GET)
	private List<Dept> list(){
		return deptService.list();
	}
	
	//服务发现
	@RequestMapping(value = "/dept/discovery", method = RequestMethod.GET)
	public Object discovery()
	{
		List<String> list = client.getServices();
		System.out.println("**********" + list);

		List<ServiceInstance> srvList = client.getInstances("MICROSERVICECLOUD-DEPT");
		for (ServiceInstance element : srvList) {
			System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
					+ element.getUri());
		}
		return this.client;
	}
}
