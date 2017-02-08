package com.elements.lina;

import java.util.ArrayList;
import java.util.List;

public class Department {

	//private static int deptCount = 0;
	private Integer id;
	private String name;
	private String email;
	private List<Employee> employeeList;
	
	public Department() {
		
	}

	public Department(Integer id, String name, String email) {
		this.id = id;
		this.name = name;
		this.email = email;
	}

	public Department(Integer id, String name, String email, List<Employee> employeeList) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.employeeList = employeeList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Employee> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<Employee> employeeList) {
		this.employeeList = employeeList;
	}
	
	
	//private int deptId;
//	private String deptName;
//    private List<Employee> empList;
    
//	public Department(String deptName) {
//		deptCount++;
//		this.deptName = deptName;
//		this.empList = new ArrayList<Employee>();
//	}
//	public Department(int deptId, String deptName) {
//		deptCount++;
//		this.deptId = deptCount;
//		this.deptName = deptName;
//		
//	}
//	public Department(int deptId, String deptName, List<Employee> empList) {
//		deptCount++;
//		this.deptId = deptCount;
//		this.deptName = deptName;
//		this.empList = empList;
//	}
//	public int getDeptId() {
//		return deptId;
//	}
//	public void setDeptId(int deptId) {
//		this.deptId = deptId;
//	}
//	public String getDeptName() {
//		return deptName;
//	}
//	public void setDeptName(String deptName) {
//		this.deptName = deptName;
//	}
//	public List<Employee> getEmpList() {
//		return empList;
//	}
//	public void setEmpList(List<Employee> empList) {
//		this.empList = empList;
//	}
	
}
