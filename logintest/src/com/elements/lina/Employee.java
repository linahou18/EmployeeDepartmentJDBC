package com.elements.lina;

public class Employee {

	private static int empCount = 0;

	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	private Department department;
	// private int id;
	// private String name;
	// private int age;

	public Employee() {

	}

	public Employee(Integer id, String firstName, String lastName, Integer age) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public Employee(Integer id, String firstName, String lastName, Integer age, Department department) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.department = department;
	}
	

	public Employee(String firstName, String lastName, Integer age, Department department) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.department = department;
	}

	public static int getEmpCount() {
		return empCount;
	}

	public static void setEmpCount(int empCount) {
		Employee.empCount = empCount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	
	// public Employee(int id, String name, int age, Department department) {
	// empCount++;
	// this.id = empCount;
	// this.name = name;
	// this.age = age;
	// this.department = department;
	// }

	// public Employee(String name, int age, Department department) {
	// empCount++;
	// this.id = empCount;
	// this.name = name;
	// this.age = age;
	// this.department = department;
	// }

	// public Employee(int id, String name, int age) {
	// empCount++;
	// this.id = empCount;
	// this.name = name;
	// this.age = age;
	// }

	// public Employee(String name, int age) {
	// empCount++;
	// this.id = empCount;
	// this.name = name;
	// this.age = age;
	// }

//	public int getId() {
//		return id;
//	}
//
//	public void setId(int id) {
//		this.id = id;
//	}
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public int getAge() {
//		return age;
//	}
//
//	public void setAge(int age) {
//		this.age = age;
//	}
//
//	public Department getDepartment() {
//		return department;
//	}
//
//	public void setDepartment(Department department) {
//		this.department = department;
//	}

}
