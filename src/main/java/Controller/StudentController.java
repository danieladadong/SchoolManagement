package Controller;

import java.util.List;

import VO.Student;

public interface StudentController {
	public abstract List<Student> queryStudentAll();
	public abstract Student queryStudentById(String studentId);
	public abstract List<Student> queryStudentByName(String studentName);
	public abstract int addStudent(Student student);
	public abstract int delStudentById(String studentId);
	public abstract int updateStudentById(Student student);

}
