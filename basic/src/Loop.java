import java.util.Scanner;

public class Loop {

	public static void main(String[] args) {
//		System.out.println("Welcome");
//		System.out.println("Welcome");
//		System.out.println("Welcome");
//		System.out.println("Welcome");
//		System.out.println("Welcome");
		
//		for(int i=0; i<5; i++) {
//			System.out.println(i+":Welcome");
//		}
		//1,2,3,4,5
//		for(int i=0; i<5; i++) {
//			System.out.println((i+1)+":Welcome");
		
		
		//11,12,13,14,15
		for(int i=11; i<16; i++) {
			System.out.println(i+":Welcome");
		}
		
		//1,11,21,31,41
//		for(int i=1; i<42; i+=10) { //최대반복될 값
//			System.out.println(i+":Welcome");
//		}
//	for(int i=1; i<42; i++) {
//		if(i%10 ==1) {
//				System.out.println(i);
//		}
//		}
//		for(int i=0; i<5; i++ ) { //횟수(5번 반복하라) = 반복문을 쓸 때는 "i(iterator)"라는 변수를 사용한다. 
//			System.out.print((i*10)+1);
//		}
//		
//		for (int i=0; i < 5; i++ ) {
//			if(i>0) {
//					System.out.print(",");
//				}
//				System.out.print((i*10)+1); //1,11,21,31,41,
//			}
//			System.out.println();	
			
		//A,B,C,D,E,F....X,Y,z
		for (char c='A'; c<='Z'; c++) {
			if(c>'A') {
				System.out.print(",");
			}	
			System.out.print(c);	
		}
		System.out.println();
		
		//피보나치 수열 : 1,1,2,3,5,8,13,21,34,55,89....
//		int bb = 1; //전전수
//		int b = 0; //전수
//		int current; //현재수
//		current = bb+b;//1
//		System.out.println(current);
//		bb = b;
//		b = current;
//		current = bb+b;//1
//		System.out.println(current);
//		bb = b;
//		b = current;
//		current = bb+b;//2
//		System.out.println(current);
//		
//		bb=b;
//		b=current;
//		current=bb+b; //3
//		System.out.println(current);

		//피보나치 수열 20개를 출력하시오:
//		int bb = 1; //전전수
//		int b = 0; //전수
//		int current; //현재수
//		for(int i=0; i<20; i++) {
//      		current = bb+b;//1
//		System.out.println((i+1)+"번째:"+current);
//	   bb = b;
//	   b = current;
	   
	   //1~100까지 출력하시오. 단, 7의 배수는 출력하지 않는다.
//	   for (int i=1; i<=100; i++) {
//		   if(i>1) {
//			   System.out.println(",");
//		   }
////		   if(i%7 !=0) {//7의 배수 : 7,14,21,28 ...
////			   System.out.print(i);
////		   }
//		   if(i%7 == 0) { //7의 배수
//			   continue; //증감치(i++)로 이동한다. 
//		   }
//		   System.out.print(i);
//	   }
//	   
		//1~100까지 출력하시오. 단, 짝수들은 출력하지 않는다.
//	   for (int i=1; i<=100; i++) {
//		   if(i>1) {
//		   System.out.println(',');
//	   }
//	   if(i%2 == 0) {
//		   continue;
//	   }
//		   System.out.print(i);
//	   }
//	   System.out.println();
//	}
//		for (int i=1; i<=100; i+=2) { //반복횟수가 줄어듦
//			   if(i>1) {
//			   System.out.print(',');
//			   }
//		   System.out.print(i);
//	   }
		//1~100까지의 합을 출력하시오.
		int sum=0;
	for (int i=1; i<=5; i++) {
		sum = sum+i; //sum+=i
	}
	System.out.println("1~100합 : "+sum);
		
////	for (int i=1; sum=0; i<=100; i++) {
////}
//		// 1~100까지의 숫자들의 홀수합, 짝수합을 출력하시오.
//		int sum=0;
//		int sum2=0;
//		for(int i=1; i<=100; i++) {
//			if(i%2 !=0) {
	
//				sum=sum+i;
//			}else if(i%2==0){
//				sum2=sum2+i;
//		}
//		}
//		System.out.println("홀수합:"+sum);
//		System.out.println("짝수합:"+sum2);
//		
//}
	//방법2
	int sumOdd = 0; //홀수합
	int sumEven = 0; //짝수합
	for(int i=1; i<=100; i++) {
			if(i%2==1) { //홀
				sumOdd+=1; //sumOdd = sumOdd+i
			}else { //짝
				sumEven +=1;
			}
	}
	System.out.println("홀수합:"+sumOdd);
	System.out.println("짝수합:"+sumEven);

	
	//구구단 : 2단~5단까지 *1~*9까지 출력하시오

	/*System.out.println(dan*1);
	System.out.println(dan*2);
	System.out.println(dan*3);
	System.out.println(dan*4);
	*/
	//:
	//int dan = 2;
	////구구단 : 2단~5단까지 *1~*9까지 출력하시오
	//8의 배수는 출력하지 않는다.
	for(int dan=2; dan<=5; dan++){
		for(int i=1; i<=9; i++) {
			if(dan*i%8==0) {
				continue;
			}
			if(i>1){
				System.out.print(",");
			}
			System.out.print(dan*i);
		}
		System.out.println();
		
	//구구단 : 2단~5단까지 *1~*9까지 출력하시오
		//25이상인 경우 더 이상 출력하지 않는다.
	//방법1 (for구문 labeling)
//		out: for(int dan=2; dan<=5; dan++){
//			in:for(int i=1; i<=9; i++) {
//				if(dan*i>= 25) {
//					break out; //(바깥쪽(out)으로 지정하여 해당 반복문을 빠져나가게 하는 것)
//				}
//				if (dan*1%8==0) {
//					continue;
//					}
//				if(i>1){
//					System.out.print(",");
//				}
//				System.out.print(dan*i);
//			}
//			System.out.println();
			
	//방법2
//			out: for(int dan=2; dan<=5; dan++){
//				in: for(int i=1; i<=9; i++) {
//					if(dan*i>= 25) {
//						dan = 100;
//						break;
//						//break out; //(바깥쪽(out)으로 지정하여 해당 반복문을 빠져나가게 하는 것)
//					}
//					if (dan*1%8==0) {
//						continue;
//						}
//					if(i>1){
//						System.out.print(",");
//					}
//					System.out.print(dan*i);
//				}
//				System.out.println();
				
				
				//While 반복문
	
//				for(int i=0; i<5; i++) {
//					System.out.println(i+" :Welcome");
//				}
//				System.out.println("----------");
//				int iw=0;
//				while(iw<5) {
//					System.out.println("welcome");
//					iw++;
//					
				//1,11,21,31,41
				//*for
//				for (int i=0; i < 5; i++ ) {
//					if(i>0) {
//							System.out.print(",");
//						}
//					System.out.print((i*10)+1); //1,11,21,31,41,
//					}
//				System.out.println();
//				
//				
//				//*while
//				System.out.println("----------------");
//				int iw=0;
//				while(iw<5) {
//					if(iw>0) {
//						System.out.print(",");
//					}
//					System.out.print((iw*10)+1);
//					iw++;
//				
//				
				//A,B,C,D,E,F....X,Y,z
				//*for
				for (char c='A'; c<='Z'; c++) {
					if(c>'A') {
						System.out.print(",");
					}	
					System.out.print(c);	
				}
				System.out.println();
				
				//*while
				System.out.println("--------------");
				char cw='A';
				while(cw<='Z') {
					if(cw>'A') {
						System.out.print(",");
					}	
					System.out.print(cw);	
					cw++;
					
				//피보나치 수열 20개를 출력하시오:
				//*for
				int bb = 1; //전전수
				int b = 0; //전수
				int current; //현재수
				for(int i=0; i<20; i++) {
			      	current = bb+b;//1
			      	System.out.println((i+1)+"번째:"+current);
			      	bb = b;
			      	b = current;
				}
				System.out.println("--------------------");
				//*while
				int iw;
				bb = 1; //전전수
				b = 0; //전수
				iw =0;
				while(iw<20) {
					current=bb+b;
					System.out.println((iw+1)+"번째:"+current);
					bb=b;
					b=current;
					iw++;
				}
				
		//1~10까지 출력하라
			//*for
//			for (int i=1; i<=10; i++) {
//				System.out.println(i);
//			}
//			System.out.println("----------");
//			
//			//*while
//			//내가한 방법
//			iw=0;
//			while(iw<10) {
//				System.out.println((iw+1));
//				iw++;
//				
//			//베스트코드
//			iw=0;
//			while (iw<10 ) {
//				iw++;
//				System.out.println(iw);
//				
//			//베스트코드를 for문으로 만들었을경우
//			for (int i=0; i<10;) {
//				i++;
//				System.out.println(i);
			}
			//키보드 자원과 연결
			Scanner sc = new Scanner(System.in);
//			
//			while(true) { //조건식에서 "무조건"이라는 반복식을 이용하려면 while(true)사용
//				System.out.print("값을 입력하세요. 종료하려면 q를 입력하세요");
//				//키보드로부터 입력
//				String line=sc.nextLine();
//				System.out.println("입력한 값은 " + line + "입니다");
//				if("q".equals(line)) { //문자열은 .equals를 이용하여 비교
//					break;
//				}
//			}
			
		//do while //do, while(); 세미콜론 무조건 - do블럭이 일단은 수행을 진행 후 while 조건 비교
			//while은 조건비교부터 먼저 진행
			String line; //변수선언시에는 해당블록에서만 사용가능하다(블록 이후에 변수선언먼저)
			do { 
				System.out.print("값을 입력하세요. 종료하려면 q를 입력하세요");
				//키보드로부터 입력
				line=sc.nextLine();
				System.out.println("입력한 값은 " + line + "입니다");
			}while(!"q".equals(line)); //라인변수의 값이 "q"가 아니면 반복수행하라
			
			int num;
			for(num=10; num<10; num++) {
				System.out.println(num);
			}
			num=10;
			while(num<10) {
				System.out.println(num);
				num++;
			}
			do {
				System.out.println(num);//10
				num++;
			}while(num<10);
			
			}
	}
}
			

	


			
	

