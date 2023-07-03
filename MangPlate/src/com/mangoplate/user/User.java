package com.mangoplate.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mangoplate.dao.LoginRepository;
import com.mangoplate.dto.Login;

import my.com.mango.sql.MangoPlateConnection;

class FirstScreenMode {
	Scanner sc = new Scanner(System.in);

	public void selectlogin() {
			String opt;
			do {
				System.out.println("안녕하세요! 작업을 선택하세요");
				System.out.print("1:로그인, 2:회원가입, 4: 종료");
				opt = sc.nextLine();
				if (opt.equals("1")) {
					try {
						showlogin();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				} else if (opt.equals("2")) {
					signup();
				} else if (opt.equals("4")) {
				} else {
					System.out.println("잘못입력하셨습니다");
				}
			} while (!opt.equals("4"));
			System.out.println("종료되었습니다");
		}

	public void showlogin() throws SQLException {

		// 키보드 음식 정보입력받기
		System.out.println(">>아이디와 비밀번호를 입력하세요<<");
		System.out.print("아이디: ");
		String id = sc.nextLine();
		System.out.print("비밀번호: ");
		String pwd = sc.nextLine();

		// control method 호출하기
		Login login = new Login();
		login.setId(id);
		login.setPwd(pwd);
		LoginRepository L = new LoginRepository();
		if(L.login(login.getId(), login.getPwd())) {

			ModeSelect ms = new ModeSelect();
			ms.selectmode();
		}
	}

	public void signup() {
		Connection conn=null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException|SQLException e) {
			e.printStackTrace();
		}
		PreparedStatement pstmt = null;


		String sql = "INSERT INTO member VALUES(?, ?)";
		try {

			pstmt = conn.prepareStatement(sql);

			Scanner sc = new Scanner(System.in);
			System.out.println("아이디를 입력하세요");
			String CreateID = sc.nextLine();
			pstmt.setString(1, CreateID);

			System.out.println("비밀번호를 입력하세요");
			String CreatePWD = sc.nextLine();
			pstmt.setString(2, CreatePWD);

			int result = pstmt.executeUpdate();
			if (result == 1)
				System.out.println("회원가입 완료");
			else
				System.out.println("오류~~~");

		} catch (SQLException e) {
			System.out.println("sql회원가입오류");
			e.printStackTrace();
		}

	}
}
class ModeSelect{
	void selectmode() {
		Scanner sc = new Scanner(System.in);

		System.out.println("아래 중 모드를 선택하세요");
		System.out.println("1: 사용자모드, 2: 음식점모드, 9.돌아가기");

		//String Select = sc.nextLine();
		int select = Integer.parseInt(sc.nextLine());
		while(select != 9) {
			if(select ==1)
			{
				UserSelectmode u = new UserSelectmode();
				u.douserSelectMode();

			}else if(select == 2) {
				/**
				 * 음식점모드 가는 메소드
				 */
				FoodStoreSelectMode fssm = new FoodStoreSelectMode();
				fssm.FoodSelectMode();

			
			}else {
				System.out.println("번호를 다시 입력해주세요.");
				break;
			}
		}
		/**
		 * 로그인 및 회원가입 화면 메소드
		 */
		FirstScreenMode fsm = new FirstScreenMode();
		fsm.selectlogin();
	}
}
public class User {
	public static void main(String[] args) {
		FirstScreenMode firstScreen = new FirstScreenMode();
		firstScreen.selectlogin();

	}
}

