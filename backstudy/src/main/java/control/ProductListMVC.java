package control;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductListMVC
 */
public class ProductListMVC extends HttpServlet {
	private static final long serialVersionUID = 1L;
	List<String>products ;
	@Override
	public void init() throws ServletException {
		super.init();
		products = new ArrayList<>();
		products.add("C0001");
		products.add("C0002");
		products.add("C0003");
		products.add("C0004");
		products.add("F0001");
		products.add("F0002");
		products.add("F0003");
		products.add("G0001");
		products.add("G0002");
		products.add("G0003");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터 얻기 현재페이지
		String cp = request.getParameter("cp");
		int currentPage =1;
		if(cp !=null) {
			currentPage=Integer.parseInt(cp);
		}
		//2)한페이지당 4건씩
		int cntPerPage = 4;
											//ex) cp : 1, 2  3
		int endRow = currentPage*cntPerPage;//         4  8  12
		int startRow = endRow-cntPerPage+1;//          1  5  9
		if(endRow> products.size()) {
			endRow = products.size();
		}
		
		List<String> list = new ArrayList<>();
		for(int i=startRow-1; i<endRow; i++) {
			list.add(products.get(i));
		}
		String path = "/productlistview.jsp";
		RequestDispatcher rd = request.getRequestDispatcher(path);
		request.setAttribute("list", list);
		//request.parameter(); 개발자가 파라미터로 세팅을 못하고, 요청전달데이터로 자동 채워진다. 
		rd.forward(request, response);
	}

}
