package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import Implement.AdminImpl;
import Implement.TeacherImp;
import VO.Requests;
import VO.Student;
import VO.Teacher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminImpl admin = new AdminImpl();
    /**
     * Default constructor. 
     */
    public TeacherServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		String action = request.getParameter("action");
		TeacherImp timp = new TeacherImp();
		Requests req = new Requests();
		String account = request.getParameter("teacherId");
		if(account==null||account=="") {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			Map<String,String> map=(Map<String, String>) session.getAttribute("login_Tag");
			account=map.get("account");
		}
		req.setAccount(account);
		req.setUrl(request.getRequestURI()+action);
		req.setTime(new Date().toString());
		admin.addRequests(req);
		if("delete".equals(action)) {
			int tmp = timp.delTeacherById(Integer.parseInt(request.getParameter("teacherId")));
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
			String json = JSON.toJSONString(timp.queryTeacherAll());
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryById".equals(action)) {
			String json = JSON.toJSONString(timp.queryTeacherById(Integer.parseInt(request.getParameter("teacherId"))));
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryByName".equals(action)) {
			String json = JSON.toJSONString(timp.queryTeacherByName(request.getParameter("teacherName")));
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryByClassName".equals(action)) {
			String json = JSON.toJSONString(timp.queryTeacherByClassName(request.getParameter("className")));
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
		Teacher teacher = new Teacher();
		teacher.setTeacherId(Integer.parseInt(request.getParameter("teacherId")));
		teacher.setTeacherName(request.getParameter("teacherName"));
		teacher.setTeacherSex(request.getParameter("teacherSex"));
		teacher.setPoliticalStatus(request.getParameter("politicalStatus"));
		teacher.setTeacherIDCard(request.getParameter("teacherIdCard"));
		teacher.setTeacherAddress(request.getParameter("teacherAccess"));
		teacher.setClassName(request.getParameter("className"));
		teacher.setSchoolName(request.getParameter("schoolName"));
		SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		try {
			date = ft.parse(request.getParameter("teacherBirthday"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		teacher.setTeacherBirthday(new java.sql.Date(date.getTime()));
		TeacherImp timp = new TeacherImp();
		Requests req = new Requests();
		String account = request.getParameter("teacherId");
		if(account==null||account=="") {
			HttpSession session = request.getSession();
			@SuppressWarnings("unchecked")
			Map<String,String> map=(Map<String, String>) session.getAttribute("login_Tag");
			account=map.get("account");
		}
		req.setAccount(account);
		req.setUrl(request.getRequestURI()+action);
		req.setTime(new Date().toString());
		admin.addRequests(req);
		if("add".equals(action)) {
			int tmp = timp.addTeacher(teacher);
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
			int tmp = timp.updateTeacherById(teacher);
			if(tmp>0) {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('更新成功');if(back==true){window.location.replace(document.referrer);}</script>");
				out.flush();
				out.close();
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('更新失败');if(back==true){window.location.replace(document.referrer);}</script>");
				out.flush();
				out.close();
			}
		}
	}

}
