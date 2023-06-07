import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ExceptionTest {
	public static boolean m(int i) {
		try {
			System.out.println("99를"+i+"로 나눈 나머지값 : "+ 99%i); //ArithmeticException 발생가능
			//			System.out.println("m()끝");
			return true;
		}catch(ArithmeticException e){
			System.out.println("분모는 0이 될 수 없습니다.");
			//			System.out.println("m()끝");
			return false;
		}finally { //예외 발생여부와 관계없이 처리되어야할 구분이 있다면 finally 로 사용하여 주기 (주로 외부 자원과 연결을 끊을때 많이 사용)
			System.out.println("m()끝");
		}
	}
	public static void m(String str) throws NullPointerException {
		int length = str.length();
		System.out.println("문자열의 길이는"+length);
	}
	public static void main(String[] args) {
		int i;
		Scanner sc = new Scanner(System.in);
		System.out.println("입력하세요 : ");
		String line = sc.nextLine();
		try {
			i = Integer.parseInt(line); //NumberFormatException 발생가능 (컴파일이 통과되도 어떤 예외가 발생할 수 있을지 예의주시해야한다)
			m(i);
		}catch(NumberFormatException e) {
			System.out.println("숫자로 입력하세요!");
		}
		m("자바"); //문자열길이 2
		m(""); //문자열길이 0
		try {
			m(null);
		}catch(NullPointerException e) {
			//아무말도 안하고 다음스텝으로 진행하는 것도 하나의 에외처리 방법
		}
		FileInputStream fis;
		try {
			fis = new FileInputStream("a.txt");
		}catch (FileNotFoundException e) {
			//e.printSTackTrace();
		
		String msg = e.getMessage(); //예외상세메시지얻기
		System.out.println(msg);
	}
	System.out.println("끝");

}
}
