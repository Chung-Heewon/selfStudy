import java.util.Scanner;

public class Arr1 { //과목들의 평균

	public static void main(String[] args) {
		
	Scanner sc= new Scanner(System.in);
	
	String[]subject= {"국어","영어","수학"};
	subject = new String[] {"KOR","ENG","MATH"};
	int subjectSize = subject.length;
	
	
	int [][]studentArr; //학생수 5, 과목수 3
	studentArr = new int[5][subjectSize];//과목수 : subjectSize
	int studentSize = studentArr.length; //학생수 : studentSize
	
	//각과목별 점수입력
	for(int studentCnt=0; studentCnt<studentSize; studentCnt++) {
		int size = studentArr[studentCnt].length;
		for(int i=0; i<size; i++) {
			System.out.print(subject[i]+"점수:");
			studentArr[studentCnt][i] = Integer.parseInt(sc.nextLine());
		}
		
		int totalScore = 0;//총점
		for(int i=0; i<size; i++) {
			totalScore += studentArr[studentCnt][i];//scoreArr[i]; // totalScore = totalScore+scoreArr[i];
		}
		System.out.println("총점:" + totalScore);
		System.out.println("평균:" + (float)totalScore/size);
	}
	
	//과목별 평균
	for(int i=0; i<subjectSize; i++) {
		int totalScore = 0;
		for(int studentCnt=0; studentCnt<studentSize; studentCnt++) {
			totalScore += studentArr[studentCnt][i];
		}
		System.out.println(subject[i]+"평균:" + (float)totalScore / studentSize);
	}
}
}
