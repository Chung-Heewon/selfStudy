import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ConnectException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class TCPClient {

	public static void main(String[] args) {
		String serverIP = "192.168.0.9";
		int serverport = 5432;
		Socket s = null;
		OutputStream os = null;
		DataOutputStream dos = null;
		//키보드로 입력하기
		Scanner sc = new Scanner(System.in);
		try {
			s = new Socket(serverIP, serverport);
			os = s.getOutputStream();
			dos = new DataOutputStream(os);
			
		
			//String sendMsg = "안녕하세요!!!!!!!!!";
			//os.write(sendMsg.getBytes());//("UTF-8"));
			//os.write(65);
			
			//키보드로 quit문자열까지 서버로 send 반복한다
			//선생님이 하신것
			String sendMsg;
			do {
				sendMsg = sc.nextLine();
				dos.writeUTF(sendMsg);
			}while(!sendMsg.equals("quit"));
			
			//내가한것
//			while(true) {
//				String sendMsg = sc.nextLine();
//				if(sendMsg.equals("quit")) {
//					dos.writeUTF(sendMsg);
//					break;
//				}else {
//					dos.writeUTF(sendMsg);
//				}
//			}
		} catch (UnknownHostException e) {
		}catch(ConnectException e) {
		System.out.println("서버를 찾지 못했습니다.");
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
