package com.my.customer.control;

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


@WebServlet("/signup")
public class SignupControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		response.setHeader("Access-Control-Allow-Origin","*");
		response.setContentType("application/json;charset=utf-8"); //응답형식 : 표준MIME방식 //"text/html;charset=utf-8"
		PrintWriter out = response.getWriter();


		String id = request.getParameter("id");
		Map<String, Object> map = new HashMap<>(); //?=> 어떤 자료형이든 가능하다. 
		if(id.equals("admin")){
//			out.print("0, ");
//			out.print("이미 존재하는 아이디입니다");
			//out.print("{\"status\" : 0, \"msg\" : \"이미 존재하는 아이디입니다.\"}");
			map.put("status",0);
			map.put("msg", "이미 존재하는 아이디입니다.");
		}else {
			//out.print("{\"status\" : 1, \"msg\" : \"가입성공\"}");
			// JSON 문자열 형태로 응답하기
			map.put("status", 1);
			map.put("msg","가입성공");
		}
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr =mapper.writeValueAsString(map);
		System.out.println(jsonStr);
		out.print(jsonStr);
		
	}
}
