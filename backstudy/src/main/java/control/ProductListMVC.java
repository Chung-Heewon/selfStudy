package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.exception.FindException;
import com.my.product.service.ProductService;

/**
 * Servlet implementation class ProductListMVC
 */
public class ProductListMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ProductService service;
	public ProductListMVC() {
		service = new ProductService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터 얻기 현재페이지
		String cp = request.getParameter("cp");
		int currentPage =1;
		if(cp !=null) {
			currentPage=Integer.parseInt(cp);
		}
//		//2)한페이지당 4건씩
//		int cntPerPage = 4;
//		//ex) cp : 1, 2  3
//		int endRow = currentPage*cntPerPage;//         4  8  12
//		int startRow = endRow-cntPerPage+1;//          1  5  9
//		if(endRow> products.size()) {
//			endRow = products.size();
//		}

//		List<String> list = new ArrayList<>();
//		for(int i=startRow-1; i<endRow; i++) {
//			list.add(products.get(i));
//		}


		//2)계산
		try {
			List<String> list= service.findAll(currentPage);
			String path = "/productlistview.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			request.setAttribute("list",list);
			rd.forward(request, response);
		}catch(FindException e) {
			String path ="/err.jsp";
			RequestDispatcher rd = request.getRequestDispatcher(path);
			request.setAttribute("e",e);
			rd.forward(request, response);
		}

//		RequestDispatcher rd = request.getRequestDispatcher(path);
//		request.setAttribute("list", list);
//		//request.parameter(); 개발자가 파라미터로 세팅을 못하고, 요청전달데이터로 자동 채워진다. 
//		rd.forward(request, response);
	}

}
