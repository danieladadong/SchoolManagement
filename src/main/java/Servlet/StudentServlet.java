package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.tomcat.jni.Time;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;

import Implement.AdminImpl;
import Implement.StudentImp;
import VO.Requests;
import VO.Student;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminImpl admin = new AdminImpl();
    /**
     * Default constructor. 
     */
    public StudentServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json;charset=UTF-8");
		String action = request.getParameter("action");
		StudentImp simp = new StudentImp();
		Requests req = new Requests();
		String account = request.getParameter("studentId");
		if(account==null||account=="") {
			HttpSession session = request.getSession();
			Map<String,String> map=(Map<String, String>) session.getAttribute("login_Tag");
			account=map.get("account");
		}
		req.setAccount(account);
		req.setUrl(request.getRequestURI()+action);
		req.setTime(new Date().toString());
		admin.addRequests(req);
		if("delete".equals(action)) {
			int tmp = simp.delStudentById(request.getParameter("studentId"));
			if(tmp>0) {
				PrintWriter out = response.getWriter();
				out.println("删除成功！");
				out.flush();
				out.close();
			}else {
				PrintWriter out = response.getWriter();
				out.println("删除失败！");
				out.flush();
				out.close();
			}
		}else if("queryAll".equals(action)) {
			String json = JSON.toJSONString(simp.queryStudentAll());
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryById".equals(action)) {
			String json = JSON.toJSONString(simp.queryStudentById(request.getParameter("studentId")));
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryByName".equals(action)) {
			String json = JSON.toJSONString(simp.queryStudentByName(request.getParameter("studentName")));
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		Student stu = new Student();
		stu.setStudentId(request.getParameter("studentId"));
		stu.setStudentName(request.getParameter("studentName"));
		stu.setStudentSex(request.getParameter("studentSex"));
		stu.setPoliticalStatus(request.getParameter("politicalStatus"));
		stu.setStudentIDCard(request.getParameter("studentIdCard"));
		stu.setStudentAddress(request.getParameter("studentAddress"));
		stu.setClassName(request.getParameter("className"));
		stu.setSchoolName(request.getParameter("schoolName"));
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = ft.parse(request.getParameter("studentBirthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		stu.setStudentBirthday(new java.sql.Date(date.getDate()));
		Requests req = new Requests();
		String account = request.getParameter("studentId");
		if(account==null||account=="") {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			Map<String,String> map=(Map<String, String>) session.getAttribute("login_Tag");
			account=map.get("account");
		}
		req.setAccount(account);
		req.setUrl(request.getRequestURI()+action);
		req.setTime(new Date().toString());
		StudentImp simp = new StudentImp();
		admin.addRequests(req);
		if("add".equals(action)) {
			int tmp = simp.addStudent(stu);
			if(tmp>0) {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('添加成功');if(back==true){window.location.replace(document.referrer);}</script>");
				out.flush();
				out.close();
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('添加失败');if(back==true){window.location.replace(document.referrer);}</script>");
				out.flush();
				out.close();
			}
		}else if("update".equals(action)) {
			int tmp = simp.updateStudentById(stu);
			if(tmp>0) {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('更新成功');if(back==true){window.location.replace(document.referrer);}</script>");
				out.flush();
				out.close();
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('更新失败');if(back==true){window.location.href='../';}</script>");
				out.flush();
				out.close();
			}
		}
		
	}

}
