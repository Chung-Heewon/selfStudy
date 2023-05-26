import java.util.StringTokenizer;

public class StringTest {

	public static void main(String[] args) {
		String s1, s2, s3, s4;
		s1 = "HELLO";
		s2 = new String("HELLO");
		s3 = new String("HELLO");
		s4 = "HELLO";
		System.out.println(s1==s2); //false
		System.out.println(s2==s3); //false
		System.out.println(s1==s4); //false

		System.out.println(s1.equals(s2)); //true
		System.out.println(s2.equals(s3)); //true
		System.out.println(s1.equals(s4)); //true

		//TODO Palindrome문자열입니다 또는 Palindrome문자열이 아닙니다 
		String palindrome = "소주만병만주소"; //LEVEL, SOS, ROTATOR, 기러기
		int size = palindrome.length();
		//boolean flag = true;
		int i;
		for(i=0; i<size/2; i++) {
			char c1 = palindrome.charAt(i); //앞
			char c2 = palindrome.charAt(size-1-i); //뒤
			if(c1 != c2) { 
				//flag = false;
				break;
			}
		}		
		//if(flag) {
		if(i == size/2) {
			System.out.println("Palindrome문자열입니다");
		}else {
			System.out.println("Palindrome문자열이 아닙니다");
		}
		String score = "54:89:30";
		String [] scoreArr = score.split(":"); //split은 무조건 분리
		System.out.println("국어:"+Integer.parseInt(scoreArr[0]));
		System.out.println("영어:"+scoreArr[1]);
		System.out.println("수학:"+scoreArr[2]);


		score = "54::30";
		scoreArr = score.split(":");
		System.out.println("국어:" + Integer.parseInt(scoreArr[0]));
		System.out.println("영어:" + scoreArr[1]);
		System.out.println("수학:" + scoreArr[2]);
		int k = Integer.parseInt(scoreArr[0]);
		int e = scoreArr[1].equals("")?0:Integer.parseInt(scoreArr[1]);
		int m = Integer.parseInt(scoreArr[2]);
		System.out.println("평균:" + ((float)(k+e+m)/scoreArr.length));

		System.out.println("--------------");
		StringTokenizer st = new StringTokenizer(score, ":");

		int sum = 0; //총점
		int cnt = 0; //과목수
		while(st.hasMoreTokens()) { //score문자열에 :구분자로 분리할 문자열이 있는가
			String s = st.nextToken();
			System.out.println(s);
			sum += Integer.parseInt(s);
			cnt++;
		}
		System.out.println("평균:" + ((float)sum/cnt));

		String urlStr = 
				"https://m.new.naver.com/mnews/article/215/00001474?sid=103";
		parseURL(urlStr);
		
		String fileName = "a.txt";
		parseName(fileName);
	}
	static void parseURL(String url) {
		//TODO url에서 사용하는 프로토콜을 출력하시오.
		//URL구성요소-//프로토콜 : //호스트명/패스?쿼리
		//hint : indextOf(),substring()
	int protocol = url.indexOf(":");
	int query = url.indexOf("?");
	System.out.println("프로토콜명:"+url.substring(0,protocol));
		
		//호스트값 출력하시오 ex)m.new.naver.com
		//패스값출력하시오 ex)mnews/article/215/00001474
		//쿼리변수이름과 변수값을 출력하시오 변수이름:sid 변수값 : 103
	String [] hostArr = url.split("/");
	System.out.println("호스트값:"+hostArr[2]);
	System.out.println("패스값:"+hostArr[3]+"/"+hostArr[4]+"/"+hostArr[5]+"/"+hostArr[6].substring(0,hostArr[6].indexOf("?")));
	
	System.out.println("변수이름:변수값 : ");
	}
	
	//선생님이 하신 것

	/*
	 * String[] arr = url.split("\\?"); //?구분자로 분리 //정규표현식 형태로 이용되어야한다.(?는 문법에 사용되는
	 * 기호라 문자에 사용되는 ?라는걸 알려줘야한다)
	 * 
	 * String[] protocolHostPath = arr[0].split("/");
	 * 
	 * String protocol = protocolHostPath[0].substring(0,
	 * protocolHostPath[0].indexOf(":")); System.out.println("프로토콜명:" +protocol);
	 * 
	 * String host = protocolHostPath[2]; System.out.println("호스트값:" + host);
	 * 
	 * String path = ""; for(int i=3; i<protocolHostPath.length; i++) { if(i>2) {
	 * path += "/"; } path += protocolHostPath[i]; } if(protocolHostPath.length > 2)
	 * { System.out.println("패스값:" + path); }
	 * 
	 * if(arr.length == 2) { String []query = arr[1].split("\\&"); for(int i=0;
	 * i<query.length; i++) { String[] queryNameValue = query[i].split("="); String
	 * queryName = queryNameValue[0]; String queryValue = queryNameValue[1];
	 * System.out.println("쿼리변수이름:" + queryName + ", 변수값:" + queryValue); } }
	 */

	
	static void parseName (String fileName) {
		//TODO 파일의 확장자를 구분한다
		//ex) a.txt파일인 경우 "확장자는 txt입니다"를 출력한다.
		int str = fileName.lastIndexOf("."); //indextOf()
		String s = fileName.substring(str+1);
		System.out.println(s);
	}
}