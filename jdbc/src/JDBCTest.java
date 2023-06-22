
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.my.sql.MyConnection;

public class JDBCTest {
	public static void testProductList() {
		//1. JDBC드라이버 로드 Class.forName()
		//2. DB연결 Connection
		//3. SQL구문을 오라클서버로 송신 : Statement, PreparedStatment-바인드변수(?)사용가능
								//excecuteQuery()SELECT, excecuteUpdate()- 그외처리
		//4. 송신결과 수신 :               ResultSet,         int
		//5. 결과 활용    :                rs.next()-커서 다음행으로 이동
		//6. DB연결해제	:              close()
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();//1~2
		}catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		Statement stmt=null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			String selectSQL = "SELECT * FROM product";
			rs = stmt.executeQuery(selectSQL);
			while(rs.next()) {
				String no = rs.getString(1);
				String name = rs.getString("prod_name");
				int price= rs.getInt("prod_price");
				System.out.println(no + "-" + name + "-" + price);
			}			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(rs, stmt, conn);
		}
	}

	public static void testProductPageList(){
		Connection conn=null;
		try {
			conn=MyConnection.getConnection();
		}catch(ClassNotFoundException |SQLException e) {
			e.printStackTrace();
			return;
		}
		//Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.println("검색할 페이지를 입력하세요 : ");

		int currentPage = Integer.parseInt(sc.nextLine()); 
		//검색할 페이지 ex)1 2 3
		int cntPerPage = 3; //페이지당 보여줄 목록수 
		int startRow = (currentPage-1)*(cntPerPage)+1; //페이지의 시작행 1 4 7
		int endRow = currentPage*cntPerPage; // 페이지의 끝행              3 6 9
		try {
			//			//stmt = conn.createStatement();
			//			String SelectPageSQL = "SELECT *\r\n"
			//					+ "FROM (SELECT rownum rn, a.*\r\n"
			//					+ "    FROM (SELECT*\r\n"
			//					+ "        FROM product\r\n"
			//					+ "        ORDER BY prod_name)a)\r\n"
			//					+ "WHERE rn BETWEEN "+startRow +" AND "+ endRow;
			//			rs = stmt.executeQuery(SelectPageSQL);
			// bind 변수 : 값이 대입될 위치에 ?를 대입 => 값 대신 "?"
			String selectPageSQL = "SELECT *\r\n"
					+ "FROM (SELECT rownum rn, a.*\r\n"
					+ "    FROM (SELECT*\r\n"
					+ "        FROM product\r\n"
					+ "        ORDER BY prod_name)a)\r\n"
					+ "WHERE rn BETWEEN ? AND ?";
			pstmt = conn.prepareStatement(selectPageSQL);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2,endRow);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				int rowNum = rs.getInt("rn");
				String prodNo = rs.getString("prod_no");
				String prodName = rs.getString("prod_name");
				int prodPrice = rs.getInt("prod_price");
				System.out.println(rowNum+":"+prodNo+"-"+prodName+"-"+prodPrice);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(rs, pstmt, conn);
		}
	}
	public static void testProductUpdate() {
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		}catch (ClassNotFoundException | SQLException e ) {
			e.printStackTrace();
			return;
		}
		Scanner sc = new Scanner(System.in);
		System.out.print("상품번호 : ");
		String prodNo = sc.nextLine();
		
		System.out.print("변경할 가격 : ");
		int prodPrice = Integer.parseInt(sc.nextLine());
		
		//String updateSQL = "UPDATE product SET prod_price="+ prodPrice +" WHERE prod_no='"+prodNo+"'";
		//Statement stmt = null;
		String updateSQL = 
				"UPDATE product SET prod_price=? WHERE prod_no=?";
		PreparedStatement pstmt = null;
		try {
//			stmt= conn.createStatement();
//			int rowcnt = 
//					stmt.executeUpdate(updateSQL); //송신 : DML(INSERT/UPDATE/DELETE)-처리건수반환
			//      DDL(CREATE/ALTER/DROP)- 0반환
			pstmt = conn.prepareStatement(updateSQL);
			pstmt.setInt(1, prodPrice);
			pstmt.setNString(2, prodNo);
			int rowcnt = pstmt.executeUpdate();
			if(rowcnt ==0) {
				System.out.println("수정된 상품이 없습니다.");
			}else {
				System.out.println(rowcnt+"건의 상품이 수정되었습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(null, pstmt, conn); //꼭 CLOSE!!
		}

	}
	public static void main(String[] args) {
		testProductList();
//		testProductPageList();
//		testProductUpdate();
	}
}