package com.mangoplate.user;

import java.util.Scanner;

import com.mangoplate.control.MenuControl;
import com.mangoplate.dto.Menu;
import com.mangoplate.exception.AddException;

public class MenuUser {	
	private MenuControl control;
	private Scanner sc = new Scanner(System.in);

	public MenuUser() {
		control = new MenuControl() ;
	}
	public void searchMenu() {
		System.out.print("사업자등록번호:");
		String businessno = sc.nextLine();
		
		//control method 호출하기
		Menu menu = new Menu();
		menu.setBusinessno(businessno);
		
		try {
			control.search(menu);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	
	public void addMenu() {
		//키보드 음식 정보입력받기
		System.out.print("추가할 음식점 사업등록번호:");
		String businessno = sc.nextLine();	
		System.out.print("추가할 메뉴카테고리번호:");
		int categoryno = Integer.parseInt(sc.nextLine());
		System.out.print("추가할 메뉴이름:");
		String menuname= sc.nextLine();
		System.out.print("추가할 메뉴가격:");
		int menuprice= Integer.parseInt(sc.nextLine());
		System.out.print("추가할 메뉴정보:");
		String menudetail = sc.nextLine();	
		
		//control method 호출하기
		Menu menu = new Menu();
		menu.setBusinessno(businessno);
		menu.setCategoryno(categoryno);	
		menu.setMenuname(menuname);		
		menu.setMenuprice(menuprice);
		menu.setMenudetail(menudetail);
	
		try {
			control.add(menu);
		} catch (AddException e) {
			// e.printStackTrace();
			System.out.println("추가실패"+ e.getMessage());
		}
	}

	public void modifyMenu() {
		//키보드 메뉴 정보 입력받기 
		System.out.print("변경하고싶은 메뉴번호:");
		int menuno = Integer.parseInt(sc.nextLine());
		// - 메뉴정보 변경시키는 부분 -
		System.out.println("메뉴의 변경하고 싶은 항목의 새로운값을 입력해세요");
//				+ "변경할 부분이 없는 항목은 엔터키를 눌러주세요");			
		System.out.print("변경하고 싶은 카테고리번호:");
		int categoryno = Integer.parseInt(sc.nextLine());			
		System.out.print("변경하고 싶은 메뉴이름:");		
		String menuname = sc.nextLine();			
		System.out.print("변경하고 싶은 메뉴가격:");	
		int menuprice = Integer.parseInt(sc.nextLine());			
		System.out.print("변경하고 싶은 메뉴상세:");			
		String menudetail = sc.nextLine();	
		
		//control menu 호출하기
		Menu menu = new Menu();
		menu.setMenuno(menuno);		
		menu.setCategoryno(categoryno);	
		menu.setMenuname(menuname);		
		menu.setMenuprice(menuprice);
		menu.setMenudetail(menudetail);
		
		try {
			control.update(menu);
		} catch (AddException e) {
			// e.printStackTrace();
			System.out.println("수정실패" + e.getMessage());
		}	
	}
	
	public void deleteMenu() {
		//키보드 메뉴 정보 입력                   
		System.out.print("삭제할 메뉴번호:");
		int menuno = Integer.parseInt(sc.nextLine());	
		
		//control menu 호출하기
		Menu menu = new Menu();
		menu.setMenuno(menuno);	

		try {
			control.delete(menu);
		} catch (AddException e) {
			e.printStackTrace();
		}			
	}
	
	
	public void selectMenuUser() {
		String opt;
		do {
			System.out.println("메뉴기능을 이용하기 위해선 사업자번호를 입력해야합니다");			
			searchMenu();
			System.out.println("원하는 기능을 선택하세요");
			System.out.print("1.메뉴정보추가, 2.메뉴정보수정, 3.메뉴정보삭제, 9.돌아가기");
			opt= null;
			opt = sc.nextLine();//키보드로 입력받기 
			if(opt.equals("1")) {
				addMenu();
			} else if(opt.equals("2")) {
				modifyMenu();
			} else if(opt.equals("3")) {
				deleteMenu();
			} 
			else if (opt.equals("9")) {
				FoodStoreSelectMode fsm = new FoodStoreSelectMode();
				fsm.FoodSelectMode();
			//	System.out.println("메뉴 모드를 종료합니다");
			}
		} while(opt.equals("1")||opt.equals("2")||opt.equals("3")||opt.equals("9")); {
			System.out.println("번호를 잘못입력하셨습니다");
		}
	}
//	public static void main(String[] args) {
//		MenuUser user = new MenuUser();	
//		user.selectMenuUser();
//	}
}
