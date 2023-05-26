/**
 * TV객체용 클래스
 * 
 * @author 정희원
 * @version 1.0
 */
public class TV { 
	
	boolean power;
	int ch;
	int vol;
	/**
	 * 전원은 켠다.
	 */
	void powerOn() {
		power = true;
	}
	/**
	 * 전원을 확인한다. 
	 * @return 켜져있으면 True반환, 꺼저있으면 false를 반환한다.
	 */
			
	boolean isPower() {
		return power;
	}
	void print () {
		System.out.println("채널은"+ch+","+"음량은"+vol);
	}
	void powerOff() {
		power = false;
	}
}