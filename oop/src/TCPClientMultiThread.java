import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
class TCPClientThread extends Thread{
	private Socket s;
	InputStream is = null;
	DataInputStream dis = null;
	public TCPClientThread(Socket s) throws IOException {
		this.s = s;
		is = s.getInputStream();
		dis = new DataInputStream(is);
	}
	public void run() {
		try {
			while(true) {
				String receiveMsg;				
				receiveMsg = dis.readUTF();
				System.out.println("서버>" + receiveMsg);
			}
		} catch(EOFException e) { //readUTF()에서 발생
		} catch(SocketException e) {
			System.out.println("서버와 연결이 해제되었습니다");
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
public class TCPClientMultiThread {
	public static void main(String[] args) {
		String serverIP = "192.168.0.21";//"192.168.0.34";//"127.0.0.1";//"192.168.0.13";
		//String serverIP = "127.0.0.1";
		int serverPort = 5432;
		Socket s = null;
		OutputStream os = null;
		DataOutputStream dos = null;

		//키보드로 입력하기
		Scanner sc = new Scanner(System.in);
		try {
			s = new Socket(serverIP, serverPort);
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			TCPClientThread t = new TCPClientThread(s);
			t.start();
			
			String sendMsg;
			do {
				sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);				
			}while(!sendMsg.equals("quit"));			

		} catch(EOFException e) { //readUTF()에서 발생
		} catch(ConnectException e) {
			System.out.println("서버를 찾지 못했습니다.");
		} catch(SocketException e) {
			System.out.println("서버와 연결이 해제되었습니다");
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(s != null) {
				try {
					s.close();
				} catch (IOException e) {
				}
			}
		}
	}

}
