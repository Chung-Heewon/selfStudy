class F{
	final int i=10;
	static final int SI = 10; //상수(class 이름.으로 사용, 값 변경 불가능 변수), 대문자
}
public class FinalTest { //변수 앞에 붙

	public static void main(String[] args) {
		F f = new F();
		System.out.println(f.i);
		//f.i++; //변수값은 값 변경이 불가능하다. 
		
		final int lv;
		lv=10;
		//iv++;
		
		System.out.println(F.SI);
		//f.si++; final 값 변경 불가능
	}
}
// 변수 앞에 붙을 수 있는 modify어 final, static, public


