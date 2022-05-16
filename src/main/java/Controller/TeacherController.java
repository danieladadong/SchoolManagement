package Controller;

import java.util.List;

import VO.Teacher;

public interface TeacherController {
	public abstract List<Teacher> queryTeacherAll();
	public abstract Teacher queryTeacherById(int teacherId);
	public abstract List<Teacher> queryTeacherByName(String teacherName);
	public abstract List<Teacher> queryTeacherByClassName(String className);
	public abstract int addTeacher(Teacher teacher);
	public abstract int delTeacherById(int teacherId);
	public abstract int updateTeacherById(Teacher teacher);
}
