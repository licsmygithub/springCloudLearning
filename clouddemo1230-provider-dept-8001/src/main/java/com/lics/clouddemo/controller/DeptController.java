package com.lics.clouddemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@RequestMapping(value = "dept/add",method = RequestMethod.POST)
	private boolean add(@RequestBody Dept dept) { 
		Long dno = deptService.getMaxDno();
		dept.setDeptno(dno);
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
}
