
public class Operator {
	public static void main(String[] args) {
		int a,b,c;
		
		//산술연산자 +,-,[/,*,%(나머지값을 얻고 싶은 경우(모듈러 연산자))] -> 연산 우선순위가 높다. 
		a=3;
		b=5;
		c=a+b;
		System.out.println(c); //8
		System.out.println(a-b); //-2
		System.out.println(a/b); //0
		System.out.println(b/a); //1
		System.out.println(a%b); //3
		System.out.println(b%a); //2
		
		System.out.println(a+b*c); //연산먼저처리 43
		System.out.println(a+b-c); //연산우선순위가 같은 경우에는 왼쪽에서 오른쪽으로 연산처리 0
		//System.out.println(a/0); //ArithemticException예외 발생. 프로그램이 자동종료됨
		
		short sa, sb, sc;
		sa=3;
		sb=5;
		sc=(short)(sa+sb); //sa,sb값이 int로 자동형변환 (int 타입의 값을 short타입에 대입하려고 했음, 더 큰 자료형은 작은 자료형으로 자동변환이 안됨으로 강제형 변환을 해줘야한다)
		          //short타입인 sc에 대입되려면 sa+sb결과가 short 타입으로 강제형변환 필요
		System.out.println(sc);//8		
		
		
		//비교연산자 >(초과),<,>=(이상),<=,==,!==(같지 않다) => Boolean 타입의 결과값
		a=3;
		b=5;
		System.out.println(a>b); //false
		System.out.println(a<b); //true
		System.out.println(a==b); //false
		System.out.println(a!=b); //true
		
		//대입연산자 =, +=(변수에 얼마만큼 더해서 증가한다),-=,*=,/=,%=  {다른 연산자보다 우선순위가 낮다}
		a=3;
		b=5;
		a+=1; //a값에 1증가하여 a에 대입 (a=a+1;와 같음)
		System.out.println(a); //4
		
		a-=2; //a값에 2감소하여 a에 대입 a=a-2;와 같음
		a*=3;
		a/=4;
		a%=5;
		
		
		//단항연산자(증감연산자) ++,-- {다른 연산자보다 우선순위가 높다}
		a=3;
		a++;
		System.out.println(a); //4
		
		byte by;//-128~127
		by=127;
		by=(byte)(by+1); // Maxmum +1하면 minimum으로 돌아간다. (bit들의 최종결과)
		System.out.println(by);
		
		by=127;
		by+=1;
		System.out.println(by);
		
		by=127;
		by++;
		System.out.println(by);
		
		//삼항연산자 ? :
		a=3;
		String result = a%2==0?"짝수":"홀수"; //변수의 값이 짝수인가 비교한는 것
		System.out.println(result); //홀수
		
		//논리연산자 [&(and-이고, 둘다 true 일때 반환)]->연산 우선처리,|(or-이거나), &&, ||, !(not) 순서 : &->|->!
		a=3;
		b=5;
		System.out.println(a < b & a%2==1); //true
		System.out.println(a > b & a%2==1); //false
		System.out.println(a > b & a%2==0); //false
		System.out.println(a < b & a%2==0); //false
		
		System.out.println(a < b && a%2==1); //true 
		System.out.println(a > b && a%2==1); //false
		System.out.println(a > b && a%2==0); //false
		System.out.println(a < b && a%2==0); //false 
		//왼쪽이 False이면 아예 연산에 참여하지 않는다, 처리속도가 빠르다. (&하나일 때나 &&두개일 때 결과값은 같다.)
		//shoot  circuit operator
		

		System.out.println(a < b | a%2==1); //true 
		System.out.println(a > b | a%2==1); //true
		System.out.println(a > b | a%2==0); //true
		System.out.println(a < b | a%2==0); //false 
		
		System.out.println(a < b || a%2==1); //true 
		System.out.println(a > b || a%2==1); //true
		System.out.println(a > b || a%2==0); //true
		System.out.println(a < b || a%2==0); //false
		//|하나는 원쪽, 오른쪽 모두 연산에 참여, ||는 왼쪽이 true이면 연산은 모두 true(연산참여 없이)
		
		System.out.println(!(a < b)); //false
		
		//연산우선순위 높이기 : ( )
		//비트연산자
		//논리연산자와 비트연산자는 구분이 필요하다.
	    a=1;
	    b=0;
	    System.out.println(a&b); // int & int : 비트연산
	    System.out.println(a|b); // int & int : 비트연산
	    System.out.println(a<b & a%2==1); // boolean & boolean : 논리연산자 (분리 타입의 좌측, 우측인 경우는 논리연산자)
	    System.out.println(a<b | a%2==1);
	    
		
	}

}
