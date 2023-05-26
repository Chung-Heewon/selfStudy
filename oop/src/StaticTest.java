class A{
	int i; //non-static변수, instance변수
	static int si; //static변수, class 변수 - static 변수와 무관하게 사용할 수 있음 //객체와 무관
	void m() { //non-static메서드 (객체생성 후에만 사용할 수 있는 메서드)
		i++;
		si++;
	}
	static void sm() { // 객체 생성과 무관하게 사용
		//i++; //this.i++와 같다, instance 변수 사용X, non-static 메소드 호출도 불가
		si++; 
		
	}
}
public class StaticTest {

	public static void main(String[] args) {
		A.si++; //class 이름. 으로 si = class 변수라고도 함
		System.out.println(A.si); //1
		
		A a1, a2;
		a1 = new A();
		a2 = new A();
		a1.i++;
		a2.i++;
		
		a1.si++; //객체를 찾은 다음에 class안에서 찾는 것보다 class 영역에서 바로 찾는게 좋다.
		a2.si++;
		
		System.out.println(a1.i); //1 //객체별로 가지고 있는 i instance변수는 다른 것
		System.out.println(a2.i); //1
		
		System.out.println(a1.si); //3 // si : 객체들 사이에 공유변수로 쓰이는 것, 객체가 달라도 같은 static 변수
		System.out.println(a2.si); //3
		
		a1.m(); //void m() { (this).i++; }
		System.out.println(a1.i); //2
		System.out.println(a2.i); //1
		
		System.out.println(A.si); //4
		
		//a1.sm();
		A.sm(); //권장(class 이름. )
	}
}
