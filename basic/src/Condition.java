import java.util.Calendar;

public class Condition {
	public static void main(String[] args) {
		java.util.Scanner sc;
		sc = new java.util.Scanner(System.in);

		//if
		if(true) {}
		System.out.print("년도를 입력하세요:");
		int year = Integer.parseInt(sc.nextLine()); //2023; 
		//String->int로 변환메소드 : int value= Interger.parseInt(String);
		if(year%2==0) {
			System.out.println("짝수해입니다.");
		}
		
		System.out.println("시간을 입력하세요:");
		int hour = Integer.parseInt(sc.nextLine()); //15;
		//if else
		if(hour<12) {
			System.out.println("오전");
		}else{
			System.out.println("오후");
		}
		
		//if else if
		System.out.println("월을 입력하세요:");
		int month = Integer.parseInt(sc.nextLine()); //5;
		//1분기 : 1-3
		//2분기 : 4-6
		//3분기 : 7-9
		//4분기 : 10-12월
		if(month >=1 && month<= 3) { //if else에 간다는 것은 4이상이다
			System.out.println("1분기");
		}else if(month <= 6) {
			System.out.println("2분기");
		}else if(month <=9) {
			System.out.println("3분기");
		}else if(month <=12) {
			System.out.println("4분기");
		}else {
			System.out.println("월이 잘못되었습니다.");			
		}
		System.out.print("점수를 입력하세요:");
		int score = Integer.parseInt(sc.nextLine());
		if (score == 100 || score >=90){
			System.out.println("A");
		}else if(score >=80){
			System.out.println("B");
		}else if(score >=70) {
			System.out.println("C");
		}else if(score >=60) {
			System.out.println("D");
		}else if(score >=50) {
			System.out.println("F");
		}else {
			System.out.println("점수가 잘못되었습니다.");
		}
		//100~90점인 경우 A
		//89~80점인 경우 B
		//79~70점인 경우 C
		//69~60점인 경우 D
		//59~60점인 경우 F
		
		
		
		//임의의 수(난수) //0.0이상 1.0미만
		
//		  for (int i=0; i<10; i++) { 
//			  int r= (int)(Math.random()*3)+1; //1<= r <4
//		  System.out.println(r); 
//		  }

		 System.out.println("가위바위보");
		 System.out.println("가위-1, 바위-2, 보-3을 입력하세요");
		 int u = Integer.parseInt(sc.nextLine());       //ex)1 가위
		 int r= (int)(Math.random()*3)+1; //1<= r <4    //ex)2 바위
		 System.out.println("사용자:"+u+",컴퓨터:"+r);
		
		 if(u==r) {
			 System.out.println("비겼습니다.");
		 }else if(u<1 || u>3) {
				 System.out.println("잘못 입력하셨습니다.");
		 }else if(u - r%3 ==1) {
			 System.out.println("이겼습니다.");
		 }else {
			 System.out.println("졌습니다.");
		 }
		 /*
		 if(u==r) {
			 System.out.println("비겼습니다.");
		 }else if(u<1 || u>3) {
			 System.out.println("잘못 입력하셨습니다.");
		 }else if((u==1 && r==3)|| (u==2&&r==1) || (u==3&&r==2)) {
			 System.out.println("이겼습니다.");
		 }else {
			 System.out.println("졌습니다.");
			 
		 }
		 if(u == r) {
			System.out.println("비겼습니다");
		}else if(u<1 || u>3) {
			System.out.println("잘못입력하셨습니다");
		}else if(u == 1) {
			if(r == 3) {
				System.out.println("이겼습니다");
			}else {
				System.out.println("졌습니다");
			}
		}else if(u == 2) {
			if(r == 1) {
				System.out.println("이겼습니다");
			}else {
				System.out.println("졌습니다");
			}
		}else if(u == 3) {
			if(r == 2) {
				System.out.println("이겼습니다");
			}else {
				System.out.println("졌습니다");
			}
		}
		 */
		 score = (int)(Math.random()*20)+81; //81<= <101
		System.out.println("점수 : "+score);
		
		String grade;
		if(score>=90) {
			grade="A";
			if(score>=95) {
				grade+="++";
			}
		}else {
			grade= "B";
			if(score>=85) {
				grade+="++";
			}
		}
		System.out.println("등급:"+grade);
		
		Calendar cal;
		cal = Calendar.getInstance();
		month=cal.get(Calendar.MONTH); //1월인 경우 0, 2월인 경우 1
		System.out.println("현재" +(month + 1) +"월입니다");
		if(month<6) {
			System.out.println("상반기");
		}else {
			System.out.println("하반기");
		}
		if(month+1==1) {
			System.out.println("1월");
		}else if(month+1==2) {
			System.out.println("2월");
		}else if(month+1==3) {
			System.out.println("3월");
		}else if(month+1==4) {
			System.out.println("4월");
		}else if(month+1==5) {
			System.out.println("5월");
		}else {
			System.out.println("그외의 달");
		}
		//switch (byte, short, char, int, String)
		switch(month) {
		case 0:
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			System.out.println("상반기");
			break;
		default : 
			System.out.println("하반기");
			break;
			
		}
		//--------------------------------------------------
		switch(month+1) {
		case 1:
			System.out.println("1월");
			break;
		case 2: 
			System.out.println("2월");
			break;
		default:
			System.out.println("그외의 달");
		}
		System.out.print("출생년도를 입력하세요 : ");
		int birthYear = Integer.parseInt(sc.nextLine());
		//년도를 12로 나눈 나머지값이 0: 원숭이
//		                       1: 닭 
//		                       2: 개
//		                       3: 돼지
//		                       쥐 소 호랑이 토끼 용 뱀 말 양
		// 출생년도에 해당 동물을 출력하시오
		
		switch(birthYear%12) {
		case 0:
			System.out.println("원숭이");
			break;
		case 1:
			System.out.println("닭");
			break;
		case 2:
			System.out.println("개");
			break;
		case 3:
			System.out.println("돼지");
			break;
		case 4:
			System.out.println("쥐");
			break;
		case 5:
			System.out.println("소");
			break;
		case 6:
			System.out.println("호랑이");
			break;
		case 7:
			System.out.println("토끼");
			break;
		case 8:
			System.out.println("용");
			break;
		case 9:
			System.out.println("뱀");
			break;
		case 10:
			System.out.println("말");
			break;
		case 11:
			System.out.println("양");
			break; //default는 생략가능하다. 
		
	
		
		
		
	}
}
}
