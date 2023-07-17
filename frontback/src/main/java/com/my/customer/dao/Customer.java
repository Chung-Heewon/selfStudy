package com.my.customer.dao;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Customer { // 
	private String id;
	private String pwd;
	private String name;
//	private boolean flag; //결혼여부
}
//상품이름이나 고객정보를 만들 때 set/get 메서드를 만드는 이유
