package com.mangoplate.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mangoplate.dao.SearchRepository;

import my.com.mango.sql.MangoPlateConnection;

public class SearchUser {
	Scanner sc = new Scanner(System.in);
	Connection conn = null;
	Statement stmt=null;
	PreparedStatement pstmt = null;
	ResultSet rs = null; 
	//조회 메소드
	public void doSearch() {
		System.out.println("음식점 모드 중 조회할 항목을 선택하시오");
		System.out.println("1: 음식점정보, 2: 메뉴정보, 3: 돌아가기, 9: 종료");
		int s = Integer.parseInt(sc.nextLine());
		try {
			conn = MangoPlateConnection.getConnection();
			
			while(s!=9) {
				if(s==1) {

				SearchRepository sr = new SearchRepository();
				sr.doMyFoodStoreSearch();
				break;

				}else if(s==2) {
					SearchRepository sr = new SearchRepository();
					sr.doMyMenuSearch();
					break;
				
				}else if(s==3) {
					FoodStoreSelectMode fsm = new FoodStoreSelectMode();
					fsm.FoodSelectMode();
				}else if(s==9) {
					System.out.println("종료합니다");
					System.exit(0);					
				}
				else {
					System.out.println("숫자를 잘못 입력하셨습니다");
				}
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			MangoPlateConnection.close(rs, stmt, conn);
		}
	}
	//		public static void main(String[] args) {
	//			Search s = new Search();
	//			s.doSearch();
	//		}
}