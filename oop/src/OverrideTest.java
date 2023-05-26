class Shape{
	double area;
	void make() {
		
	}
	void print(){
		System.out.println("면적은" + area);
	}
	@Override
	public String toString() {
		return "도형의 면적은 : "+area;
	}

	
}
class Circle extends Shape{
	int radius;
	Circle(){
	}
	Circle(int r){
		radius = r;
	}
	void make() {
		area= Math.pow(radius, 2)*Math.PI;		
	}
	void print() {
		System.out.println("반지름이 "+radius+"인 원의 ");
		super.print();
	}
	public String toString() {
		return "원"+super.toString();
	}
}
class Rectangle extends Shape {
	int width, height;
	Rectangle(){
	}
	Rectangle(int width, int height){
		this.width=width;
		this.height=height;
	}	
	void make(){
		area = width*height;
	}
	void print() {
		System.out.println("가로"+width+", 세로"+height+"인 사각형의 ");	
		super.print();
	}
}
class Triangle {}
public class OverrideTest {
	public static void test(Shape s) {
		s.make();
		s.print(); // 오버라이딩을 진행하지않으면 다형성의 효과를 낼 수 없다. 
		System.out.println(s); //s.toString()매서드 호출됨
								//도형의 면적:~
								//도형의 면적:~
	}
	public static void main(String[] args) {
		Circle c;
		Rectangle r;
		Triangle t;
		c = new Circle(5); //반지름이 5인 원객체
		//		c.mc(); //원의 면적을 계산한다.
		//		c.print(); //"반지름이 5인 원의 면적은 ~입니다"가 출력된다.
		test(c);

		r = new Rectangle(3,4);
		//		r.mr();//사각형의 면적을 계산한다
		//		r.print();//"가로3 세로4인 사각형의 면적은 12.0 입니다. "
		test(r);
	}
}