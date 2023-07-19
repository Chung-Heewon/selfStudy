package com.my.product.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.product.dt.Product;

/**
 * Servlet implementation class ProductListController
 */
@WebServlet("/productlist")
public class ProductListController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//응답형식
		//TODO
		
		//CORS응답허용
		//TODO
		
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json;charset=utf-8");
		
		PrintWriter out =  response.getWriter();
//		out.print("[\r\n"
//				+ "{\"prodNo\":\"C0001\", \"prodName\":\"아메리카노\",   \"prodPrice\":1000}, \r\n"
//				+ "{\"prodNo\":\"C0002\", \"prodName\":\"아이스아메리카노\",\"prodPrice\":1000}, \r\n"
//				+ "{\"prodNo\":\"C0003\", \"prodName\":\"두가지맛이 그대로\",\"prodPrice\":1500}, \r\n"
//				+ "{\"prodNo\":\"C0004\", \"prodName\":\"유자패션피지오\",    \"prodPrice\":1500}\r\n"
//				+ "]");
		List<Product> list = new ArrayList<>();
		Product p = new Product("C0001", "아메리카노", 1000);
		list.add(p);
		list.add(new Product("C0002", "아이스아메리카노", 1000));
		list.add(new Product("C0003", "두가지맛이 그대로", 1500));
		list.add(new Product("C0004", "유자패션피지오", 2000));
		
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(list);
		System.out.println(jsonStr);
		out.print(jsonStr);
	}

}
