package com.mangoplate.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mangoplate.dto.Menu;
import com.mangoplate.exception.AddException;
import com.mangoplate.sql.MangoplateConnection;

public class MenuRepository {
	
	PreparedStatement pstmt;
	Statement stmt;
	ResultSet rs;
	public static void search(Menu menu) throws AddException {
		Connection conn = null;
		try {
			conn = MangoplateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}		
		Statement stmt = null;
		ResultSet rs=null;
		//		String searchSQL ="SELECT * FROM menu WHERE businessno='" + menu.getBusinessno() + "'";
		try {
			stmt = conn.createStatement();
//			String searchSQL = "SELECT * FROM menu ";
			
		    String searchSQL = "SELECT * FROM menu";
		    String businessno = menu.getBusinessno();
		    
		    if (businessno != null && !businessno.isEmpty()) {
		    	searchSQL += " WHERE businessno = '" + businessno + "'";
		    }
			
			rs = stmt.executeQuery(searchSQL);
			System.out.println("----------------------음식점의 메뉴리스트입니다--------------------");	
			System.out.printf("메뉴번호      사업번호      카테고리명      메뉴이름      메뉴가격      메뉴상세\n");
			while(rs.next()) {
				int no = rs.getInt("menuno");
				String bno = rs.getString("businessno");				
				int ctno = rs.getInt("categoryno");				
				String name = rs.getString("menuname");
				int price = rs.getInt("menuprice");
				String detail = rs.getString("menudetail");						
				System.out.printf(String.format("%-12s%-14s%-12s%-9s%-10s%s\n", no, bno, ctno, name, price, detail));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}	finally {
			MangoplateConnection.close(rs, stmt, conn); 
		}
	}
	
	public static void update(Menu menu) throws AddException {	
		Connection conn = null;
		try {
			conn = MangoplateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}
		PreparedStatement pstmt = null;
		ResultSet rs=null;
			String updateSQL =
				"UPDATE menu SET Categoryno=?,Menuname=?, MenuPrice=?, Menudetail=? WHERE MenuNo=?";
			try {
			pstmt = conn.prepareStatement(updateSQL);
			
			pstmt.setInt(1, menu.getCategoryno());
//			pstmt.setString(2,menu.getBusinessno());
			pstmt.setString(2, menu.getMenuname());
			pstmt.setInt(3, menu.getMenuprice());			
			pstmt.setString(4, menu.getMenudetail());	
			pstmt.setInt(5, menu.getMenuno());			
			
			int rowcnt = pstmt.executeUpdate();
			if(rowcnt == 0) {
				System.out.println("수정할 상품이 없습니다");
				return;
			}else {
				System.out.println(rowcnt+"건의 상품이 수정되었습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		//	throw new AddException(e.getMessage());
		} finally {
			System.out.println("변경완료");
			MangoplateConnection.close(null, pstmt, conn); 
		}
	}

	public static void add(Menu menu) throws AddException {
		Connection conn = null;
		try {
			conn = MangoplateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}
		String insertSQL =
				"INSERT INTO menu VALUES (menu_seq.nextval,?,?,?,?,?)";	
		PreparedStatement pstmt = null;
		
		//Scanner sc = new Scanner(System.in);
		//System.out.print("추가할 메뉴번호:");
		//int MenuNo = Integer.parseInt(sc.nextLine());	

		try {
			pstmt = conn.prepareStatement(insertSQL);
			//pstmt.setInt(1, MenuNo);
			pstmt.setInt(1, menu.getCategoryno());
			pstmt.setString(2,menu.getBusinessno());
			pstmt.setString(3, menu.getMenuname());
			pstmt.setInt(4, menu.getMenuprice());			
			pstmt.setString(5, menu.getMenudetail());	
					

			int rowcnt = pstmt.executeUpdate();
			if(rowcnt == 0) {
				System.out.println("상품을 추가할 수 없습니다");
			} else {
				System.out.println(rowcnt+"건의 상품이 추가되었습니다");
			}
		} catch (SQLException e) {
			e.printStackTrace(); //오류메세지 확인하기
			throw new AddException(e.getMessage());
		} finally {
			MangoplateConnection.close(null, pstmt, conn); 
		}	
	}

	public static void delete(Menu menu) throws AddException  {
		Connection conn = null;
		try {
			conn = MangoplateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}	
		String deleteSQL =
		"DELETE FROM menu WHERE menuno = ?";

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			pstmt.setInt(1, menu.getMenuno());	

	        int rowsDeleted = pstmt.executeUpdate();
	        if (rowsDeleted > 0) {
	            System.out.println("삭제되었습니다.");
	        } else { //메뉴가 0개여서 삭제가 안되는 경우
	            System.out.println("삭제할 데이터가 없습니다.");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			MangoplateConnection.close(null, pstmt, conn); 
		}	
	}

	public static void main(String[] args) {
		MenuRepository repository = new MenuRepository(); 

	}
}



