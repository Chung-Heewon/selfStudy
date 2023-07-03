package com.mangoplate.dto;

public class FoodStore {

	private String Businessno; // 사업자 번호
	private String FoodStoreName; // 음식점 이름
	private String Addresses; // 음식점 주소
	private int Categoryno; // 음식점 종류번호
	private String Detail; // 음식점 상세정보

	public String getBusinessno() {
		return Businessno;
	}

	public void setBusinessno(String businessno) {
		Businessno = businessno;
	}

	public String getfoodStoreName() {
		return FoodStoreName;
	}

	public void setfoodStoreName(String storeName) {
		FoodStoreName = storeName;
	}

	public String getAddresses() {
		return Addresses;
	}

	public void setAddresses(String addresses) {
		Addresses = addresses;
	}

	public int getCategoryno() {
		return Categoryno;
	}

	public void setCategoryno(int categoryno) {
		Categoryno = categoryno;
	}

	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}

}
