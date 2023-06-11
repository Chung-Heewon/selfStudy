class J extends Thread{
	int sum;
	int i, j;
	J(int i, int j){
		this.i = i;
		this.j = j;
	}
	@Override
	public void run() {
		for(int i=this.i; i<=this.j; i++) {
			sum += i;
		}
	}
}
public class JoinTest {

	public static void main(String[] args) {
		J j1 = new J(1,50);
		J j2 = new J(51,100);
		j1.start();
		j2.start();
		try {
			j1.join(); //Main thread가 j1 thread 끝날때까지 기다린다. 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			j2.join(); //Main thread가 j1 thread 끝날때까지 기다린다. 
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		// j1,j2가 누가먼저 끝나던 main thread가 기다리는 것
		System.out.println("j1.sum=" +j1.sum+", j2.sum="+j2.sum);
		
	}

}
