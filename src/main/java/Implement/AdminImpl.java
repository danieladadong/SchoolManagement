package Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.AdminController;
import DatabaseUtil.Database;
import VO.Classes;
import VO.Requests;

public class AdminImpl implements AdminController {
	Database data = new Database();
	@Override
	public List<Requests> queryRequests() {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from requests";
		List<Requests> reqList = new ArrayList<Requests>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Requests req = new Requests();
				req.setId(rs.getInt("id"));
				req.setAccount(rs.getString("account"));
				req.setUrl(rs.getString("url"));
				req.setTime(rs.getString("time"));
				reqList.add(req);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reqList;
	}

	public List<Requests> queryByAccount(String account) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from requests where account=?";
		List<Requests> reqList = new ArrayList<Requests>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Requests req = new Requests();
				req.setId(rs.getInt("id"));
				req.setAccount(rs.getString("account"));
				req.setUrl(rs.getString("url"));
				req.setTime(rs.getString("time"));
				reqList.add(req);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return reqList;
	}

	public int addRequests(Requests requests) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "insert into requests (account,url,time) values(?,?,?)";
		int result=0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, requests.getAccount());
			pstmt.setString(2, requests.getUrl());
			pstmt.setString(3, requests.getTime());
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	public int delRequests() {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "delete from requests";
		int result=0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	public List<Classes> queryClasses(){
		Connection conn = data.getConnection();
		String sql = "select className from classes";
		List<Classes> classList = new ArrayList<Classes>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Classes cla = new Classes();
				cla.setClasssName(rs.getString("className"));
				classList.add(cla);
			}
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return classList;
	}

}
