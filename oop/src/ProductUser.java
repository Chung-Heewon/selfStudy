import java.util.List;
import java.util.Scanner;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.product.dao.ProductRepository;
import com.my.product.dto.Product;

public class ProductUser{
	static Scanner sc = new Scanner(System.in);
	ProductRepository repository = new ProductRepository();
	
	public void findAll(){// 키보드로 값을 입력받아서 전달하기 위한 용도 (검색하여 전달하는 역할)
		System.out.println(">>전체상품검색<<");
		List<Product> resultList;
		try {
			resultList = repository.selectAll();
			
			for(int i=0; i<resultList.size(); i++) {
				resultList.get(i).print();
			}
		} catch (FindException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			e.printStackTrace();
		}//실제로 자료에 있는 정보들을 검색 (저장소의 역할)
	}
	public void findByProdNo() {
		System.out.println(">>상품검색<<");
		System.out.print("상품번호를 입력하세요:");
		String noArg1 = sc.nextLine();//키보드로 입력받기
		System.out.print(noArg1);
		Product p;
			try {
				System.out.println(repository.selectByProdNo(noArg1) == null? "상품이 없습니다": "상품이 있습니다");
			} catch (FindException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public void add() {
		String a = "suwan";
				a.charAt(1);
		
		System.out.println(">>상품추가<<");
		System.out.print("상품번호를 입력하세요:");
		String prodNo = sc.nextLine();
		System.out.println("상품명을 입력하세요");
		String prodName = sc.nextLine();
		System.out.println("상품가격을 입력하세요 : ");
		int prodPrice = Integer.parseInt(sc.nextLine());
		Product pArg = new Product(prodNo, prodName, prodPrice);
		try {
			repository.insert(pArg);
		} catch (AddException e) {
			e.printStackTrace();
		}
	}
	public void findByProdName() {
		System.out.println(">>상품이름으로 검색<<");
		System.out.println(">>단어를 입력하세요. 단어를 포함한 상품명으로 검색합니다.<<");
		String word = sc.nextLine();//키보드로 입력받기
		List<Product> pList;
		try {
			pList = repository.selectByProdName(word);
			for(Product p : pList) {
				p.print();
			}
		} catch (FindException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args){
		 //최대 10개의 상품이 저장될 저장소가 된다
//				new ProductRepository(100); //최대 100개의 사품이 저장될 저장소
//				new ProductRepository(0); 
//				new ProductRepository(-1); //"저장소의 크기는 1이상이어야 합니다."출력한다, 
		ProductUser user = new ProductUser();
		String opt;
		do{
			System.out.println("작업을 선택하세요");
			System.out.print("1:상품전체검색,  2:상품번호로검색, 3: 상품추가, 4:상품이름으로 검색, 9: 종료");
			opt = sc.nextLine();//키보드로 입력받기
			if(opt.equals("1")){
				user.findAll();
					
					//Todo
					//상품번호, 상품명, 가격을 출력하시오
//					System.out.println("상품번호:" + resultArr[i].getProdNo());
				 //print 메소드 필요
		
			}else if(opt.equals("2")){
				user.findByProdNo();
				//Todo
				//상품이 존재하면 상품번호, 상품명, 가격을 입력하시오.
			}else if(opt.equals("3")){   
				user.add();
			}else if(opt.equals("4")){
				user.findByProdName();
			}else if(opt.equals("9")){
			}else{
				System.out.println("잘못입력하셨습니다");
			}
		}while(!opt.equals("9"));



		/*
        System.out.println(">>상품추가<<");
        Product pArg = new Product();
        pArg.prodNo = "G0001";
        insert(pArg);

        System.out.println(">>상품추가<<");
        Product pArg1 = new Product();
        pArg1.prodNo = "G0002";
        insert(pArg1);

        System.out.println(">>상품검색<<");
        String noArg1 = "G0002";
        //Product result1 = selectByProdNo(noArg1);
        //System.out.println(result1 == null? "상품이 없습니다": "상품이 있습니다"); //삼항연산자
        System.out.print(noArg1);
        System.out.println(selectByProdNo(noArg1) == null? "상품이 없습니다": "상품이 있습니다");

        System.out.println(">>상품검색<<");
        String noArg2 = "X";
        //selectByProdNo(noArg2);
        System.out.print(noArg2);
        System.out.println(selectByProdNo(noArg2) == null? "상품이 없습니다": "상품이 있습니다");

        System.out.println(">>전체상품검색<<");
			Product[]resultArr = selectAll();
        for(int i=0; i<resultArr.length; i++){
            System.out.println("상품번호:" + resultArr[i].prodNo);
        }
		 */
	}
}