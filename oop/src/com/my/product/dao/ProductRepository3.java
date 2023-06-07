package com.my.product.dao;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.exception.RemoveException;
import com.my.product.dto.Product;

public class ProductRepository3{
	//private Product[] pArr; //참조형 product 배열타입, 자동초기화
	//private int totalCnt = 0; //저장소에 저장된 상품수, 자동초기화(0값이 없어도 자동초기화: 0)
	private List<Product> pList;
	public ProductRepository3() {
		pList = new ArrayList<>();}

	/**
	 * 상품을 저장소에 추가한다.
	 * @param p 저장할 상품
	 * @throws AddException 상품번호가 존재할 경우 "이미 존재하는 상품입니다"메시지를 갖는 예외가 발생한다
	 *
	 */
	public void insert(Product p)throws AddException{ //매개변수

		for(int i=0; i<pList.size(); i++) { 
			Product p1 = pList.get(i);//저장소의 상품
			String p1ProdNo = p1.getProdNo(); //저장소의 상품의 상품번호
			String pProdNo = p.getProdNo();//저장하려는 상품의 상품번호
			if(p1ProdNo.equals(pProdNo)){
				throw new AddException("이미 존재하는 상품입니다");
			}
		}
		pList.add(p);
	}

	//	public List<Product> insert(Product p) throws AddException{ //매개변수
	//		List<Product> all = new ArrayList<>();
	//		for(Product o : pList) {
	//			all.add(o);
	//	}
	//		return all;
	//
	//}
	/**
	 * 상품번호에 해당하는 상품을 저장소에서 찾아 반환한다.
	 * @param no 상품번호
	 * @return 상품
	 * @throws com.my.exception.FindException 
	 * 번호에 해당상품이 없으면 "상품이 없습니다"메세지를 갖는 예외가 발생한다. 
	 */
	public Product selectByProdNo(String no)throws FindException{ //반환형
		//상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다

		for(int i=0; i<pList.size(); i++){
			Product p = pList.get(i);
			if(p.getProdNo().equals(no)){//==는 기본자료형(숫자, 문자, 논리)값 비교시 사용한다.
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
	public  List<Product> selectAll()throws FindException{ 
		List<Product> all = new ArrayList<Product>();
		for(int i=0; i<pList.size(); i++){
			all.add(pList.get(i)); //
		}
		return all;

	}
	/**
	 * 단어를 포함한 이름을 갖는 상품들을 반환한다.
	 * @param word 단어
	 * @return 상품들
	 * @throws FindException
	 */
	public List<Product>selectByProdName(String word)throws FindException{
		List<Product> all = new ArrayList<Product>();
		int cnt =0; //단어를 포함한 상품수
		for(int i=0; i<pList.size(); i++) { 
			Product product = pList.get(i);
			if(product.getProdName().contains(word)) {
				cnt++;
			}
		}
		//		all = new Product[cnt];
		int index= 0;
		for(int i=0; i<pList.size(); i++) { 
			Product p = pList.get(i);
			if(p.getProdName().contains(word)){
				//				all[index]= p;
				index++;
			}
		}
		return all;
	}
}