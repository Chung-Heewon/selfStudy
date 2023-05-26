package com.my.sudenta.dto;

import com.my.dto.Person;

public class student  extends Person{ //java는 단일상속
	private String no;
	//private String name; //상속받아서 기능등을 똑같이 쓸 수 있다.
	public student() {
		super(); //생성자 호출될때 부모영역이 먼저 할당되고 자식영역이 할당된다.
	}
	public student(String no, String name) {
		super();
		this.no = no;
		setName(name);
	}
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public void print() {
		System.out.println("학번:"+no+",이름:"+super. getName()); 
		//super - 현재 사용중인 개체의 부모영역 , this = 현재 사용중인 객체
	}
}
