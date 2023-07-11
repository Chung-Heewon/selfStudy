package control;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class a
 */
public class A extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String aFileRealPath;
	private String developer;


	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext sc = this.getServletContext();
		developer =sc.getInitParameter("developer"); 

		String fileName = this.getInitParameter("fileName");
		aFileRealPath = sc.getRealPath(fileName);

		System.out.println("a.txt파일의 실제경로 : "+aFileRealPath);
		System.out.println("init()호출됨");
	}

	public void destroy() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출됨, 총 개발자 :" +developer);
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(aFileRealPath);
			Scanner sc = new Scanner(fis);
			while(sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(fis!=null) {
				try {
					fis.close();
				}catch(Exception e) {
				}
			}
		}

	}
}
