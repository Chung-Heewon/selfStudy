package com.my.product.dao;
import com.my.product.dto.Product;

public class ProductRepository{
//    private Product[] pArr = new Product[5];
    //Product[] pArr;
	private Product[] pArr; //참조형 product 배열타입, 자동초기화
    private int totalCnt = 0; //저장소에 저장된 상품수, 자동초기화(0값이 없어도 자동초기화: 0)
    public ProductRepository() {
    	pArr = new Product[5];
    }
    public ProductRepository(int maxSize) {
    	if(maxSize <=0) {
    		maxSize =5;
    	}
    	pArr = new Product[maxSize];
    }
    public void insert(Product p){ //매개변수
    	if(totalCnt >=pArr.length){
    		System.out.println("저장소가 꽉찼습니다. 현재재상품수는:"+totalCnt+"입니다");
    		return;
    	}
     	/**
    	 * 저장소에 상품번호가 이미 존재하면
    	 * "이미 존재하는 상품입니다"출력하고
    	 * 존재하지 않을 경우만 상품을 저장한다.
    	 */
    	for(int i=0; i<totalCnt; i++) { //totalCnt = 저장된 상품수만큼만 반복
    		if(p.getProdNo().equals(pArr[i].getProdNo())){ //매개변수의 상품과 비교
            System.out.println("이미 존재하는 상품입니다");
                return;// 중복이 발견됨
    		}
    	}
				//Product p1 = pArr[i];//저장소의 상품
    			//String p1ProdNo = p1.getProdNo(); //저장소의 상품의 상품번호
    			//String pProdNo = p.getProdNo();//저장하려는 상품의 상품번호
    			//if(pPodNo.equlas(p2ProdNo)){
    			
				
          //pArr[totalCnt] = p; //good code
    	//totalCnt++;

    	pArr[totalCnt++]=p;//bad code //10을 사용하는데, 연신이 마무리지 되지 않아 마무리하고 숫자가 죽는다.
//    	/++는 다른 indext하게 사용하는것이 위험하다 다른 indext값과 사용하뎌라
    	
    }

    public Product selectByProdNo(String no){ //반환형
         //상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다
         //System.out.println("총상품수" + totalCnt);
         for(int i=0; i<totalCnt; i++){
        	 	Product p = pArr[i];
             if(pArr[i].getProdNo().equals(no)){ //==는 기본자료형(숫자, 문자, 논리)값 비교시 사용한다.
                                                      //equlas()는 문자열(string)값 비교시 사용한다. 
           return p;
           }
       }
       return null; //상품을 찾지 못한 경우 null을 반환한다.
    }

    public  Product[] selectAll(){ //반환형
          Product[] all = new Product[totalCnt];
          for(int i=0; i<totalCnt; i++){
           all[i] = pArr[i];
       }
       return all;
    }
    public Product[]selectByProdName(String word){
    	Product[]all;
    	int cnt =0; //단어를 포함한 상품수
    	for(int i=0; i<totalCnt; i++) { 
    		if(pArr[i].getProdName().contains(word)) {
    			cnt++;
    	}
    }
    	all = new Product[cnt];
    	int index= 0;
    	for(int i=0; i<totalCnt; i++) { 
    		Product p = pArr[i];
    		if(p.getProdName().contains(word)){
    			all[index]= p;
    			index++;
    		}
    	}
    	return all;
    	
 }

    //재코드
  
    /*public static void main(String[]args){
        //pArr = new Product[5];

        //pArr[0] = new Product();
        //pArr[0].prodNo = "G0001";

        for(int i=0; i<5; i++){
            pArr[i] = new Product();
            pArr[i].prodNo = "G000"+(i+1);
        }

        for(int i=0; i<5; i++){
            System.out.println(pArr[i].prodNo);
        }

    }
    */
}