import java.util.Arrays;
import java.util.Scanner;

public class Arr3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		//배열 초기화
//		String[]subject = {"국어", "영어", "수학"};
//		//subject = {"K","E","M"};//배열재초기화 안됨
//		subject = new String[]{"KOR","ENG","MATH"};
//		int subjectSize = subject.length;
//		
//		
//		int [][]studentArr; //학생수 5, 과목수 3
//		studentArr = new int[5][subjectSize];
//		int studentSize = studentArr.length; //학생수
//		
//		for(int studentCnt=0; studentCnt<studentSize; studentCnt++) {
//			int size = studentArr[studentCnt].length;
//			for(int i=0; i<size; i++) {
//				System.out.print(subject[i]+"점수:");
//				studentArr[studentCnt][i] = Integer.parseInt(sc.nextLine());
//			}
//			
//			int totalScore = 0;//총점
//			for(int i=0; i<size; i++) {
//				totalScore += studentArr[studentCnt][i];//scoreArr[i]; // totalScore = totalScore+scoreArr[i];
//			}
//			System.out.println("총점:" + totalScore);
//			System.out.println("평균:" + (float)totalScore/size);
//		}
//		
//		//과목별 평균
//		for(int i=0; i<subjectSize; i++) {
//			int totalScore = 0;
//			for(int studentCnt=0; studentCnt<studentSize; studentCnt++) {
//				totalScore += studentArr[studentCnt][i];
//			}
//			System.out.println(subject[i]+"평균:" + (float)totalScore / studentSize);
//		}	
//		
//		System.out.print("출생년도를 입력하세요:");
		int birthYear = Integer.parseInt(sc.nextLine());		
//		//년도를 12로 나눈 나머지값이 0:원숭이
//		//                    1: 닭
//		//                    2: 개 
//		//                    3: 돼지 쥐 소 호랑이 토끼 용 뱀 말 양
//		//출생년도에 해당 동물을 출력하시오
		String[] zodiac = {"원숭이","닭", "개","돼지","쥐","소","호랑이","토끼", "용", "뱀", "말", "양"};
		int index = birthYear%12;
		System.out.println(birthYear + "년도의 동물은 " +zodiac[index]);
//		
		int []numArr = {3,10, 3, 2, 1, 2, 2, 5, 6, 3, 1, 4, 4, 9,9};
		int []resultArr = new int[numArr.length]; //[0]는 1의 출현횟수저장공간, [1]는 2의 출현횟수저장공간
		/*
		 * 1의 출현횟수 : 3회
		 * 2의 출현횟수 : 3회
		 * 3의 출현횟수 : 2회
		 * 4의 출현횟수 : 2회
		 * 5의 출현횟수 : 1회
		 * 6        : 1회
		 * 7        : 0회
		 * 8        : 0회
		 * 9        : 2회
		 * 10       : 1회
		 */
		for (int i = 0; i < numArr.length; i++) {
			resultArr[numArr[i]-1]++;
		}	
		
		for (int i = 0; i < resultArr.length; i++) {
			System.out.println((i+1) + "의 출현횟수: " + resultArr[i] + "회");
		}
		
		numArr = new int[] {7, 3, 6, 10, 2, 15, 4};
		//TODO 최댓값계산하여 출력하시오
		int max = numArr[0];
		for(int i=0; i<numArr.length; i++) {
			if(numArr[i]>max) {
				max = numArr[i];
			}
		}
		System.out.println("최댓값:"+max);	
		
		int [][]numArr2; //선언
		numArr2 = new int[3][3]; //생성
		int num = 1;
		for(int row=0; row<numArr2.length; row++) {
			for(int col=0; col<numArr2[row].length; col++, num++) {
				numArr2[row][col]=num;
				//num++;
//			}
//		}
//		
//		for(int row=0; row<numArr2.length; row++) {
//			for(int col=0; col<numArr2[row].length; col++, num++) {
				System.out.print(numArr2[row][col] +"\t");
			}
			System.out.println();
		}
		
		int [][]numArr3 = new int[3][3];
		for(int i=0;i<numArr3.length;i++) {
			for(int j=0;j<numArr3[i].length;j++, num++) {
				numArr3[j][i] = numArr2[i][numArr3.length-j-1];
			}
		}
		
			
		for(int i=0;i<numArr3.length;i++) {
			for(int j=0;j<numArr3[i].length;j++, num++) {
				System.out.print(numArr3[i][j] + "\t");
			}
			System.out.println();
		}
		
		int [][]numArr4 = new int[3][];
		//numArr4[0] = new int[2];
		//numArr4[1] = new int[5];
		//numArr4[2] = new int[3];
		System.out.println("행별 열의 개수를 다르게 지정");
		num = 1;
		for(int i=0; i<numArr4.length; i++) {
			numArr4[i] = new int[i+1];//행별 열수 지정
			for(int j=0; j<numArr4[i].length; j++, num++) { //행렬에 값 대입
				numArr4[i][j] = num;
			}
		}
		for(int i=0; i<numArr4.length; i++) {
			for(int j=0; j<numArr4[i].length; j++, num++) { //행렬에 값 대입
				System.out.print(numArr4[i][j]+"\t");
			}
			System.out.println();
		}
		
		int [][]numArr5 = new int[5][];
		System.out.println("-----------------");
		for(int i=0; i<numArr5.length; i++) {
			numArr5[i] = new int[i+1];			
			for(int j=0; j<numArr5[i].length; j++) {
				if(j==0||j==numArr5[i].length-1) {
					numArr5[i][j] = 1;
				}else {
					numArr5[i][j] = numArr5[i-1][j-1] + numArr5[i-1][j]; 
				}
			}
		}
		for(int i=0; i<numArr5.length; i++) {
			for(int j=0; j<numArr5[i].length; j++, num++) { //행렬에 값 대입
				System.out.print(numArr5[i][j]+"\t");
			}
			System.out.println();
		}
		
		//로또숫자 얻기 :1~45사이의 중복되지 않는 6개 숫자
		int []lotto = new int[6];
		for(int i=0; i<lotto.length; i++) {
			lotto[i] = (int)(Math.random()*45 + 1);//1<=<46
			//중복
			for(int j=0; j<i;j++) {
				if(lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		for(int i=0; i<lotto.length; i++) {
			System.out.print(lotto[i] + "\t");
		}
		System.out.println();
		
		//---sort---
		numArr = new int[] {3, 2, 6, 5, 1, 4};
		Arrays.sort(numArr);
		for(int i=0; i<numArr.length; i++) {
			System.out.print(numArr[i]+"\t");
		}
		
		//---copy---
		int []copy = new int[numArr.length];
//		for(int i=0; i<copy.length; i++) {
//			copy[i] = numArr[i];
//		}
		int originIndex = 0;//원본위치
		int destIndex = 0; //대상본위치
		System.arraycopy(numArr, originIndex, 
				         copy, destIndex, 
				         copy.length);
		
	}
}
