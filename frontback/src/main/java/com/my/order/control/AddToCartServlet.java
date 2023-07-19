package com.my.order.control;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addtocart")
public class AddToCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String prodNo = request.getParameter("prodNo"); //상품번호
		String qt = request.getParameter("qt"); //상품수량


		int quantity = 0;
		if(qt != null && !qt.equals("")) {
			quantity = Integer.parseInt(qt);
		}
		HttpSession session = request.getSession();
		Map<String, Integer>cart = (Map)session.getAttribute("cart");
		if(cart == null) {
			cart =  new HashMap<>();
			session.setAttribute("cart", cart);
		}
		Integer totalQuantity  = cart.get(prodNo); 
		if(totalQuantity != null) {
			quantity += totalQuantity;
		}
		cart.put(prodNo, quantity);

		System.out.println("현재장바구니:" + cart);

		//session 지우기
//				HttpSession session = request.getSession();
//				session.removeAttribute("cart");
//				session.invalidate(); //session을 죽이는 작업
	}
}
