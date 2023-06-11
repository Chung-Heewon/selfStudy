import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIOTest {

	public static void main(String[] args) {
		/**
		 * a.txt파일을 바이트단위로 읽기
		 * 자원 : a.txt파일
		 * 노드스트림 : FileReader
		 */
		FileReader fr=null;
		try {
			//fis = new FileInputStream("C:\\Users\\gram17z\\OneDrive\\Desktop\\263\\myJAVA\\aunicode.txt"); //절대경로
					//("..\\a.txt");//..\..\상위 경로의 상위 경로  //".resource\\a.txt"); //상대경로
			fr = new FileReader("..\\a.txt");
			//while(true) {
//				int readValue = fis.read();
//				if(readValue == -1) {
//					break;
//				}
			int readValue = -1;
			while((readValue = fr.read()) != -1) {
				System.out.println(readValue+":"+(char)readValue);
			}
			//fr.close(); // 자원과의 연결을 끊겠다. 
		}catch(FileNotFoundException e){ //자식 Exception
			e.printStackTrace();
		} catch (IOException e) { //부모 Exception
			e.printStackTrace();
		}finally {
			if(fr !=null)
				try {
					fr.close();
				} catch (IOException e) { 
				}
		}
	}
}
