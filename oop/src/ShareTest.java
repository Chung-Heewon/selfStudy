
class Share {
	int balance;
	public void push() {
		for(int i= 0; i<100;i++) {
			synchronized (this) {
				this.notify(); //공유객체를 사용하는 wait 스레드를 깨운다.
				System.out.print("before push:"+balance);
				balance++;
				System.out.println(", after push:"+balance);
			}
		}
	}
	public void pop() {
		for(int i = 0; i<100; i++) {	
			synchronized (this){
				if(balance ==0)
					try {
						this.wait(); //공유객체를 사용하는 스레드를 일시중지한다.
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				System.out.print("before pop:"+balance);
				balance--;
				System.out.println(" after pop:"+balance);
			}
		}
	}
class Push extends Thread{
	

	Share s;
	Push(Share s){
		this.s = s;
	}
	@Override
	public void run() {
		s.push();
	}
}
class Pop extends Thread{

	Share s;
	Pop(Share s){
		this.s=s;
	}
	@Override
	public void run() {
		s.pop();
	}
}
public class ShareTest {


	public static void main(String[] args) {
		Share s;
		s = new Share();
		//s.balance = 0; //초기값은 선언 X

		Push ps ;
		ps = new Push(s);
		//ps.s = s;
		ps.start();

		Pop po;
		po = new Pop(s);
		po.start();
	}
}
