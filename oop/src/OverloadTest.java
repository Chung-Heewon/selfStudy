//오버로드된 메소드
class R{ //사각형
	double area;
	void make(double w) {
		area=w*w;
	}
	void make(double w, double h) {
		area=w*h;
	}
	void print() {
		System.out.println("사각형의 면적은"+area+"입니다.");
	}
}
public class OverloadTest {

	public static void main(String[] args) {
		R r1=new R();
		r1.make(3,4); // int type 인자가 2개라 -> 2개짜리 double 타입으로 자동 전달 
		
		R r2=new R(); // double 타입의 인자하나만 전달 -> 매개변수 하나에 전달
		r2.make(5.0);
		
		r1.print();
		r2.print();
		
	}

}
