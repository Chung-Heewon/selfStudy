//생성자 = class 이름과 같아야한다. 
class R2{
	int width;
	int height;
	double area;
	R2(){ //생성자를 명시하지않으면 default라고 자동으로 생성자가 생성된다.
		
	}
	R2(int size){ //인자값이 한개일때의 생성자도 만들어야한다.
		width=size;
		height=size;
		make();
	}
	R2(int w, int h){
		width = w;
		height = h;
		make();
	}	
	void make(){
		area = width*height;
		}
	void print() {
		System.out.println("사각형의 면적"+area+"입니다.");			
	}
}
class C{
	int radius;
	double area; //도형의 고유한 특성, 지역변수가 아닌 멤버변수로 선언해야한다.
	C(){
		
	}
	C(int r){
		radius = r;
		make();
	}
	void make() {
		area= radius*radius*3.14;		
	}
	void print() {
	System.out.println("반지름이 "+radius+"인 우너의 면적은"+area+"입니다.");
	}
}
class Employee{
	String empNo;
	String empName;
	int salary=0;
	Employee(){
		
	}
	Employee(String empNo, String empName, int salary){
		this.empNo= empNo;
		this.empName=empName;
		this.salary= salary;
	}
	Employee(String empNo,String empName){
		this.empNo=empNo;
		this.empName=empName;
	}
	void print() {
		System.out.println("사번 : "+empNo+" 사원명 : "+empName+" 기본급 : "+ salary);
	}
}
public class test2 {
	public static void main(String[] args) {
		R2 r = new R2();
		r.width = 3;//가로
		r.height = 4;//세로
		r.make(); //면적을 게산한다.
		r.print(); //"가로3, 세로4인 사각형의 면적은 12.0입니다"출력된다.
		
		R2 r1= new R2();
		r1.width = 5;
		r1.height = 5;
		r1.make();
		r1.print(); //"가로5, 세로5인 사각형의 면적은 25.0입니다" 출력된다.
		
		R2 r2 = new R2(6,7); //생성자(특수 메소드) 자동 호출부분, 객체 생성하면서 객체를 초기화
//		r2.width = 6;
//		r2.height = 7;
//		r2.make();
		r2.print(); //"가로6, 세로7인 사각형의 면적은 42.0입니다" 출력된다.
		
		R2 r3 = new R2(8);
		r3.print(); //"가로8, 세로8인 사각형의 면적은 64.0입니다"출력된다.
		
		C c1= new C(); //원객체를 생성한다.
		c1.radius = 5;
		c1.make(); //원의 면적을 계산한다.
		c1.print(); //"반지름이 5인 원의 면적은 xx.xxx입니다" 출력된다.
		
		C c2 = new C(6); //반지름이 6인 원객체를 생성한다.
		c2.print();//"반지름이 6인 원의 면적은 xx.xxx입니다" 출력된다.
		
		Employee e1= new Employee();
		e1.empNo = "2301";
		e1.empName = "오문정";
		e1.salary = 10000;
		
		Employee e2 = new Employee("2302","홍길동",10000);
		Employee e3 = new Employee("2303","나자바");
		
		e1.print(); //"사번:2301, 사원명: 오문정, 기본급 : 10000
		e2.print(); //"사번:2302, 사원명: 홍길동, 기본급 : 10000
		e3.print(); //"사번:2303, 사원명: 나자바, 기본급 : 0
		
		
	}
}
