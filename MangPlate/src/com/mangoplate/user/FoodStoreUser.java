package com.mangoplate.user;

import java.util.Scanner;

import com.mangoplate.control.FoodStoreControl;
import com.mangoplate.dto.FoodStore;
import com.mangoplate.exception.AddException;

public class FoodStoreUser {
	FoodStore foodstore = new FoodStore();
	private FoodStoreControl control;
	private Scanner sc = new Scanner(System.in);

	public FoodStoreUser() {
		control = new FoodStoreControl();
	}

	public void addFoodStore() {
		// 키보드 음식 정보입력받기
		System.out.println(">>음식점 정보를 추가하세요<<");
		System.out.println("사업자번호:");
		String businessno = sc.nextLine();
		System.out.println("음식점이름:");
		String foodstoreName = sc.nextLine(); // 음식점 이름
		System.out.println("음식점 주소 :");
		String addresses = sc.nextLine();
		System.out.println("상세 정보(전화번호, 주차여부, 운영시간 등) : ");
		String details = sc.nextLine();
		System.out.println("음식점 종류 번호 : ");
		int categoryno = Integer.parseInt(sc.nextLine());
		System.out.println("음식점 정보가 성공적으로 수정되었습니다.");

		// control method 호출하기
		FoodStore foodstore = new FoodStore();
		foodstore.setBusinessno(businessno);
		foodstore.setfoodStoreName(foodstoreName);
		foodstore.setAddresses(addresses);
		foodstore.setCategoryno(categoryno);
		foodstore.setDetail(details);

		try {
			control.add(foodstore);
		} catch (AddException e) {
			// e.printStackTrace();
			System.out.println("추가 실패" + e.getMessage());
		}

	}

	public void modifyFoodStore() {

		// 키보드 음식 정보수정하기
		System.out.println(">>음식점 수정\n 사업자 번호를 입력해주세요.<<");
		String bNum = sc.nextLine();

		System.out.println(">>수정할 내용을 입력하세요.<<");

		FoodStore foodstore = new FoodStore();

		System.out.println("음식점이름:");
		String str = sc.nextLine();
		foodstore.setfoodStoreName(str);

		System.out.println("음식점 주소 :");
		String addresses = sc.nextLine();
		foodstore.setAddresses(addresses);

		System.out.println("상세 정보(전화번호, 주차여부, 운영시간 등) : ");
		String details = sc.nextLine();
		foodstore.setDetail(details);

		System.out.println("음식점 종류 번호 : ");
		int categoryno = Integer.parseInt(sc.nextLine());
		foodstore.setCategoryno(categoryno);

		try {
			control.modify(foodstore, bNum);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}

	public void deleteFoodStore() {
		System.out.println(">>음식점 정보를 삭제할 사업자번호를 입력하세요.<<");
		System.out.print("사업자번호: ");
		String businessno = sc.nextLine();

		try {
			control.delete(businessno);
			System.out.println("음식점 정보가 성공적으로 삭제되었습니다.");
		} catch (AddException e) {
			System.out.println("삭제 실패: " + e.getMessage());
		}
	}

	public void selectFoodStore() throws AddException {

		String opt;
		do {
			System.out.println("작업을 선택하세요");
			System.out.print("1:음식점정보추가,  2:음식점정보수정, 3:음식점정보삭제, 4: 돌아가기");
			opt = sc.nextLine();// 키보드로 입력받기
			if (opt.equals("1")) { // ==비교연산자사용안함
				addFoodStore();
			} else if (opt.equals("2")) {
				modifyFoodStore();
			} else if (opt.equals("3")) {
				deleteFoodStore();
			} else if (opt.equals("4")) {
			} else {
				System.out.println("잘못입력하셨습니다");
			}

		} while (!opt.equals("4"));
		System.out.println("");

	}

	public static void main(String[] args) throws AddException {
		FoodStoreUser user = new FoodStoreUser();
		user.selectFoodStore();

	}

}
