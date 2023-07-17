package com.my.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.sql.MyConnection;

public class CustomerRepository {
	public void insert(Customer c) throws AddException{
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
		
		String selectSQL = "INSERT INTO customer VALUES(?,?,?)";
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, c.getId());
			pstmt.setString(2, c.getPwd());
			pstmt.setString(3, c.getName());
			int i = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new AddException(e.getMessage());
		}
	}
	public Customer selectById(String id) 
			throws FindException {
		Connection conn = null;
		try {
			conn = MyConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
		String selectSQL = "SELECT *\r\n"
				+ "FROM customer\r\n"
				+ "WHERE id =?\r\n";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setString(1, id);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return new Customer( 
						rs.getString("id"),
						rs.getString("pwd"),
						rs.getString("name")
						);
			}else {
				throw new FindException("고객이 없습니다.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}
	}
}

