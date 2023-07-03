package com.mangoplate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

import com.mangoplate.dto.Login;

import my.com.mango.sql.MangoPlateConnection;

public class SearchRepository {
	Scanner sc = new Scanner(System.in);

	public void doMyFoodStoreSearch() {
		Connection conn=null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		String sql = "SELECT * FROM Foodstore where Id =?" ;

		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, Login.getCurrentId());
			Scanner sc = new Scanner(System.in);
			rs = pstmt.executeQuery();

			rs.next();
			//		String bno = ;
			//		String storename = ;
			//		String address = );
			//		String detail = ;		
			//		int category = ;
			System.out.println(">>>>>>내 음식점 정보입니다<<<<<<<<");
			System.out.println("사업자번호 : "+rs.getString("BusinessNo"));
			System.out.println("음식점이름 : "+rs.getString("FoodStoreName"));
			System.out.println("음식점주소 : "+rs.getString("Addresses"));
			System.out.println("음식점상세 : "+rs.getString("detail"));
			System.out.println("음식점카테고리 : "+rs.getInt("CategoryNo"));
		} catch (SQLException e) {
			e.printStackTrace();	
		} finally {
			MangoPlateConnection.close(rs, pstmt, conn);
		}
		System.out.println("---------------------------------------------");
	}
		public void doMyMenuSearch() {
			Connection conn=null;
			try {
				conn = MangoPlateConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			ResultSet rs=null;

			String sql1 = "SELECT menuname, menuprice, menudetail \r\n"
					+ "FROM menu\r\n"
					+ "JOIN foodstore ON(menu.businessno=foodstore.businessno)\r\n"
					+ "WHERE id = ?" ;
			try {
				pstmt= conn.prepareStatement(sql1);
				pstmt.setString(1, Login.getCurrentId());
				Scanner sc = new Scanner(System.in);
				rs = pstmt.executeQuery();

				rs.next();
				System.out.println(">>>>>>>>내 음식점 메뉴 정보입니다<<<<<<<<<");
				System.out.println("메뉴이름    가격    음식상세");
				System.out.println("------------------------------------");
				while(rs.next()) {
				System.out.println(rs.getString("menuname") +"\t"+rs.getInt("menuprice")+"\t"+rs.getString("menudetail"));
				}
			} catch (SQLException e) {
				e.printStackTrace();	
			} finally {
				MangoPlateConnection.close(rs, pstmt, conn);
			}
			System.out.println("---------------------------------------------");
		}
		public void doReviewSearch() {
			Connection conn=null;
			try {
				conn = MangoPlateConnection.getConnection();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			PreparedStatement pstmt = null;
			ResultSet rs=null;

			String sql1 = "SELECT menuname, menuprice, menudetail \r\n"
					+ "FROM menu\r\n"
					+ "JOIN foodstore ON(menu.businessno=foodstore.businessno)\r\n"
					+ "WHERE id = ?" ;
			try {
				pstmt= conn.prepareStatement(sql1);
				pstmt.setString(1, Login.getCurrentId());
				Scanner sc = new Scanner(System.in);
				rs = pstmt.executeQuery();

				rs.next();
				System.out.println(">>>>>>>>내 음식점 메뉴 정보입니다<<<<<<<<<");
				System.out.println("메뉴이름    가격    음식상세");
				System.out.println("------------------------------------");
				while(rs.next()) {
				System.out.println(rs.getString("menuname") +"\t"+rs.getInt("menuprice")+"\t"+rs.getString("menudetail"));
				}
			} catch (SQLException e) {
				e.printStackTrace();	
			} finally {
				MangoPlateConnection.close(rs, pstmt, conn);
			}
			System.out.println("---------------------------------------------");
		}
	}
