import com.my.asia.Japan; //package.class 명을 각각 import 해서 사용하는 것 권장
import com.my.asia.Korea; //com.my.*.Korea;안됨

import com.my.europe.France;//

public class CountryTest {
	public static void main(String[] args) {
		com.my.asia.Korea k;
		k = new com.my.asia.Korea();
		
		Korea k1 = new Korea();
		France f= new France();
//		Japan j = new Japan();
		
		//k1.capital = "서울";
//		k1.capital = "평양";
//		k1.language = "일본어";
//		k1.population = -1;
		
//		System.out.println(k1.population.Korea);
		k1.print();
		k1.up();
		k1.down();
		k1.print();
	}

}
