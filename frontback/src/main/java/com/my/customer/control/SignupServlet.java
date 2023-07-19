package com.my.customer.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.customer.dao.Customer;
import com.my.customer.service.CustomerService;
import com.my.exception.AddException;
import com.my.exception.FindException;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;
	public SignupServlet() {
	//service = new CustomerService();	
		service = CustomerService.getInstance();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id =  request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		
		Customer c = new Customer(id,pwd,name);
		
		int status = 0;
		
			try {
				service.signup(c);
				status =1;
			} catch (AddException e) {
				//e.printStackTrace(); 
				status=0;
				
			}
		
		String path="/jsp/signupresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
	}

}
