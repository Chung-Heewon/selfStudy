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
import java.util.List;
import java.util.Vector;
class TCPServerBroadcastThread extends Thread{
	private Socket s=null;
	private InputStream is = null;
	private DataInputStream dis = null;
	private OutputStream os = null;
	private DataOutputStream dos = null;
	private String clientAddress = ""; 
	private List<TCPServerBroadcastThread> list;
	public TCPServerBroadcastThread(Socket s,List<TCPServerBroadcastThread> list) throws IOException {
		
		this.s =s;
		this.list = list;
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
				//dos.writeUTF(sendMsg);
				for(TCPServerBroadcastThread t: list) {
					t.dos.writeUTF(sendMsg);
				}
			}
		}catch (SocketException e) {
			System.out.println("클라이언트와 연결이 해제되었습니다.");
		}catch (IOException e) {
			e.printStackTrace();
		}finally {
			System.out.println("클라이언트"+clientAddress+" 접속해제");
			list.remove(this);
			if(s !=null) {
				try {
					s.close();
				}catch(IOException e) {
				}
			}
		}


	}
}
public class TCPServerBroadcast {
	public static void main(String[] args) {
		ServerSocket ss = null;
		int port = 5432;
		try {
			ss = new ServerSocket(port); //포트열기
			Socket s=null;
			List<TCPServerBroadcastThread>list = new Vector<>();
			while(true) {
				try {
					s=ss.accept(); //클라이언트의 접속을 기다린다.

					//새로운 스레드생성, 시작한다.
					TCPServerBroadcastThread t = new TCPServerBroadcastThread(s,list);
					list.add(t);
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

