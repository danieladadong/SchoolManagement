package Implement;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.StudentController;
import DatabaseUtil.Database;
import VO.Student;

public class StudentImp implements StudentController {
	Database data = new Database();
	@SuppressWarnings("null")
	@Override
	public List<Student> queryStudentAll() {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from student";
		List<Student> studentList = new ArrayList<Student>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery(sql);
			while(rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getString("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentSex(rs.getString("studentSex"));
				student.setPoliticalStatus(rs.getString("politicalStatus"));
				student.setStudentIDCard(rs.getString("studentIdCard"));
				student.setStudentAddress(rs.getString("studentAddress"));
				student.setClassName(rs.getString("className"));
				student.setSchoolName(rs.getString("schoolName"));
				student.setStudentBirthday(rs.getDate("studentBirthday"));
				student.setStudentAvatar(rs.getString("studentAvatar"));
				studentList.add(student);
			}
			rs.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public Student queryStudentById(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from student where studentId=?";
		Student student = new Student();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, studentId);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				student.setStudentId(rs.getString("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentSex(rs.getString("studentSex"));
				student.setPoliticalStatus(rs.getString("politicalStatus"));
				student.setStudentIDCard(rs.getString("studentIdCard"));
				student.setStudentAddress(rs.getString("studentAddress"));
				student.setClassName(rs.getString("className"));
				student.setSchoolName(rs.getString("schoolName"));
				student.setStudentBirthday(rs.getDate("studentBirthday"));
				student.setStudentAvatar(rs.getString("studentAvatar"));
			}
			rs.close();
			pstm.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return student;
	}

	@SuppressWarnings("null")
	@Override
	public List<Student> queryStudentByName(String studentName) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from student where studentName=?";
		List<Student> studentList = new ArrayList<Student>();
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, studentName);
			ResultSet rs = pstm.executeQuery();
			while(rs.next()) {
				Student student = new Student();
				student.setStudentId(rs.getString("studentId"));
				student.setStudentName(rs.getString("studentName"));
				student.setStudentSex(rs.getString("studentSex"));
				student.setPoliticalStatus(rs.getString("politicalStatus"));
				student.setStudentIDCard(rs.getString("studentIdCard"));
				student.setStudentAddress(rs.getString("studentAddress"));
				student.setClassName(rs.getString("className"));
				student.setSchoolName(rs.getString("schoolName"));
				student.setStudentBirthday(rs.getDate("studentBirthday"));
				student.setStudentAvatar(rs.getString("studentAvatar"));
				studentList.add(student);
			}
			rs.close();
			pstm.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return studentList;
	}

	@Override
	public int addStudent(Student student) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "insert into student (studentId,studentName,studentSex,politicalStatus,"
				+ "studentIdcard,studentAddress,className,schoolName,studentBirthday,studentAvatar)"
				+ " values(?,?,?,?,?,?,?,?,?,?)";
		int result=0;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, student.getStudentId());
			pstm.setString(2, student.getStudentName());
			pstm.setString(3, student.getStudentSex());
			pstm.setString(4, student.getPoliticalStatus());
			pstm.setString(5, student.getStudentIDCard());
			pstm.setString(6, student.getStudentAddress());
			pstm.setString(7, student.getClassName());
			pstm.setString(8, student.getSchoolName());
			pstm.setDate(9, student.getStudentBirthday());
			pstm.setString(10, student.getStudentAvatar());
			result = pstm.executeUpdate();
			pstm.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int delStudentById(String studentId) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "delete from student where studentId=?";
		int result = 0;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, studentId);
			result = pstm.executeUpdate();
			pstm.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateStudentById(Student student) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update student set studentName=?,studentSex=?,politicalStatus=?,"
				+ "studentIdCard=?,studentAddress=?,className=?,schoolName=?,studentBirthday=? where studentId=?";
		int result = 0;
		try {
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, student.getStudentName());
			pstm.setString(2, student.getStudentSex());
			pstm.setString(3, student.getPoliticalStatus());
			pstm.setString(4, student.getStudentIDCard());
			pstm.setString(5, student.getStudentAddress());
			pstm.setString(6, student.getClassName());
			pstm.setString(7, student.getSchoolName());
			pstm.setDate(8,student.getStudentBirthday());
			pstm.setString(9, student.getStudentId());
			result = pstm.executeUpdate();
			pstm.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
