package com.my.util;

import java.util.List;

import com.my.product.dto.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class PageBean<T> {
	private int CntPerPage; //페이지별 보여줄 최대목록수
	private int totalCnt;//총건수
	private List<T> list; //현재페이지의 목록
	private int cntPerPageGroup;//페이지별 보여줄 페이지그룹수
	private int currentPage; //현재페이지
	private int totalPage; //총페이지수
	private int startPage; //시작페이지
	private int endPage; //끝페이지
	public PageBean(int cntPerPage, int totalCnt, List<T> list, int cntPerPageGroup, int currentPage) {
		super();
		CntPerPage = cntPerPage;
		this.totalCnt = totalCnt;
		this.list = list;
		this.cntPerPageGroup = cntPerPageGroup;
		this.currentPage = currentPage;
		totalPage = (int)Math.ceil((double)totalCnt/cntPerPage);
		startPage = (currentPage-1)/cntPerPageGroup*cntPerPageGroup+1;
		endPage = startPage + cntPerPageGroup -1;
		if(totalPage<endPage){
			endPage = totalPage;
		}
	}


}
