package Implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.TeacherController;
import DatabaseUtil.Database;
import VO.Teacher;

public class TeacherImp implements TeacherController {
	Database data = new Database();
	@Override
	public List<Teacher> queryTeacherAll() {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from teacher";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(rs.getInt("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTeacherSex(rs.getString("teacherSex"));
				teacher.setPoliticalStatus(rs.getString("politicalStatus"));
				teacher.setTeacherIDCard(rs.getString("teacherIdCard"));
				teacher.setTeacherAddress(rs.getString("teacherAddress"));
				teacher.setClassName(rs.getString("className"));
				teacher.setSchoolName(rs.getString("schoolName"));
				teacher.setTeacherBirthday(rs.getDate("teacherBirthday"));
				teacher.setTeacherAvatar(rs.getString("teacherAvatar"));
				teacherList.add(teacher);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacherList;
	}

	@Override
	public Teacher queryTeacherById(int teacherId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from teacher where teacherId=?";
		Teacher teacher = new Teacher();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacherId);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				teacher.setTeacherId(rs.getInt("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTeacherSex(rs.getString("teacherSex"));
				teacher.setPoliticalStatus(rs.getString("politicalStatus"));
				teacher.setTeacherIDCard(rs.getString("teacherIdCard"));
				teacher.setTeacherAddress(rs.getString("teacherAddress"));
				teacher.setClassName(rs.getString("className"));
				teacher.setSchoolName(rs.getString("schoolName"));
				teacher.setTeacherBirthday(rs.getDate("teacherBirthday"));
				teacher.setTeacherAvatar(rs.getString("teacherAvatar"));
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacher;
	}

	@Override
	public List<Teacher> queryTeacherByName(String teacherName) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from teacher where teacherName=?";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacherName);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(rs.getInt("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTeacherSex(rs.getString("teacherSex"));
				teacher.setPoliticalStatus(rs.getString("politicalStatus"));
				teacher.setTeacherIDCard(rs.getString("teacherIdCard"));
				teacher.setTeacherAddress(rs.getString("teacherAddress"));
				teacher.setClassName(rs.getString("className"));
				teacher.setSchoolName(rs.getString("schoolName"));
				teacher.setTeacherBirthday(rs.getDate("teacherBirthday"));
				teacher.setTeacherAvatar(rs.getString("teacherAvatar"));
				teacherList.add(teacher);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacherList;
	}
	
	@Override
	public List<Teacher> queryTeacherByClassName(String className) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from teacher where className=?";
		List<Teacher> teacherList = new ArrayList<Teacher>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, className);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Teacher teacher = new Teacher();
				teacher.setTeacherId(rs.getInt("teacherId"));
				teacher.setTeacherName(rs.getString("teacherName"));
				teacher.setTeacherSex(rs.getString("teacherSex"));
				teacher.setPoliticalStatus(rs.getString("politicalStatus"));
				teacher.setTeacherIDCard(rs.getString("teacherIdCard"));
				teacher.setTeacherAddress(rs.getString("teacherAddress"));
				teacher.setClassName(rs.getString("className"));
				teacher.setSchoolName(rs.getString("schoolName"));
				teacher.setTeacherBirthday(rs.getDate("teacherBirthday"));
				teacher.setTeacherAvatar(rs.getString("teacherAvatar"));
				teacherList.add(teacher);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return teacherList;
	}

	@Override
	public int addTeacher(Teacher teacher) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "insert into teacher (teacherId,teacherName,teacherSex,"
				+ "politicalStatus,teacherIdCard,teacherAddress,className,"
				+ "schoolName,teacherBirthday,teacherAvatar) values(?,?,?,?,?,?,?,?,?,?)";
		int result=0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,teacher.getTeacherId());
			pstmt.setString(2, teacher.getTeacherName());
			pstmt.setString(3, teacher.getTeacherSex());
			pstmt.setString(4, teacher.getPoliticalStatus());
			pstmt.setString(5, teacher.getTeacherIDCard());
			pstmt.setString(6, teacher.getTeacherAddress());
			pstmt.setString(7, teacher.getClassName());
			pstmt.setString(8, teacher.getSchoolName());
			pstmt.setDate(9, (Date)teacher.getTeacherBirthday());
			pstmt.setString(10, teacher.getTeacherAvatar());
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int delTeacherById(int teacherId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "delete from teacher where teacherId=?";
		int result =0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, teacherId);
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int updateTeacherById(Teacher teacher) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update teacher set teacherName=?,teacherSex=?,"
				+ "politicalStatus=?,teacherIdCard=?,teacherAddress=?,"
				+ "className=?,schoolName=?,teacherBirthday=?,teacherAvatar=? "
				+ "where teacherId=?";
		int result=0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, teacher.getTeacherName());
			pstmt.setString(2, teacher.getTeacherSex());
			pstmt.setString(3, teacher.getPoliticalStatus());
			pstmt.setString(4, teacher.getTeacherIDCard());
			pstmt.setString(5, teacher.getTeacherAddress());
			pstmt.setString(6, teacher.getClassName());
			pstmt.setString(7, teacher.getSchoolName());
			pstmt.setDate(8, (Date)teacher.getTeacherBirthday());
			pstmt.setString(9, teacher.getTeacherAvatar());
			pstmt.setInt(10, teacher.getTeacherId());
			result = pstmt.executeUpdate();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}


}
