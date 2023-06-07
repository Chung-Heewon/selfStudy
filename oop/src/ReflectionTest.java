import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Scanner;

public class ReflectionTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("클래스이름을 입력하세요. ex)java.util.Date");
		String className = sc.nextLine();
		try {

			Class<?> clazz=Class.forName(className); //RuntimeDynamicLoad
			Method[] methods = clazz.getDeclaredMethods();
			for(Method m : methods) {
				System.out.println(m.getName());
			}
			//clazz.newInstance();
			try {
				Constructor Constructor = clazz.getConstructor(null);
				try {
					Object obj = Constructor.newInstance(); //obj.toString()가 자동호출됨
					System.out.println(obj);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (NoSuchMethodException | SecurityException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
