package com.my.asia;

public class Korea {

	public String capital; //누구나 사용할 수 있는 멤버변수
	String language;
	int population; //누구나 사용할 수 없는 멤버변수, 
	public Korea() {
		capital = "서울";
		language= "한국어";
		population = 5174;
	}
	public void print() {
		System.out.println("인구:"+population);
	}
	/**
	 * 인구증가한다
	 */
	public void up() {
		population++;
	}
	/**
	 * 인구감소한다
	 */
	public void down() {
		if(population==0) {
			System.out.println("인구는 0이상이어야 합니다");
			return; //잘못되지 않도록 필터링해야한다. 
		}
		population--;
	}
}