import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileTest {
	public static void test(File f) {
		String name = f.getName();
		System.out.print(name);
		
		boolean directory = f.isDirectory();
		if(directory) {
			System.out.println("디렉토리입니다.");
			File[]files=f.listFiles();
			for(File subf:files) {
				String subName = subf.getName();
				System.out.print(subName);
				if(subf.isDirectory()) {
					System.out.println("폴더");
				}else {
					System.out.print("파일");
					long subLength = subf.length();
					System.out.println("크기: "+ subLength);
				}
			}
		}else {
			System.out.println("디렉토리가 아닙니다.");
			System.out.println("파일크기 : " +f.length());
			System.out.println(f.canWrite()?"쓰기가능":"쓰기금지");
			//if(f.canWrite() ==true){
			//if(f.canWrite())      ){는 같음
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			System.out.println("최종사용시간 : "+sdf.format(new Date(f.lastModified())));
		}
	}
	public static void deleteTest(File f) {
		if(f.exists()) {
			if(f.delete()) {
				System.out.println(f.getName()+"삭제 성공");
			}else {
				System.out.println(f.getName()+"삭제 실패");
			}
		}else {
			System.out.println(f.getName()+" 없습니다.");
		}
	}
	public static void createTest(File f) {
		if(!f.exists()) {
			try {
				if(f.createNewFile()) {
					System.out.println(f.getName()+" 생성성공");
				}else {
					System.out.println(f.getName()+" 생성실패");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println(f.getName()+" 있습니다.");
		}
	}
	public static void pathTest(File f) {
		System.out.println("f.getName():"+f.getName());
		System.out.println("f.getAbsolutePath():"+f.getAbsolutePath());
		System.out.println("f.getParent()"+f.getParent());
		System.out.println("f.getPath()"+f.getPath());
	}
	public static void main(String[] args) {
		File f; //file 변수 선언
		f = new File("C:\\Users\\gram17z\\OneDrive\\Desktop\\263\\myJAVA");
		test(f);

		f = new File("C:\\Users\\gram17z\\OneDrive\\Desktop\\263\\커리큘럼\\5월.png");
		test(f);
		
		f = new File("C:\\Users\\gram17z\\OneDrive\\Desktop\\263\\커리큘럼\\5월.png");
		deleteTest(f);
		
		f = new File("C:\\Users\\gram17z\\OneDrive\\Desktop\\263\\myJAVA\\test.txt");
		createTest(f);
		
		pathTest(f);
		pathTest(new File("."));
	}
}
