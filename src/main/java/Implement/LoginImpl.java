package Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.mysql.cj.xdevapi.Result;

import Controller.LoginController;
import DatabaseUtil.Database;

public class LoginImpl implements LoginController {
	Database data = new Database();
	Map<String,String> resultMap = new HashMap<String,String>();
	@Override
	public Map<String,String> loginAsStudent(String account, String password) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		resultMap.clear();
		String sql = "select account,name from s_account where account=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				resultMap.put("account", rs.getString("account"));
				resultMap.put("name", rs.getString("name"));
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	@Override
	public Map<String,String> loginAsTeacher(String account, String password) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		resultMap.clear();
		String sql = "select account,name from t_account where account=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				resultMap.put("account", rs.getString("account"));
				resultMap.put("name", rs.getString("name"));
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}
	@Override
	public Map<String,String> loginAsAdmin(String account, String password) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		resultMap.clear();
		String sql = "select account,name from a_account where account=? and password=?";
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, account);
			pstmt.setString(2, password);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				resultMap.put("account", rs.getString("account"));
				resultMap.put("name", rs.getString("name"));
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return resultMap;
	}

}
