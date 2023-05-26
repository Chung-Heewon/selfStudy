package com.my.product.dto;
public class Product{
	private String prodNo; //comment(주석)상품번호
	private String prodName; //상품이름
	private int prodPrice; //상품가격
	public Product() {
	}
	public Product(String prodNo, String prodName, int prodPrice) {
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public void print() {
		
	}
	public String getProdNo() {
		return prodNo;
	}
	public void setProdNo(String prodNo) {
		if(prodNo.charAt(0)=='s'||prodNo.length()>10){
			System.out.println("상품번호가 잘못되었습니다.");
			return;
		}
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
}
