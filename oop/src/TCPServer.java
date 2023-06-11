import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.BindException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class TCPServer {

	public static void main(String[] args) {
		ServerSocket ss = null;
		int port = 5432;
		try {
			ss = new ServerSocket(port); //포트열기
			Socket s=null;
			InputStream is = null;
			DataInputStream dis = null;

			//System.out.println((char)is.read());
			//			byte[] bArr = new byte[100];
			//			int readByteSize = is.read(bArr);
			//			String receiveMsg = new String(bArr,0,readByteSize);
			while(true) {
				String clientAddress = ""; //string""선언하여 try외에 바깥부분에서도 사용할 수 있도록 한다. 
				try {
					s=ss.accept(); //클라이언트의 접속을 기다린다.
					InetAddress clientIP=s.getInetAddress();
					clientAddress=clientIP.getHostAddress();
					System.out.println(clientAddress+" : 클라이언트가 접속했습니다.");
					is =s.getInputStream();
					dis = new DataInputStream(is);
					while(true) {
						String receiveMsg = dis.readUTF();
						if(receiveMsg.equals("quit")){
							break;
						}
						System.out.println("클라이언트"+clientAddress +">"+receiveMsg);
					}
				}catch (SocketException e) {
					System.out.println("클라이언트와 연결이 해제되었습니다.");
				}catch (IOException e) {
					e.printStackTrace();
				}finally {
					System.out.println("클라이언트"+clientAddress+"접속해제");
					if(s !=null) {
						try {
							s.close();
						}catch(IOException e) {

						}

					}
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
