package com.accenture.model;


//data coming from user goes to model
public class EmployeeModel {

	private int empId;
	private String empName;
	private double salary;
	private int age;

	public EmployeeModel() {
		super();
	}

	public EmployeeModel(int empId, String empName, double salary, int age) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.salary = salary;
		this.age = age;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "EmployeeModel [empId=" + empId + ", empName=" + empName + ", salary=" + salary + ", age="
				+ age + "]";
	}

}
