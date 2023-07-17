package com.my.customer.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.customer.dao.Customer;
import com.my.customer.service.CustomerService;
import com.my.exception.FindException;

@WebServlet("/Iddupchk")
public class IdDupChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CustomerService service;

	public IdDupChkServlet() {
		service = new CustomerService ();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id =  request.getParameter("id");
		

		int status = 0;
		try {
			service.idDupChk(id);
			status =1;
		}catch(FindException e) {
			//e.printStackTrace();
			status=0;

		}
		String path="/jsp/iddupchkresult.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("status", status);
		rd.forward(request, response);
	}

}

