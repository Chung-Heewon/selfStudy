import java.util.Scanner;

public class Arr {
	public static void main(String[] args) {
	
	Scanner sc = new Scanner(System.in);	
	//배열 초기화
	//*방법1
//	String[]subject;	
//	subject =new String[3];
//	subject[0]="국어"; subject[1] ="영어"; subject[2]="수학";
	
	//*방법2
//	String[]subject = new String[3];
//	subject[0]="국어"; subject[1] ="영어"; subject[2]="수학";
	
	//subject = {"K","E","M"}; //배열재초기화 안됨

	String[]subject= {"국어","영어","수학"};
	subject = new String[] {"KOR","ENG","MATH"};
	
	//*5명에 대한 점수
	int [][]studentArr; //선언
	studentArr=new int[5][3]; //생성
	for(int studentCnt=0; studentCnt<5; studentCnt++) {
		int [] scoreArr;
		scoreArr = new int[3];
		studentArr[studentCnt]=scoreArr;
	//	scoreArr[0] = 10
	//	scoreArr[1] = 8;
	//	scoreArr[2] = 5;
		
	//	System.out.println(subject[0]+"점수 : ");
	//	scoreArr[0]=Integer.parseInt(sc.nextLine());
	//	
	//	System.out.println(subject[1]+"점수 : ");
	//	scoreArr[1]=Integer.parseInt(sc.nextLine());
	//	
	//	System.out.println(subject[2]+"점수 : ");
	//	scoreArr[2]=Integer.parseInt(sc.nextLine());
		
		//for문으로 바꾸기
		//int size = scoreArr.length; //length(배열수 확인)변수에 담아놓고, 반복문으로 활용
		int size = studentArr[studentCnt].length;
		for(int i=0;i<size; i++) {
			System.out.println(subject[i]+"점수 : ");
			//scoreArr[i]=Integer.parseInt(sc.nextLine());
			studentArr[studentCnt][i]=Integer.parseInt(sc.nextLine());
		}
		int totalScore = 0; //총점
		for(int i=0; i<size; i++) { 
			totalScore += studentArr[studentCnt][i];}//=totalScore= totalScore+scoreArr[i]
		{
			System.out.println("총점 : "+totalScore);
			{
			System.out.println("평균 : "+(float)totalScore/size); //int=정수, 정수끼리만 나눌 수 있어서 float or double로 실수타입으로 강제전환 필요
			}
		}
	}
	}
}
