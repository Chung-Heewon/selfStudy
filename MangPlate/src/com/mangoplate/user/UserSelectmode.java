package com.mangoplate.user;

import java.util.Scanner;

import com.mangoplate.dao.UserSearch;

public class UserSelectmode {
	public  void douserSelectMode(){
		Scanner sc = new Scanner(System.in);
		//		System.out.println(" 모드를 선택해주세요 ");
		//		System.out.println("1.조회, 9.돌아가기");
		System.out.println("실행하고 싶은 항목을 선택해주세요 ");
		System.out.println("1.카테고리로 음식점조회, 2.이름으로 음식조회 및 별점/리뷰작성, 3.별점(리뷰)조회, 4.내정보조회, 9.돌아가기 ");
		int opt1 = Integer.parseInt(sc.nextLine());
		while(opt1!=9) {
			if(opt1==1) {
				/**
				 * 카테고리 음식점조회
				 */
				UserSearch us =new UserSearch();
				us.searchCategory();
				
			}else if(opt1==2) {
				/**
				 * 이름으로 음식점조회
				 */
				UserSearch us =new UserSearch();
				us.searchName();
			

			}else if(opt1==3) {
				/**
				 * 리뷰조회
				 */
				UserSearch us =new UserSearch();
				us.searchReview();
			}else if(opt1==4) {
				/*
				 * 내정보조회
				 */
				UserSearch us =new UserSearch();
				us.myPage();
				break;
			}else {
				System.out.println("잘못입력하셨습니다.");
				break;
				
			}
		}
				FirstScreenMode fsm = new FirstScreenMode();
				fsm.selectlogin();
				

			
	}
}

