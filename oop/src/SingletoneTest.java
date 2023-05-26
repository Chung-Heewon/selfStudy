class Single{
	static private Single s = new Single();
	private Single() {}
	static Single getInstance(){
		//return new Single();
		return s;
	}
}
public class SingletoneTest {
	public static void main(String[] args) {
//		Single s1 = new Single(); //사용못하게 해야 한다.
//		Single s2 = new Single();
		Single s1= Single.getInstance();
		Single s2= Single.getInstance();
		System.out.println(s1==s2); //false
	}
}
