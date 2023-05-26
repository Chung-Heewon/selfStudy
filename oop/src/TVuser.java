
public class TVuser {

	public static void main(String[] args) {
		TV tv = new TV(); //TV : clasee type, tv : 변수
		tv.powerOn(); //티비를 켠다.
		if(tv.isPower()) {//티비가 켜져있다면 (결과값 반환하여 사용)
			tv.print(); //티비의 정보를 출력한다
						//ex)채널은 0번, 음량은 0
			
			tv.powerOff(); //티비를 끈다
			if(!tv.isPower()) { //티비가 꺼져있다면
				System.out.println("전원이 꺼졌습니다");
			}
		}
	}

}
