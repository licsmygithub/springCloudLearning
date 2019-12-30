package com.lics.clouddemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lics.clouddemo.dao.DeptDao;
import com.lics.clouddemo.entity.Dept;
import com.lics.clouddemo.service.DeptService;

@Service
public class DeptServiceImpl implements DeptService{
	@Autowired
	private DeptDao deptDao;

	@Override
	public boolean add(Dept dept) {
		return deptDao.addDept(dept);
	}

	@Override
	public Dept get(Long id) {
		return deptDao.findById(id);
	}

	@Override
	public List<Dept> list() {
		return deptDao.findAll();
	}

	@Override
	public Long getMaxDno() {
		return deptDao.getMaxDno();
	}
	
}
