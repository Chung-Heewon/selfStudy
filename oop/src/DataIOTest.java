import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DataIOTest {
	
	public static void writeTest() {
		/**
		 * a.dat파일에 자료형별 쓰기
		 * 목적지 : a.dat파일
		 * 노드스트림 : FileOutputStream
		 * 필터스트림 : DataOutputStream
		 */
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream("..\\a.dat",true));
			dos.writeBoolean(false); //1byte
			dos.writeInt(99); //4byte
			dos.writeDouble(123.4); //8byte
			dos.writeUTF("가나"); //6byte
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dos !=null) {
				try {
					dos.close();
				} catch (IOException e) {
				}
			}
		}
	}
	public static void readTest() {
		/**
		 * a.dat파일을 자료형별로 읽기
		 * 자원 : a.dat파일
		 * 노드스트림 : FileInputStream
		 * 필터스트림 : DataInputStream
		 */
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream("..\\a.dat"));
			while(true) {
				boolean flag = dis.readBoolean();
				int i = dis.readInt();
				double d = dis.readDouble();
				String utf = dis.readUTF();
				System.out.println(flag + ":" + i + ":" + d + ":" + utf);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(EOFException e) {
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			if(dis !=null) {
				try {
					dis.close();
				}catch(IOException e) {
				}
			}
		}
		
	}
	public static void main(String[] args) {
		writeTest();
		readTest();
	}
}
