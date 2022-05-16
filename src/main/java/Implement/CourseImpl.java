package Implement;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Controller.CourseController;
import DatabaseUtil.Database;
import VO.Course;

public class CourseImpl implements CourseController {
	Database data = new Database();
	@Override
	public List<Course> queryAll() {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from course";
		List<Course> courseList = new ArrayList<Course>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Course cou = new Course();
				cou.setId(rs.getInt("id"));
				cou.setC_name(rs.getString("c_name"));
				cou.setC_crs(rs.getInt("c_crs"));
				cou.setC_number(rs.getInt("c_number"));
				cou.setC_exam(rs.getString("c_exam"));
				cou.setC_type(rs.getString("c_type"));
				cou.setC_week(rs.getString("c_week"));
				cou.setC_time(rs.getString("c_time"));
				cou.setC_address(rs.getString("c_address"));
				cou.setC_class(rs.getString("c_class"));
				cou.setC_teacher(rs.getString("c_teacher"));
				courseList.add(cou);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> queryByName(String c_name) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from course where c_name=?";
		List<Course> courseList = new ArrayList<Course>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c_name);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Course cou = new Course();
				cou.setId(rs.getInt("id"));
				cou.setC_name(rs.getString("c_name"));
				cou.setC_crs(rs.getInt("c_crs"));
				cou.setC_number(rs.getInt("c_number"));
				cou.setC_exam(rs.getString("c_exam"));
				cou.setC_type(rs.getString("c_type"));
				cou.setC_week(rs.getString("c_week"));
				cou.setC_time(rs.getString("c_time"));
				cou.setC_address(rs.getString("c_address"));
				cou.setC_class(rs.getString("c_class"));
				cou.setC_teacher(rs.getString("c_teacher"));
				courseList.add(cou);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}

	@Override
	public List<Course> queryByTeacherName(String c_teacher) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from course where c_teacher=?";
		List<Course> courseList = new ArrayList<Course>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c_teacher);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Course cou = new Course();
				cou.setId(rs.getInt("id"));
				cou.setC_name(rs.getString("c_name"));
				cou.setC_crs(rs.getInt("c_crs"));
				cou.setC_number(rs.getInt("c_number"));
				cou.setC_exam(rs.getString("c_exam"));
				cou.setC_type(rs.getString("c_type"));
				cou.setC_week(rs.getString("c_week"));
				cou.setC_time(rs.getString("c_time"));
				cou.setC_address(rs.getString("c_address"));
				cou.setC_class(rs.getString("c_class"));
				cou.setC_teacher(rs.getString("c_teacher"));
				courseList.add(cou);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}
	
	@Override
	public List<Course> queryByClass(String c_class) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "select * from course where c_class=?";
		List<Course> courseList = new ArrayList<Course>();
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, c_class);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				Course cou = new Course();
				cou.setId(rs.getInt("id"));
				cou.setC_name(rs.getString("c_name"));
				cou.setC_crs(rs.getInt("c_crs"));
				cou.setC_number(rs.getInt("c_number"));
				cou.setC_exam(rs.getString("c_exam"));
				cou.setC_type(rs.getString("c_type"));
				cou.setC_week(rs.getString("c_week"));
				cou.setC_time(rs.getString("c_time"));
				cou.setC_address(rs.getString("c_address"));
				cou.setC_class(rs.getString("c_class"));
				cou.setC_teacher(rs.getString("c_teacher"));
				courseList.add(cou);
			}
			rs.close();
			pstmt.close();
			data.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return courseList;
	}
	
	@Override
	public int addCourse(Course course) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "insert into course (c_name,c_crs,"
				+ "c_number,c_exam,c_type,c_week,c_time,c_address,"
				+ "c_class,c_teacher) values(?,?,?,?,?,?,?,?,?,?)";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getC_name());
			pstmt.setInt(2, course.getC_crs());
			pstmt.setInt(3, course.getC_number());
			pstmt.setString(4, course.getC_exam());
			pstmt.setString(5, course.getC_type());
			pstmt.setString(6, course.getC_week());
			pstmt.setString(7, course.getC_time());
			pstmt.setString(8, course.getC_address());
			pstmt.setString(9, course.getC_class());
			pstmt.setString(10, course.getC_teacher());
			result=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public int updateCourseById(Course course) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "update course set c_name=?,c_crs,=?"
				+ "c_number=?,c_exam=?,c_type=?,c_week=?,c_time=?,c_address=?,"
				+ "c_class=?,c_teacher=? where id=?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, course.getC_name());
			pstmt.setInt(2, course.getC_crs());
			pstmt.setInt(3, course.getC_number());
			pstmt.setString(4, course.getC_exam());
			pstmt.setString(5, course.getC_type());
			pstmt.setString(6, course.getC_week());
			pstmt.setString(7, course.getC_time());
			pstmt.setString(8, course.getC_address());
			pstmt.setString(9, course.getC_class());
			pstmt.setString(10, course.getC_teacher());
			pstmt.setInt(11, course.getId());
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public int deleteCourseById(int id) {
		// TODO Auto-generated method stub
		Connection conn = data.getConnection();
		String sql = "delete from course where id=?";
		int result = 0;
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}

	

}
