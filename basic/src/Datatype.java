
public class Datatype {

	public static void main(String[] args) {
		// byte, short, int(인트), long, float, double, char(씨에이치에이알), boolean
		byte b;
		b=127;
		//b=128;
		
		//리터럴
		System.out.println(1); //컴파일러가 1를 int로 이해
		System.out.println(123.4);//컴파일러가 123.4를 double로 이해
		
		long lon = 1234567894123545125L;
		float f = 123.4F;
		
		char c = '가'; //'A'는 십진수65로 컴퓨터가 이해, 'a'는 십진수97로 이해
		c = '㉿'; 
		
		boolean flag = true;
		flag = false;
		//flag = 1;
		
		//형변환
		lon = b; //byte->long자동형변환
		System.out.println(lon); //127
		
		lon = (long)f; //float->long 자동형변환 안됨, 강제형변환(자료형)대입할 값
		System.out.println(lon);//123
	
		lon = c ; //char타입은 int이상의 자료형으로 자동형변환 가능
		System.out.println(lon);//c: 가, lon: 12927
		short sh; 
		//sh = c;
		
		//boolean자료형과는 형변환 불가
		//flag = b;
		//flag = (boolean) b;
		
		
		
	}

}
