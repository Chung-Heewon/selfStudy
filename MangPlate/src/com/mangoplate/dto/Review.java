package com.mangoplate.dto;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import my.com.mango.sql.MangoPlateConnection;

public class Review {
	public void doReview(String businessno, String FoodStoreName) {
		Connection conn = null;
		PreparedStatement pstmt =null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		String sql = "INSERT INTO foodstorereview (Id,FoodStoreName,rate,Review,BusinessNo)  values (?,?,?,?,?)";
		
		try {
			pstmt=conn.prepareStatement(sql);
			Scanner sc = new Scanner(System.in);
			
			pstmt.setString(1, Login.getCurrentId());
			pstmt.setString(2, FoodStoreName); // 가게이름 자동설정
			
			System.out.println("1~5사이의 점수를 입력하세요");
			int reviewpoint = Integer.parseInt(sc.nextLine());
			pstmt.setInt(3, reviewpoint);
			
			System.out.println("리뷰를 작성하세요");
			String review = sc.nextLine();
			pstmt.setString(4, review);

			pstmt.setString(5, businessno);
			
			int result = pstmt.executeUpdate();
			if(result == 1) {
				System.out.println("리뷰작성이 완료되었습니다");
			}else {
				System.out.println("리뷰작성이 실패하였습니다");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
//	}
//		public static void main(String[]args) {
//			Review r= new Review();
//			r.doReview();
		
		}
	}
