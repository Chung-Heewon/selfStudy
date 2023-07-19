package com.my.order.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.my.customer.dao.Customer;
import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.order.dao.OrderRepository;
import com.my.order.dto.OrderInfo;
import com.my.order.dto.OrderLine;

public class OrderService {
	private static OrderService service = new OrderService ();
	private OrderRepository repository;
	
	public OrderService() {
		repository= new OrderRepository();
	}
	
	public static OrderService getInstance() {
		return service;
	}
	//public void add(OrderInfo info) throws AddException{
	public void add(String loginedId, 
					Map<String, Integer>cart) throws AddException{	
		OrderInfo info = new OrderInfo(); //주문기본
		info.setOrderId(loginedId);
		
		List<OrderLine> lines = new ArrayList<>(); //주문상세들
		//for(String prodNo : cart.keySet()) {
		Set<String>keys = cart.keySet();
		for(String prodNo : keys) {
			OrderLine line = new OrderLine();
			line.getOrderP().getProdNo();
			line.setOrderQuantity(cart.get(prodNo));
			lines.add(line);
		}
		info.setLines(lines);

		repository.insert(info);
	}
	public List<OrderInfo> findById(String id)throws FindException{
		List<OrderInfo> list = new ArrayList<>();
		
		repository.selectById(id);
		return list;
	}
}
