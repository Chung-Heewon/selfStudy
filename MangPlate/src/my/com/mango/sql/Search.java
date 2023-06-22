package my.com.mango.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Search {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	Statement stmt=null;
	ResultSet rs = null;
	//조회 메소드
	public void doSearch() {
		try {
			conn = MangoPlateConnection.getConnection();
			System.out.println("조회할 항목을 선택하시오");
			System.out.println("1: 내정보조회, 2: 음식점정보, 3: 메뉴조회, 4: 평점(리뷰)조회, 5: 돌아가기");
			int s = Integer.parseInt(sc.nextLine());
			while(s!=5) {
				if(s==1) {
					/**
					 * 내정보넣기
					 */
					System.out.println("사업자번호를 입력하세요 : ");
					int businessno = Integer.parseInt(sc.nextLine());

					stmt = conn.createStatement();
					String selectSQL = "SELECT * FROM foodstore";
					rs=stmt.executeQuery(selectSQL);
					while(rs.next()) {
						String bno = rs.getString("BusinessNo");
						String storename = rs.getString("StoreName");
						String address = rs.getString("Addresses");
						int category = rs.getInt("CategoryNo");
						System.out.println(bno+"-"+storename+"-"+address+"-"+category+"-");
						return;
					}
				}else if(s==2) {
					/**
					 * 음식점 정보
					 */
				}else if(s==3) {
					/**
					 * 메뉴조회
					 */
				}else if(s==4) {
					/**
					 * 평점(리뷰) 조회

					 */
				}else if(s==5) {
					System.out.println("프로그램을 종료하였습니다.");
					break;
				}else {
					System.out.println();
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MangoPlateConnection.close(rs, stmt, conn);
		}
	}
}