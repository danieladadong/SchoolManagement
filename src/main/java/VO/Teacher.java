package VO;

import java.util.Date;

import com.alibaba.fastjson.annotation.JSONField;

public class Teacher {
	@JSONField(ordinal=1)
	private int TeacherId;
	@JSONField(ordinal=2)
	private String TeacherName;
	@JSONField(ordinal=3)
	private String TeacherSex;
	@JSONField(ordinal=4)
	private String PoliticalStatus;
	@JSONField(ordinal=5)
	private String SchoolName;
	@JSONField(ordinal=6)
	private String ClassName;
	@JSONField(ordinal=7)
	private Date TeacherBirthday;
	@JSONField(ordinal=8)
	private String TeacherAddress;
	@JSONField(ordinal=9)
	private String TeacherAvatar;
	@JSONField(ordinal=10)
	private String TeacherIDCard;
	public int getTeacherId() {
		return TeacherId;
	}
	public void setTeacherId(int teacherId) {
		TeacherId = teacherId;
	}
	public String getTeacherName() {
		return TeacherName;
	}
	public void setTeacherName(String teacherName) {
		TeacherName = teacherName;
	}
	public String getTeacherSex() {
		return TeacherSex;
	}
	public void setTeacherSex(String teacherSex) {
		TeacherSex = teacherSex;
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
	public Date getTeacherBirthday() {
		return TeacherBirthday;
	}
	public void setTeacherBirthday(Date teacherBirthday) {
		TeacherBirthday = teacherBirthday;
	}
	public String getTeacherAddress() {
		return TeacherAddress;
	}
	public void setTeacherAddress(String teacherAddress) {
		TeacherAddress = teacherAddress;
	}
	public String getTeacherAvatar() {
		return TeacherAvatar;
	}
	public void setTeacherAvatar(String teacherAvatar) {
		TeacherAvatar = teacherAvatar;
	}
	public String getTeacherIDCard() {
		return TeacherIDCard;
	}
	public void setTeacherIDCard(String teacherIDCard) {
		TeacherIDCard = teacherIDCard;
	}
	
}
