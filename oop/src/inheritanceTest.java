import com.my.dto.Person;
import com.my.sudenta.dto.student;
class Parent{
	int a;
	void p() {
		System.out.println(a);
	}
}
class Child extends Parent{
	String a;
	void c() {
		System.out.println("현재객체의 a="+this.a+", 현재객체의 부모의 a="+ super.a); //현재 객체의 부모영역생성자호출한다.
	}
}
class Child2 extends Child{
	boolean a;
	void c2() {
		System.out.println(this.a+","+super.a); //false, null
		c(); //현재 객체의 a= null, 현재객체의 부모의 a=0
	}
}
public class inheritanceTest {
	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println(parent.a); //0
		System.out.println("-------------");
		Child c = new Child();
		System.out.println(c.a); // null
		c.a = "hello";
		
		parent.p(); //0
		c.c();//hello
		c.p(); //0
		
		
		Person p;
		p=new Person();
		student s;
		s = new student();
		p.setName("사람");
		s.setName("학생");
		s.setNo("학번");
		
	}

}
