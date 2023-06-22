import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
	private static ServerSocket serverSocket = null;
	
	public static void startServer() {
		Thread thread = new Thread() {
			public void run() {
				try {
					serverSocket = new ServerSocket(50001);
					System.out.println("[서버] 시작됨");
					
					while(true) {
						System.out.println("\n[서버] 연결 요청을 기다립니다.\n ");
						
						Socket socket = serverSocket.accept();
						
						InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
						System.out.println("[서버]"+isa.getHostName()+"의 연결 요청을 수락함");
						DataInputStream dis = new DataInputStream(socket.getInputStream());
						String message = dis.readUTF();
						
						DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
						dos.writeUTF(message);
						dos.flush();
						
						socket.close();
						System.out.println();
					}
					
				}
			}
		}
	}

	public static void main(String[] args) {
		System.out.println("----------------------------------------");
		System.out.println("서버를 종료하려면 q를 입력하고 Enter 키를 입력하세요.");
		System.out.println("----------------------------------------");
		
		startServer();
		
	}
}
