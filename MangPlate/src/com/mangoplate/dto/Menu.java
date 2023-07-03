package com.mangoplate.dto;
import com.mangoplate.user.MenuUser;

public class Menu {
	private int Menuno; //메뉴번호
	private String Businessno; //사업자 번호
	private String Menuname; //메뉴 이름 
	private int Menuprice; //메뉴 가격 
	private String Menudetail; //메뉴정보
	private int Categoryno;	//카테고리 번호
	private String Businessname; //음식점 이름
	private String Id; //아이디	
	//필드
	public Menu(){}
	//생성자
	public Menu (int Menuno, String Businessno, String Menuname, int Menuprice, String Menudetail, int Categoryno,
			String Businessname, String Id
			){
		this.Menuno = Menuno;
		this.Businessno = Businessno;		
		this.Menuname = Menuname;
		this.Menuprice = Menuprice;
		this.Menudetail = Menudetail;
		this.Categoryno = Categoryno;
		this.Businessname = Businessname;
		this.Id = Id;		
	}
	public int getMenuno() {
		return Menuno;
	}
	public void setMenuno(int menuno) {
		this.Menuno = menuno;
	}
	public String getBusinessno() {
		return Businessno;
	}
	public void setBusinessno(String businessno) {
		Businessno = businessno;
	}
	public String getMenuname() {
		return Menuname;
	}
	public void setMenuname(String menuname) {
		Menuname = menuname;
	}
	public int getMenuprice() {
		return Menuprice;
	}
	public void setMenuprice(int menuprice) {
		Menuprice = menuprice;
	}
	public String getMenudetail() {
		return Menudetail;
	}		
	public void setMenudetail(String menudetail) {
		Menudetail = menudetail;
	}
	public int getCategoryno() {
		return Categoryno;
	}		
	public void setCategoryno(int categoryno) {
		Categoryno = categoryno;
	}
	public String getBusinessname() {
		return Businessname;
	}
	public void setBusinessname(String businessname) {
		Businessname = businessname;
	}
	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
}
