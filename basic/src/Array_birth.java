import java.util.Arrays;
import java.util.Scanner;

public class Array_birth {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		/*
//		System.out.println("출생년도를 입력하세요");
//		int birthYear = Integer.parseInt(sc.nextLine());
//		
//		String[] str= {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
//		System.out.println("당신은 "+str[birthYear%12]+" 띠 입니다.");
//		
////선생님과 풀어보기
//		String[] zodiac= {"원숭이","닭","개","돼지","쥐","소","호랑이","토끼","용","뱀","말","양"};
//		int index = birthYear%12;
//		System.out.println(birthYear +"년도의 동물은 "+zodiac[index]);

//배열안에 각 숫자의 출현 횟수를 찾아보기
		// 1의 출현횟수 : 3회
		// 2의 출현횟수 : X회
		int []numArr= {1,10,3,2,1,2,5,6,5,4,8,6,5,6,5,2};
		int []resultArr = new int[10]; //[0]는 1의 출현횟수저장공간, [1]는 2의 출현횟수저장공간

//		//내가 한것
//		for(int i=0; i<resultArr.length;i++) {
//			resultArr[numArr[i]-1]++;
//		}
//		
//		for(int i=0; i<resultArr.length;i++) {
//			System.out.println((i+1)+"의 갯수 : "+resultArr[i]);

//		//베스트 답변
//		for (int i = 0; i < numArr.length; i++) {
//			resultArr[numArr[i]-1]++;
//		}
//		for (int i = 0; i < resultArr.length; i++) {
//			System.out.println((i+1) + "의 출현횟수: " + resultArr[i] + "회");
//		
//		}

		//최대값을 구해라 (최소값, 중앙값, 정렬도 할 수 있어야한다)
		//첫번째 수를 인덱스에 만들고, 숫자를 비교하여 최대값을 구해라 
		numArr = new int[] {7,3,6,10,2,15,4};		
		int max = numArr[0];
		for(int i=0; i<numArr.length; i++) {
			if(numArr[i]>max) 
				max = numArr[i];
		}
		System.out.println("최댓값 : "+max);	
	//숫자값들이 저장될 2차항 배열
		int [][]numArr2; //선언
		numArr2 = new int[3][3]; //생성
		int num = 1;
		for (int row=0; row<numArr2.length; row++) {
			for(int col=0; col<numArr2[row].length; col++, num++) {
				numArr2[row][col]=num;
				//num++;
			}
		}
		for(int row=0; row<numArr2.length; row++) {
			for(int col=0; col<numArr2[row].length; col++, num++) {
				System.out.print(numArr2[row][col]+"\t");
			}
			System.out.println(); {
			}	
		}System.out.println("-------------------------------");
		 */
		// 숫자값들이 저장될 2차항 배열을 반시계반향으로 돌리기
		int [][]numArr3 ;

		//		int[][]numArr4=new int[3][]; //행만 미리 지정하고 열을 각자 다르게 지정하기 위해 선언
		////		numArr4[0]=new int[2];
		////		numArr4[1]=new int[5];
		////		numArr4[2]=new int[3];
		//		for(int i=0; i<numArr4.length; i++) {
		//			numArr4[i]= new int[i+1];

		//  숫자배열규칙대로 만들기
		//		int num=0;
		//		int [][]numArr5 = new int[5][];
		//		System.out.println("--------------");
		//		for(int i=0; i<numArr5.length; i++) {
		//			numArr5[i] = new int[i+1];
		//			for (int j=0; j<numArr5[i].length; j++) {
		//				if(j==0||j==numArr5[i].length-1) {
		//					numArr5[i][j]=1;
		//				}else {
		//					numArr5[i][j]=numArr5[i-1][j-1]+numArr5[i-1][j];
		//				}
		//			}
		//		}
		//		for(int i=0; i<numArr5.length; i++) {
		//			for(int j=0; j<numArr5[i].length; j++, num++) {
		//				System.out.print(numArr5[i][j]+"\t");
		//			}
		//			System.out.println(); {
		//			}	
		//로또숫자얻기 : 1~45 사이의 중복되지 않는 6개의 숫자 
		int[]lotto=new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45+1); //더블타입의 값을 반환을 한다. 1<= <46
			//중복 비교
			for(int j=0; j<i; j++) {
				if(lotto[i]==lotto[j]) {
					//continue : 근접한 반복문으로 간다. 
					//break : 근접한 반복문을 빠져나온다.
					i--;
					break;
				}
			}
		}

		for (int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i]+"\t");
		}
		//-----------sort--------
		int []numArr;
		numArr = new int[] {3,2,6,5,1,4};
		Arrays.sort(numArr);//오름차순 정렬;
		for(int i=0; i<numArr.length; i++) {
			System.out.println(numArr[i]+"\t");
		}

		//----copy---
		int []copy = new int[numArr.length];
		//	for(int i=0; i<copy.length; i++) {
		//		copy[i]=numArr[i];
		//	}
		//	System.arraycopy(numArr,0, copy,0 , copy.length);
		int orginIndex=0;//원본위치
		int destIndex=0;
		System.arraycopy(numArr, orginIndex, copy, destIndex, copy.length);

	}
}


