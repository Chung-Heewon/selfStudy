package com.my.product.dt;

import java.io.Serializable;
import java.util.Objects;

public class Product implements Serializable{ //직렬화
	private String prodNo; //comment(주석)상품번호
	private String prodName; //상품이름
	transient private int prodPrice; //상품가격 //직렬화에서 제외
	public Product() {
	}
	public Product(String prodNo, String prodName, int prodPrice) {
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
	}
	public void print() {
		System.out.println("상품번호:"+prodNo+"상품이름:"+prodName+"상품가격:"+prodPrice);
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
	@Override
	public int hashCode() {
		return Objects.hash(prodNo);
	}
	@Override
	/**
	 * @param obj 상품객체
	 * @return 현재객체의 상품번호와 obj객체의 상품 상품번호가 같으면 true 반환
	 * 			그외는 false 반환
	 *			ex) equals(new String()); 결과는 false
	 *			ex) equals (null); 결과는 false
	 */
	public boolean equals(Object obj) {
//		if(!(obj instanceof Product)) {//obj 참조변수는 product type의 객체인가?
//			return false;
//		}
//		Product p = (Product)obj;
//		if(this.prodNo == null || p == null) { //null 포인트 exception 이 발생하지 않도록 필터링
//			return false;
//		}
//		return this.prodNo.equals(p.prodNo); 
//		//return false;
		if(obj != null && obj instanceof Product) {
			Product p = (Product)obj;
			if(this.prodNo !=null) {
				return this.prodNo.equals(p.prodNo);
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", prodName=" + prodName + ", prodPrice=" + prodPrice + "]";
	}
	
}
