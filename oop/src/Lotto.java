/**
 * 로또숫자 얻기 : 1~45사이의 중복되지 않는 6개 숫자
 * @author 정희원
 * @version 1.0
 */
//객체지향에서 필요한 기능들(모델링)을 먼저 나열한 후 코딩을 진행하는 것이다. 
public class Lotto {
	//제공자 코드 : main method X,실행자코드 : Main method
	//사용할 것으로 예상되는 기능들은 저장하고 있기!
	//로또숫자얻기 : 1~45 사이의 중복되지 않는 6개의 숫자 
	
		int[]lotto=new int[6];
		
		/**(다큐멘트용 코멘트) //사용설명서
		 * 로또숫자 계산한다. 
		 */
		public void make() {
			
			for(int i=0; i<lotto.length; i++) { //length = 배열이라는 특수 클래스의 멤버변수 (lotto 배열의 field)
				lotto[i] = (int)(Math.random()*45+1); //더블타입의 값을 반환을 한다. 1<= <46
				//중복
				for(int j=0; j<i; j++) {
					if(lotto[i]==lotto[j]) {
						//continue : 근접한 반복문으로 간다. 
						//break : 근접한 반복문을 빠져나온다.
						i--;
						break;
					}
			}	
	}
}
		/**
		 * index에 해당하는 로또 숫자를 반환한다. 
		 * index가 0이하이거나 index가 6이상인 경우는 -1를 반환한다.
		 * @param index 로또숫자위치 //매개변수
		 * @return 로또숫자값
		 */
		public int get(int index) {
			if(index<0||index>=lotto.length) {
				System.out.println("로또숫자위치["+index+"]가 잘못되었습니다.");
				return -1;
			}
			return lotto[index];
		}
		/**
		 * 모든 로또숫자들을 반환한다.
		 * @return 모든 로또숫자값들
		 */
		public int[] get() {
			return lotto; //멤버변수값
		}
		/**
		 * 로또숫자들을 출력한다.
		 */
		public void print() {
			for (int i=0; i<lotto.length; i++) {
				System.out.print(lotto[i]+"\t");	
			}
		System.out.println();
		}
}
