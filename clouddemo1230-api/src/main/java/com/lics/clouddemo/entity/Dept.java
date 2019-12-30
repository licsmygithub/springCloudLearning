package com.lics.clouddemo.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
//@AllArgsConstructor全参构造函数
@NoArgsConstructor//无参构造函数
@Data//get set方法
//@Accessors(chain = true)//链式写法
public class Dept implements Serializable// entity --orm--- db_table 类表关系映射 必须序列化
{
	private Long 	deptno; // 主键
	private String 	dname; // 部门名称
	private String 	db_source;// 来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
	
	public Dept(Long dno,String dname)
	{
		super();
		this.dname = dname;
		this.deptno = dno;
	}
	
//	public static void main(String[] args) {
//		Dept dept = new Dept();
//		dept.setDeptno(11L).setDname("123").setDb_source("123");//链式写法
//		System.err.println(dept);
//	}
}
