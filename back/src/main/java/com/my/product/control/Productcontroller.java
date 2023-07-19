package com.my.product.control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
@WebServlet("/product")
public class Productcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out =  response.getWriter();
		
		Map<String, Object> map = new HashMap<>();
		if(request.getParameter("prodNo").equals("C0001")) {
			//out.print("{/prodNo : \"C0001\", \"prodName\":\"아메리카노\", \"prodPrice\" : 1000}");
			map.put("msg", "{/prodNo : \"C0001\", \"prodName\":\"아메리카노\", \"prodPrice\" : 1000}");
		}else if(request.getParameter("prodNo").equals("C0002")) {
			//out.print("{/prodNo : \"C0002\", \"prodName\":\"아이스아메리카노\", \"prodPrice\" : 1000}");
			map.put("msg","{/prodNo : \"C0002\", \"prodName\":\"아이스아메리카노\", \"prodPrice\" : 1000}");
		}else if(request.getParameter("prodNo").equals("C0003")) {
			//out.print("{/prodNo : \"C0003\", \"prodName\":\"두가지맛 그대로\", \"prodPrice\" : 1500}");
			map.put("msg", "{/prodNo : \"C0003\", \"prodName\":\"두가지맛 그대로\", \"prodPrice\" : 1500}");
		}else if(request.getParameter("prodNo").equals("C0004")) {
			//out.print("{/prodNo : \"C0004\", \"prodName\":\"유자패션피지오\", \"prodPrice\" : 1500}");
			map.put("msg", "{/prodNo : \"C0004\", \"prodName\":\"유자패션피지오\", \"prodPrice\" : 1500}");
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = mapper.writeValueAsString(map);
		System.out.println(jsonStr);
		out.print(jsonStr);
	}

}
