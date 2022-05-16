package VO;

import com.alibaba.fastjson.annotation.JSONField;

public class Course {
	@JSONField(ordinal=1)
	private int id;
	@JSONField(ordinal=2)
	private String c_name;
	@JSONField(ordinal=3)
	private int c_crs;
	@JSONField(ordinal=4)
	private int c_number;
	@JSONField(ordinal=5)
	private String c_exam;
	@JSONField(ordinal=6)
	private String c_type;
	@JSONField(ordinal=7)
	private String c_week;
	@JSONField(ordinal=8)
	private String c_time;
	@JSONField(ordinal=9)
	private String c_address;
	@JSONField(ordinal=10)
	private String c_class;
	@JSONField(ordinal=11)
	private String c_teacher;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public int getC_crs() {
		return c_crs;
	}
	public void setC_crs(int c_crs) {
		this.c_crs = c_crs;
	}
	public int getC_number() {
		return c_number;
	}
	public void setC_number(int c_number) {
		this.c_number = c_number;
	}
	public String getC_exam() {
		return c_exam;
	}
	public void setC_exam(String c_exam) {
		this.c_exam = c_exam;
	}
	public String getC_type() {
		return c_type;
	}
	public void setC_type(String c_type) {
		this.c_type = c_type;
	}
	public String getC_week() {
		return c_week;
	}
	public void setC_week(String c_week) {
		this.c_week = c_week;
	}
	public String getC_time() {
		return c_time;
	}
	public void setC_time(String c_time) {
		this.c_time = c_time;
	}
	public String getC_address() {
		return c_address;
	}
	public void setC_address(String c_address) {
		this.c_address = c_address;
	}
	public String getC_class() {
		return c_class;
	}
	public void setC_class(String c_class) {
		this.c_class = c_class;
	}
	public String getC_teacher() {
		return c_teacher;
	}
	public void setC_teacher(String c_teacher) {
		this.c_teacher = c_teacher;
	}

	

}
