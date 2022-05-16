package VO;

import java.sql.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Student {
	@JSONField(ordinal=1)
	private String StudentId;
	@JSONField(ordinal=2)
	private String StudentName;
	@JSONField(ordinal=3)
	private String StudentSex;
	@JSONField(ordinal=4)
	private String PoliticalStatus;
	@JSONField(ordinal=5)
	private String SchoolName;
	@JSONField(ordinal=6)
	private String ClassName;
	@JSONField(ordinal=7)
	private Date StudentBirthday;
	@JSONField(ordinal=8)
	private String StudentAddress;
	@JSONField(ordinal=9)
	private String StudentAvatar;
	@JSONField(ordinal=10)
	private String StudentIDCard;
	public String getStudentId() {
		return StudentId;
	}
	public void setStudentId(String studentId) {
		StudentId = studentId;
	}
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getStudentSex() {
		return StudentSex;
	}
	public void setStudentSex(String studentSex) {
		StudentSex = studentSex;
	}
	public String getPoliticalStatus() {
		return PoliticalStatus;
	}
	public void setPoliticalStatus(String politicalStatus) {
		PoliticalStatus = politicalStatus;
	}
	public String getSchoolName() {
		return SchoolName;
	}
	public void setSchoolName(String schoolName) {
		SchoolName = schoolName;
	}
	public String getClassName() {
		return ClassName;
	}
	public void setClassName(String className) {
		ClassName = className;
	}
	public Date getStudentBirthday() {
		return StudentBirthday;
	}
	public void setStudentBirthday(Date studentBirthday) {
		StudentBirthday = studentBirthday;
	}
	public String getStudentAddress() {
		return StudentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		StudentAddress = studentAddress;
	}
	public String getStudentAvatar() {
		return StudentAvatar;
	}
	public void setStudentAvatar(String studentAvatar) {
		StudentAvatar = studentAvatar;
	}
	public String getStudentIDCard() {
		return StudentIDCard;
	}
	public void setStudentIDCard(String studentIDCard) {
		StudentIDCard = studentIDCard;
	}
	
}
