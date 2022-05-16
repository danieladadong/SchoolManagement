package Controller;

import java.util.List;

import VO.Course;

public interface CourseController {
	public abstract List<Course> queryAll();
	public abstract List<Course> queryByName(String c_name);
	public abstract List<Course> queryByTeacherName(String c_teacher);
	public abstract List<Course> queryByClass(String c_class);
	public abstract int addCourse(Course course);
	public abstract int updateCourseById(Course course);
	public abstract int deleteCourseById(int id);
}
