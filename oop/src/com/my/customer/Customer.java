package com.my.customer;

public class Customer { // 
	private String id;
	private String pwd;
	private String name;
	private boolean flag; //결혼여부
	public void setId(String id) { //setter 메서드 : set프로퍼티첫글자대문자
		this.id = id;
	}
	public String getId() {
		return id; //get매서드를 반환하는 역할
	}
	public void setPwd(String pwd) {
		this.pwd=pwd;
	}
	public String getPwd() {
		return pwd;
	}
	public void setName(String name) {
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public boolean isFlag() { // boolean 타입의 get 메서드는 is로 만들기
		return flag;
	}
}
//상품이름이나 고객정보를 만들 때 set/get 메서드를 만드는 이유
