package com.mangoplate.user;
import java.util.Scanner;

import com.mangoplate.exception.AddException;

 public class FoodStoreSelectMode {
	Scanner sc = new Scanner(System.in);

	public  void FoodSelectMode(){
		System.out.println("음식점 모드 중 작업하실 번호를 입력하세요.");
		System.out.println("1.음식점, 2.메뉴, 3.음식점관련 조회 ,4.돌아가기");
		int select1 = Integer.parseInt(sc.nextLine());
		
		while(select1 !=4){
			if(select1 ==1) {
				/**
				 * 음식점 메소드 넣기
				 */
				FoodStoreUser fsu = new FoodStoreUser();
				try {
					fsu.selectFoodStore();
				} catch (AddException e) {
					e.printStackTrace();
				}
				break;
			}else if(select1 ==2) {
				/**
				 * 메뉴 메소드 넣기
				 */
				MenuUser user = new MenuUser();	
				user.selectMenuUser();
				break;
				
			}else if(select1 ==3) {
				SearchUser sc = new SearchUser();
				sc.doSearch();
//				SearchRepository sr = new SearchRepository();
//				sr.doSearch();
				break;
			}else {
				System.out.println("다시 번호를 입력하세요");
				break;
			}
		}
		
		ModeSelect ms = new ModeSelect();
		ms.selectmode();
	}
}