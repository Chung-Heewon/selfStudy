import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.stream.Stream;

public class JCFTest {
	public static void m(Collection c) {
		c.add("one");
		c.add(2);
		c.add(true);
		c.add(new String("one"));
		c.add(4.0F);
		
		System.out.println("자료수:"+c.size());
		System.out.println(c); //c.toString()자동호출됨
		
		/**
		 * Iterator를 이용해서 자료 출력
		 */
//		Iterator it = c.iterator();
//		while(it.hasNext()) {
//			System.out.println(it.next());
//		}
		/**
		 * for문을 사용해서 자료 출력
		 */
//		for(Object o:c) {
//			System.out.println(o);
//		}
		/**
		 * Stream 사용해서 자료 출력
		 */
		Stream st = c.stream();
		st.forEach(System.out::println);
	}
	
	public static void m(Map m) {
		m.put("one", "first");
		m.put(2, "second");
		m.put(true, "third");
		m.put(new String("one"), "fourth");
		m.put(4.0F, "fifth");
		System.out.println("자료수:"+m.size());
		System.out.println(m);
		
		Object value = m.get("one");
		System.out.println("Key:one, value: "+value);
		
		java.util.Date d = (java.util.Date)value; //강제형변환 
		
		/**
		 * iterator 사용해서 추출
		 */
//		Set keys = m.keySet();
//		Iterator it = keys.iterator();
//		while(it.hasNext()) {
//			Object key = it.next();
//			Object value2 = m.get(key);
//			System.out.println("key:"+key+",value:"+value2);
		/**
		 * for문 사용해서 추출
		 */
//		for(Object key : m.keySet()) {
//			Object value2 = m.get(key);
//			System.out.println("key:"+key+",value:"+value2);
//		}
		/**
		 * 람다 표현식으로 추출
		 */
		m.keySet().stream().forEach(key->System.out.println("key:" + key+",value:" + m.get(key)));
	}
	public static void main(String[] args) {
		Collection c;
//		c = new Collection();
		c = new ArrayList(); //하위클래스타입(ArrayList)을 생성해서 상위클래스타입을 업캐스팅
		m(c);
		
		c = new HashSet();
		m(c);
		
		Map m ;
		m= new HashMap();
		m(m);

	}

}
