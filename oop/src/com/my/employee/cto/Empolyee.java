package com.my.employee.cto;

import com.my.dto.Person;

public class Empolyee extends Person {
	private String no;
	//private String name;
	private int salary;
	public Empolyee() {
	}
	
	public Empolyee(String no, String name) {
		super();
		this.no = no;
		setName(name);
	}

	public Empolyee(String no, String name, int salary) {
		super();
		this.no = no;
		setName(name);
		this.salary = salary;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
