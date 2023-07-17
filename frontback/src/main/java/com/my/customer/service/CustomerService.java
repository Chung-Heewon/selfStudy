package com.my.customer.service;

import com.my.customer.dao.Customer;
import com.my.customer.dao.CustomerRepository;
import com.my.exception.AddException;
import com.my.exception.FindException;

public class CustomerService {
	private CustomerRepository repository;
	public CustomerService() {
		repository = new CustomerRepository();
	}

	public void signup(Customer c) throws AddException{
		
		try {
			repository.insert(c); 
		}catch(AddException e) {//id에 해당 고객이 없는 경우(id사용가능한 경우)

		}
	}
	public void idDupChk(String id)throws FindException{
		Customer c = null;
		try {
			//id에 해당고객이 있다.(중복된 경우)
			c = repository.selectById(id); 
		}catch(FindException e) {//id에 해당 고객이 없는 경우(id사용가능한 경우)

		}

		if(c != null) {
			throw new FindException("이미사용중인 아이디입니다.");
		}
	}
	public Customer login(String id, String pwd)
			throws FindException{
		Customer c = repository.selectById(id);
		if(pwd.equals(c.getPwd())) {
			return c;
		}else {
			throw new FindException("로그인실패");
		}
	}
}

