import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
class TCPServerThread extends Thread{
	private Socket s=null;
	private InputStream is = null;
	private DataInputStream dis = null;
	private OutputStream os = null;
	private DataOutputStream dos = null;
	private String clientAddress = ""; 
	public TCPServerThread(Socket s) throws IOException {
		this.s =s;
		is =s.getInputStream();
		dis = new DataInputStream(is);
		os = s.getOutputStream();
		dos = new DataOutputStream(os);
		InetAddress clientIP=s.getInetAddress();
		clientAddress=clientIP.getHostAddress();
		System.out.println(clientAddress+" : 클라이언트가 접속했습니다.");
	}
	public void run() {
		try {
			String sendMsg;
			while(true) {
				String receiveMsg = dis.readUTF();
				System.out.println(clientAddress+">"+receiveMsg);

				if(receiveMsg.equals("quit")){
					break;
				}
				sendMsg = receiveMsg;
				dos.writeUTF(sendMsg);
			}
		}catch (SocketException e) {
			System.out.println("클라이언트와 연결이 해제되었습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("클라이언트"+clientAddress+" 접속해제");
			if(s !=null) {
				try {
					s.close();
				}catch(IOException e) {
				}
			}
		}


	}
}
public class TCPServerMultiThread {
	public static void main(String[] args) {

		ServerSocket ss = null;
		int port = 5432;
		try {
			ss = new ServerSocket(port); //포트열기
			Socket s=null;

			while(true) {
				try {
					s=ss.accept(); //클라이언트의 접속을 기다린다.

					//새로운 스레드생성, 시작한다.
					TCPServerThread t = new TCPServerThread(s);
					t.start();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}catch (IllegalArgumentException e) {
			System.out.println(port+"포트가 틀렸어요");
		}catch (BindException e) {
			System.out.println("포트는 이미 사용중입니다.");
		}catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("TCPSERVER END");
	}
}

