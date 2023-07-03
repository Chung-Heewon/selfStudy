package com.mangoplate.dto;

public class Login {

		private String id; // 사용자 id
		private String pwd; // 사용자 비밀번호
		private static String currentId;
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getPwd() {
			return pwd;
		}
		public void setPwd(String pwd) {
			this.pwd = pwd;
		}
		public static String getCurrentId() {
			return currentId;
		}
		public static void setCurrentId(String id) {
			currentId = id;
		}
		
		
}
