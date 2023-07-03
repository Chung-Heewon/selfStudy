package com.mangoplate.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mangoplate.dto.FoodStore;
import com.mangoplate.exception.AddException;

import my.com.mango.sql.MangoPlateConnection;

public class FoodStoreRepository {

	PreparedStatement pstmt;

	// 음식점정보 추가
	public void insert(FoodStore store) throws AddException {

		Connection conn = null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}

		String insertSQL = "INSERT INTO foodstore(businessno,FoodStoreName,Addresses,Detail,Categoryno)"
				+ " VALUES(?,?,?,?,?)";
		PreparedStatement pstmt = null;

		try {

			pstmt = conn.prepareStatement(insertSQL);
			pstmt.setString(1, store.getBusinessno());
			pstmt.setString(2, store.getfoodStoreName());
			pstmt.setString(3, store.getAddresses());
			pstmt.setString(4, store.getDetail());
			pstmt.setInt(5, store.getCategoryno());

			int rowcnt = pstmt.executeUpdate();
			if (rowcnt == 0) {
				System.out.println("추가할 상품이 없습니다");
			} else {
				System.out.println(rowcnt + "건의 상품이 추가되었습니다. ");
			}
		} catch (SQLException e) {

			throw new AddException(e.getMessage());
		} finally {
			MangoPlateConnection.close(null, pstmt, conn);
		}
	}

	// 음식점정보 수정
	public void update(FoodStore store, String bNum) throws AddException {
		Connection conn = null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		String updateSQL = "UPDATE foodstore SET FoodStoreName=?, Addresses=?, Categoryno=?,Detail=? where BUSINESSNO ="
				+ bNum;
		FoodStore foodStore = new FoodStore();

		if (loginBN(bNum) == true) {

			try {
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, store.getfoodStoreName());
				pstmt.setString(2, store.getAddresses());
				pstmt.setInt(3, store.getCategoryno());
				pstmt.setString(4, store.getDetail());

				int rowcnt = pstmt.executeUpdate();
				if (rowcnt == 0) {
					System.out.println("수정할 상품이 없습니다");
				} else {
					System.out.println(rowcnt + "건의 상품이 수정되었습니다. ");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				MangoPlateConnection.close(rs, pstmt, conn);
			}
		} else {
			System.out.println("존재하지 않는 사업자 번호입니다.");
		}
	}

	// 음식점 삭제하기
	public void delete(String businessno) throws AddException {
		Connection conn = null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return;
		}

		String deleteSQL = "DELETE FROM foodstore WHERE businessno = " + businessno;

		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement(deleteSQL);
			// pstmt.setString(1, businessno);

			int rowcnt = pstmt.executeUpdate();
			if (rowcnt == 0) {
				System.out.println("삭제할 음식점이 없습니다.");
			} else {
				System.out.println(rowcnt + "음식점이 삭제되었습니다.");
			}
		} catch (SQLException e) {
//	        e.printStackTrace();
			throw new AddException(e.getMessage());
		} finally {
			MangoPlateConnection.close(null, pstmt, conn);
		}
	}

	public boolean loginBN(String BN) {

		Connection conn = null;
		try {
			conn = MangoPlateConnection.getConnection();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}

		ResultSet rs = null;
		PreparedStatement pstmt = null;

		String sql = "select BUSINESSNO from FOODSTORE where BUSINESSNO =" + BN;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return true;
			}
			return false;
		} catch (SQLException e) {
			System.out.println("1번예외");
			e.printStackTrace();
		} finally {

			try {
				conn.close();
			} catch (SQLException e) {
				System.out.println("2번예외");
				e.printStackTrace();
			}

		}

		return false;
	}

	public static Connection getConnection() {

		return null;
	}

}