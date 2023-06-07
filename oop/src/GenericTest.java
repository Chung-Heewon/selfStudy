import java.util.ArrayList;

public class GenericTest {

	public static void main(String[] args) {
		ArrayList<String> list; //Generic <> <> 안에 들어간 요소만 사용할 수 있다. 
		list = new ArrayList<>();
		
		list.add("One");
		list.add("two");
		list.add("three");
		
		String str1 = list.get(0);
//		Date dt1 = list.get(0);
	}

}
