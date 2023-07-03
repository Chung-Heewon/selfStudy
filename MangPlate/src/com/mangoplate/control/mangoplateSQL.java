package com.mangoplate.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mangoplate.sql.MangoplateConnection;

public class mangoplateSQL {
	public void addfoodstore() {
		Scanner sc = new Scanner(System.in);
		Connection conn = null;
		try {
			conn = MangoplateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}
		System.out.println(">>음식점 정보를 추가하세요<<");
		System.out.println("사업자번호:");
		int Businessno = Integer.parseInt(sc.nextLine());
		System.out.println("음식점이름:");
		String StoreName = sc.nextLine(); // 음식점 이름
		System.out.println("음식점 주소 :");
		String Addresses = sc.nextLine();
		System.out.println("음식점 종류 번호 : ");
		int Categoryno = Integer.parseInt(sc.nextLine());
		System.out.println("상세 정보(전화번호, 주차여부, 운영시간 등) : ");
		String Details = sc.nextLine();
		// String updateSQL = "UPDATE product SET prod_price=" + prodPrice + " WHERE
		// prod_no ='" + prodNo + "'";
		// Statement stmt = null;

		String insertSQL = "INSERT INTO foodstore(businessno,StoreName,Addresses,Categoryno,Detail)"
				+ " VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {
			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setInt(1, Businessno);
			pstmt.setString(2, StoreName);
			pstmt.setString(3, Addresses);
			pstmt.setInt(4, Categoryno);
			pstmt.setString(5, Details);

			int rowcnt = pstmt.executeUpdate();
			if (rowcnt == 0) {
				System.out.println("추가할 상품이 없습니다");
			} else {
				System.out.println(rowcnt + "건의 상품이 추가되었습니다. ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MangoplateConnection.close(null, pstmt, conn);
		}
	}
}
