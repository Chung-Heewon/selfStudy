package com.mangoplate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mangoplate.dto.Login;

import my.com.mango.sql.MangoPlateConnection;

public class LoginRepository {
	public  boolean login(String id, String pwd) {
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
		String sql = "select * from member where id='"+id+"' and pwd ='"+pwd+"'";	
		try {

			try {
				conn = MangoPlateConnection.getConnection();
			} catch (ClassNotFoundException |SQLException e) {
				e.printStackTrace();
			}
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();


			if(rs.next()) {
				Login.setCurrentId(id);
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("1번예외");
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("2번예외");
				e.printStackTrace();
			}
		}
		return false;					
	}
}
