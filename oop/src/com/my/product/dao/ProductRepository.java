package com.my.product.dao;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.product.dto.Product;

public class ProductRepository{
	private String fileName;
	private Product p;
	public ProductRepository() {
		fileName = "..\\product.dat";
	}

	/**
	 * 상품을 저장소에 추가한다.
	 * @param p 저장할 상품
	 * @throws AddException 상품번호가 존재할 경우 "이미 존재하는 상품입니다"메시지를 갖는 예외가 발생한다
	 *
	 */
	public void insert(Product p)throws AddException{
		/**
		 * 상품중복확인
		 * products.dat파일을 자료형별로 읽기
		 * 자원 : products.dat파일
		 * 노드스트링 : FileInputStream
		 * 필터스트림 : DataInputStream 
		 */
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			String prodNo = dis.readUTF();
			String prodName = dis.readUTF();
			int prodPrice = dis.readInt();
			if(prodNo.equals(p.getProdNo())) {
				throw new AddException("이미 존재하는 상품입니다.");
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dis!=null) {
				try {
					dis.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		/**
		 * products.dat파일에 상품정보(상품번호, 상품명, 가격)을 자료형별로 쓰기
		 * 목적지 : product.dat파일
		 * 노드스트림 : FileOutputStream
		 * 필터스트림 : DataOutputStream
		 */
		DataOutputStream dos = null;
		try {
			dos = new DataOutputStream(new FileOutputStream(fileName,true));
			dos.writeUTF(p.getProdNo());
			dos.writeUTF(p.getProdNo());
			dos.writeInt(p.getProdPrice());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(dos !=null) {
				try {
					dos.close();
				} catch(IOException e) {
					e.printStackTrace();
				}
			}
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


		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			String prodNo = dis.readUTF();

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dis!=null) {
				try {
					dis.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return new Product(no, no, 0);
	}

	public List<Product> selectAll() throws FindException{
		List<Product> all = new ArrayList<Product>();
		DataInputStream dis = null;
		try {
			dis = new DataInputStream(new FileInputStream(fileName));
			String prodNo = dis.readUTF();
			String prodName = dis.readUTF();
			int prodPrice = dis.readInt();

		} catch (FileNotFoundException e) {
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(dis!=null) {
				try {
					dis.close();
				}catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return all;
}


	//		return null; //상품을 찾지 못한 경우 null을 반환한다.
	/**
	 * 모든 상품을 검색한다.
	 * @return 상품들
	 * @throws FindExcepetion
	 */

/**
 * 단어를 포함한 이름을 갖는 상품들을 반환한다.
 * @param word 단어
 * @return 상품들
 * @throws FindException
 */
public List<Product>selectByProdName(String word)throws FindException{
	List<Product> all = new ArrayList<Product>();
	DataInputStream dis = null;
	try {
		dis = new DataInputStream(new FileInputStream(fileName));
		String prodName = dis.readUTF();

	} catch (FileNotFoundException e) {
	} catch (IOException e) {
		e.printStackTrace();
	} finally {
		if(dis!=null) {
			try {
				dis.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	return all;
}
}
