import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

import my.com.mango.sql.Search;

public class FoodStoreMode {
	
	public static void FoodStoreMode() {
		Scanner sc = new Scanner(System.in);
		System.out.println("음식점 모드 작업을 선택하세요");
		System.out.println("1: 음식점, 2: 메뉴, 3: 조회, 9: 나가기");

		int FSMM = Integer.parseInt(sc.nextLine());

		while(FSMM !=9) {
			if(FSMM==1) {
				System.out.println("실행하실 작업을 선택하세요");
				/**
				 * 음식점모드에서 음식점관련된 메소드 넣기
				 */
			}else if(FSMM==2){
				System.out.println("실행하실 작업을 선택하세요");
				/**
				 * 음식점모드에서 메뉴관련 메소드 넣기
				 */
			}else if(FSMM==3) {
				Search s = new Search();
				s.doSearch();
			}else {
				System.out.println("숫자를 잘못 입력하셨습니다.");
				System.out.println("숫자를 다시 입력하세요!");
				return ;
			}
		}
		if(FSMM==9) {
			System.out.println("프로그램이 종료되었습니다.");
		}
	}

	public static void main(String[] args) {
		FoodStoreMode FSM = new FoodStoreMode();
		FSM.FoodStoreMode();

	}

}
