import java.io.IOException;
import java.io.InputStream;
import java.util.Scanner;

public class KeyboardTest {

	public static void main(String[] args) {
		/**
		 * 키보드자원으로부터 한문자씩 입력받기
		 * 자원 : 키보드
		 * 노드스트림 : System.in
		 * 필터스트림 : InputStreamReader
		 */
		InputStream is = System.in;
		//InputStreamReader ir = null;
		Scanner sc = null;
	//	try {
			//int readValue = is.read();
//			ir = new InputStreamReader(is);
//			int readValue = ir.read(); //한문자를 입력받아서 int타입으로 변환
//			//System.out.println("입력된 값 : "+readValue+", 문자값 : "+(char)readValue);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
			
			sc = new Scanner(is);
			String readLine = sc.nextLine(); //next int => int타입의 값을 받는 것
			System.out.println("입력된 값 : " +readLine);
			
			//String read = sc.next();
			
			
//			int i = sc.nextInt();
//			System.out.println(i);
//			int j = sc.nextInt();
//			System.out.println(j);
//			System.out.println(sc.nextLine());
	}
}
