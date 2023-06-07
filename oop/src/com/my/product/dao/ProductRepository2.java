package com.my.product.dao;
import com.my.exception.FindException;

import com.my.exception.AddException;
import com.my.exception.RemoveException;
import com.my.product.dto.Product;

public class ProductRepository2{
	private Product[] pArr; //참조형 product 배열타입, 자동초기화
	private int totalCnt = 0; //저장소에 저장된 상품수, 자동초기화(0값이 없어도 자동초기화: 0)

	/**
	 * 최대 5개의 상품이 저장될 수 있는 저장소를 만든다
	 */
	public ProductRepository2() {
		pArr = new Product[5];
	}
	/**
	 * 저장소를 만든다.
	 * @param maxsize 최대 상품수
	 * 
	 */
	public ProductRepository2(int maxSize) {
		if(maxSize <=0) {
			maxSize =5;
		}
		pArr = new Product[maxSize];
	}
	/**
	 * 상품을 저장소에 추가한다.
	 * @param p 저장할 상품
	 * @throws AddException 상품번호가 존재할 경우 "이미 존재하는 상품입니다"메시지를 갖는 예외가 발생한다
	 * 저장소가 꽉찼을 경우 "저장소가 꽉찼습니다. 현재상품수는 " 메시지를 갖는다. 
	 */
	public void insert(Product p)throws AddException{ //매개변수
		for(int i=0; i<totalCnt; i++) { //totalCnt = 저장된 상품수만큼만 반복
			Product p1 = pArr[i];//저장소의 상품
			String p1ProdNo = p1.getProdNo(); //저장소의 상품의 상품번호
			String pProdNo = p.getProdNo();//저장하려는 상품의 상품번호
			if(p1ProdNo.equals(pProdNo)){
				throw new AddException("이미 존재하는 상품입니다");
//				return;
			}
		}

		try {
			pArr[totalCnt] = p; //good code
			totalCnt++;
		}catch(ArrayIndexOutOfBoundsException e) {

			throw new AddException("저장소가 꽉 찼습니다. 현재상품수는"+totalCnt);
		
		}
	}
/**
 * 상품번호에 해당하는 상품을 저장소에서 찾아 반환한다.
 * @param no 상품번호
 * @return 상품
 * @throws com.my.exception.FindException 
 * 번호에 해당상품이 없으면 "상품이 없습니다"메세지를 갖는 예외가 발생한다. 
 */
	public Product selectByProdNo(String no)throws FindException{ //반환형
		//상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다
		for(int i=0; i<totalCnt; i++){
			Product p = pArr[i];
			if(pArr[i].getProdNo().equals(no)){//==는 기본자료형(숫자, 문자, 논리)값 비교시 사용한다.
				//equals()는 문자열(string)값 비교시 사용한다. 
				return p;

			}
		}
//		return null; //상품을 찾지 못한 경우 null을 반환한다.
		throw new FindException("상품이 없습니다.");
	}
	/**
	 * 모든 상품을 검색한다.
	 * @return 상품들
	 * @throws FindExcepetion
	 */
	public  Product[] selectAll()throws FindException{ //반환형
		Product[] all = new Product[totalCnt];
		for(int i=0; i<totalCnt; i++){
			all[i] = pArr[i];
		}
		return all;

	}
	/**
	 * 단어를 포함한 이름을 갖는 상품들을 반환한다.
	 * @param word 단어
	 * @return 상품들
	 * @throws FindException
	 */
	public Product[]selectByProdName(String word)throws FindException{
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
	/**
	 * 상품을 삭제한다.
	 * @param prodNo 상품번호
	 * @throws com.my.exception.RemoveException 상품번호에 해당 상품이 없을 경우
	 */
	public void delete(String prodNo) throws RemoveException {
		int indexOfProdNo =0;
		for(int i=0; i<totalCnt; i++) {
			if(prodNo.equals(pArr[i].getProdNo())) {
				indexOfProdNo = i;
				break;
				
			}
		}
		if(indexOfProdNo ==0) {
			throw new RemoveException("상품이 없습니다.");
		}
	}
}