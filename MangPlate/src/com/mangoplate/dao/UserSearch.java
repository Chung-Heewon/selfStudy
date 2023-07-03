package com.mangoplate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mangoplate.dto.Login;
import com.mangoplate.dto.Review;
import com.mangoplate.user.UserSelectmode;

import my.com.mango.sql.MangoPlateConnection;


public class UserSearch {

	public void searchCategory() {
		System.out.println("음식종류의 번호를 선택해주세요");
		System.out.println("ex)1.한식 2.중식 3.양식 4.일식 5.분식 6.카페");
		String sql = "SELECT FoodStoreName,Addresses,detail FROM foodstore WHERE CATEGORYNO=?";
		/**
		 * 1. 1번이 선택되었을때 db와 연결한다
		 * 2. 스캐너로 1~5번 항목까지선택해 입력받을수 있게한다
		 * 3. 각 항목별 경우로 sql문을 전송해 결과를 반환한다
		 * 4. 반환된 결과를 출력한다.
		 * 
		 */
		Connection conn=null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs=null;

		try {
			pstmt= conn.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			int category = Integer.parseInt(sc.nextLine());

			pstmt.setInt(1, category);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println(">>>>>>>>조회하신 카테고리에 따른 음식점 정보입니다<<<<<<<<<");
			System.out.println("음식점이름   주소                음식점상세");
			System.out.println("------------------------------------");
			while(rs.next()==true) {
				System.out.println(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3));
//				System.out.println("");
			}

		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			MangoPlateConnection.close(rs, pstmt, conn);
		}
		UserSelectmode us = new UserSelectmode();
		us.douserSelectMode();
	}

	public void searchName() {
		Connection conn=null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql = "SELECT FoodStoreName,Addresses,detail, BusinessNo FROM FOODSTORE WHERE FOODSTORENAME = ?";
		String sql1= "SELECT MenuName, MenuPrice, MenuDetail FROM MENU Where BUSINESSNO=? ";

		String businessno=null;
		String FoodStoreName=null;
		Scanner sc = new Scanner(System.in);
		int select=0;
		try {
			pstmt= conn.prepareStatement(sql);

			System.out.println("가게이름을 입력해주세요");
			String name = sc.nextLine();

			pstmt.setString(1, name);

			rs = pstmt.executeQuery();
			rs.next();
			businessno = rs.getString(4);
			FoodStoreName=rs.getString(1);

			System.out.println("-------------조회하신 음식점 정보입니다.--------------");
			System.out.println("음식점이름    주소                 기타");
			System.out.println("------------------------------------");
			System.out.println(rs.getString(1)+"    "+rs.getString(2)+"      "+rs.getString(3));
			pstmt.close();
			rs.close();

			pstmt=conn.prepareStatement(sql1);
			pstmt.setString(1, businessno);
			rs=pstmt.executeQuery();
			rs.next();
			System.out.println("-----------조회하신 음식점의 메뉴 정보입니다.------------");
			System.out.println("메뉴이름    메뉴가격                메뉴상세");
			System.out.println("------------------------------------");
			System.out.println(rs.getString(1)+"    "+rs.getString(2)+"      "+rs.getString(3));

		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			MangoPlateConnection.close(rs, pstmt, conn);
		}
		while(select != 9) {
			System.out.println("1.리뷰작성, 9.돌아가기");
			select =Integer.parseInt(sc.nextLine());
			if(select==1) {
				Review r = new Review();
				r.doReview(businessno, FoodStoreName);
			}else if(select == 9) {
				UserSelectmode us = new UserSelectmode();
				us.douserSelectMode();
			}else {
				System.out.println("숫자를 잘못입력하셨습니다.");
			}

		}

	}
	public void searchReview() {

		Connection conn=null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException |SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql = "SELECT FoodStoreName,id,rate,Review  FROM FoodStoreReview WHERE FoodStoreName=?";

		try {
			pstmt= conn.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);

			System.out.println("가게이름을 입력해주세요");
			String name = sc.nextLine();

			pstmt.setString(1, name);


			rs = pstmt.executeQuery();
			rs.next();

			System.out.println(">>>>>>>>>>>>>>>>>>>조회하신 음식점 리뷰입니다<<<<<<<<<<<<<<<<<");
			System.out.println("음식점이름  사용자아이디   평점      리뷰 ");			
			System.out.println("--------------------------------------------------------");

			while(rs.next()) {
				System.out.println(rs.getString(1)+"    "+rs.getString(2)+"          "+rs.getInt(3)+"    "+rs.getString(4));
			}
			System.out.println("--------------------------------------------------------");

		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			MangoPlateConnection.close(rs, pstmt, conn);
		}
		UserSelectmode us = new UserSelectmode();
		us.douserSelectMode();

	}

	public void myPage() {

		Connection conn=null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql = "SELECT * FROM Member where Id =?" ;

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, Login.getCurrentId());
			Scanner sc = new Scanner(System.in);
			rs = pstmt.executeQuery();
			rs.next();
			System.out.println("아이디 :"+rs.getString("Id") +"\t"+ "비밀번호 : "+rs.getString("Pwd"));

		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			MangoPlateConnection.close(rs, pstmt, conn);
		}
	}
}
