import java.text.SimpleDateFormat;
import java.util.Date;
class Fifth implements Runnable{
	int max = 100;
	@Override
	public void run() {
		for(int i=0; i<max; i++) {
			System.out.println(i+" : CAPTION PLAY");
			
		}
	}
}
class Fourth implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("동영상 PLAY");
		}
	}
}
class Third implements Runnable{

	@Override
	public void run() {
		for(int i=0; i<100; i++) {
			System.out.println("SOUND PLAY");
		}
	}
}
class Second implements Runnable{

	@Override 
	public void run() {		
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");

		for(int i=0; i<10; i++) {
			System.out.println(sdf.format(new Date()));
			long mills = 1000; //1000분의 1000초
			//부모쪽에서 throws된 Exception만 자식메소드에서 선언가능
			try {
				Thread.sleep(mills);
			} catch (InterruptedException e) {
				e.printStackTrace();

			}
		}
	}
}
class First extends Thread{
	@Override
	public void run() {
		//스레드가 할 일
		
		String tName = Thread.currentThread().getName();
		for(int i=1; i<=100; i++) {
			System.out.println(tName + ":"+i);
		}
	}
}
public class ThreadTest {
	public static void test() {
		Thread t = Thread.currentThread();
		String tName = t.getName();
		System.out.println("test() 현재사용중인 스레드 이름 : "+ tName);
	}
	public static void main(String[] args) {
		First f1 = new First();
		First f2 = new First();
		Second s = new Second();
		Thread t1 = new Thread(s);
		//f1.run(); // run method 직접 호출 절대 안됌!!!!
		f1.start();
		f2.start();
		t1.start();


		Thread t = Thread.currentThread();
		String tName = t.getName();
		System.out.println("main() 현재사용중인 스레드 이름 : "+ tName);
		test();

		new Thread(new Third()).start();
		new Thread(new Fourth()).start();
		Fifth fifth = new Fifth();
		Thread t2 = new Thread(fifth);
		t2.start();
		try {
			Thread.sleep(10); //메인스레드일시중지
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		//t2.stop(); //강제종료
		fifth.max =0;
		
		new Thread(new Runnable() {
			public void run() {
				for(int i =0; i<10; i++) {
					System.out.println("익명클래스형태의 스레드");
				}
			}
		}).start();
		new Thread(()->{
			for(int i=0; i<10; i++) {
				System.out.println("람다식형태의 스레드");
			}
		}).start();
	}
}
