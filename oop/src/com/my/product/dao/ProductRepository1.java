package com.my.product.dao;

import com.my.product.dto.Product;

public class ProductRepository1 {
   // private Product[] pArr = new Product[5];
   private Product[] pArr;
   private int totalCnt = 0; // totalCnt 상품저장수

   public ProductRepository1() {
      pArr = new Product[5];
   }

   public ProductRepository1(int maxSize) {
      if (maxSize <= 0) {
         maxSize = 5;
      }
      pArr = new Product[maxSize];
   }

   public void insert(Product p) {

//      if (totalCnt >= pArr.length) {
//         System.out.println("저장소가 꽉찼습니다. 현재상품수는 " + totalCnt + "입니다.");
//         return; // 메서드를 종료하는 것이지 프로그램을 끝내는 건 아님
//      }

      /*
       * 저장소에 상품번호가 이미존재하면 "이미 존재하는 상품입니다" 출력하고 존재하지 않을경우만 상품을 저장한다
       */
      for (int i = 0; i < totalCnt; i++) { // totalCnt - 실제저장된 상품수
         Product p1 = pArr[i]; // 저장소의 상품의 상품번호
         String p1ProdNo = p1.getProdNo(); // 저장소의 상품의 상품번호
         String pProdNo = p.getProdNo();
         if (pProdNo.equals(p1ProdNo)) {
            // if (pArr[i].getProdNo().equals(p.getProdNo())) { // 위에 3줄과 같은코드임
            System.out.println("이미 존재하는 상품입니다.");
            return;
         }
      }
      pArr[totalCnt] = p; // 함수 호출된 거 아님, 함수가 호출이 되면 어떤 일을 해야할 지를 정해두는 과정
      totalCnt++; // totalCnt 상품저장수 하나 증가
      // 2줄 코드를 한 줄 코드로 바꾸기 pArr[totalCnt++]=p;
      // 안좋은 이유? totalcnt의 값이 11되고 종료됨. 2줄코드는 +1안되고 10에서 그전에 윗줄 소스가 오류나서 죽음
      // ++ -- 는 혼자써야함

   }

   public Product selectByProdNo(String no) { // 이 메서드에 목적은 상품번호를 이용해서 상품 조회하는 것
      // 상품번호에 해당하는 상품을 저장소에서 찾아 상품을 반환한다.
      for (int i = 0; i < totalCnt; i++) {
         Product p = pArr[i];
         if (p.getProdNo().equals(no)) { // ==는 기본자료형(숫자, 문자(문자열과는 다름), 논리)값 비교시 사용한다
            // equals()는 문자열(String)값 비교시 사용한다
            return p;
         }
      }
      return null; // 상품이 없는 경우 null을 반환한다
   }
   // 메인메서드는 static을 붙여야 되지만, 나머지 메서드는 붙여도되고, 안붙여도 됨.
   // 메서드 이름 - 동사 , 변수 - 명사 (통용)

   public Product[] selectAll() { // 상품 전체를 검색하는 함수 selectAll
      Product[] all = new Product[totalCnt];
      for (int i = 0; i < totalCnt; i++) {
         all[i] = pArr[i];
      }
      return all;

   }

   public Product[] selectByProdName(String word) {
      Product[] all;
      int cnt = 0; // 단어를 포함한 상품
      for (int i = 0; i < totalCnt; i++) {
         if (pArr[i].getProdName().contains(word)) {
            cnt++;
         }
      }
      all = new Product[cnt];
      int index = 0;
      for (int i = 0; i < totalCnt; i++) {
         Product p = pArr[i];
         if (pArr[i].getProdName().contains(word)) {
            all[index] = p;
            index++;
         }
      }
      return all;
   }

}