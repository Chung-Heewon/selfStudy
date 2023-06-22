
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerExample {
	private static ServerSocket ServerSockt = null;
	
	public static void main(String[] args) {
		System.out.println("----------------------");
		System.out.println("서버를 종료하려면 q또는 Q를 입력하고 Enter키를 입력하세요");
		System.out.println("----------------------");
		
		//TCP 서버시작
		startServer();
		
		Scanner scanner = new Scanner(System.in);
		while(true) {
			String key = scanner.nextLine();
			if(key.toLowerCase().equals("q")) {
				break;
			}
		}
		scanner.close();
		
		//TCP 서버 종료
		stopServer();
			}
	
	public static void startServer() {
		Thread thread = new Thread();
		public void run() {
			ServerSocket = new ServerSocket(50001);
			System.out.println("[서버] 시작됨");
			while(true) {
				System.out.println("\n[서버] 연결 요청을 기다림\n");
				
				//연결수락
				Socket socket = serverSocekt.accept();
				
				InetSocektAddress isa = 
						(InetSocektAddress) socket.getRemoteSocektAddress();
				System.out.println("[서버]"+isa.getHostName()+"의 연결 요청을 수락함");
				
				//연결끊기
				socket.close();
				System.out.println("[서버]"+isa.getHostName()+"의 연결을 끊음");
			}catch(IOException e) {
				System.out.println("[서버]"+e.getMessage());
			}
		}
	};
	
	//스레드 시작
	thread.start();
			}
public static void stopServer() {
	try {
		//ServerSocekt을 닫고 Port 언바이딩
		ServerSocket.close();
		System.out.println("[서버] 종료됨");
	}catch (IOException e1) {
	}
		}
	}

}
