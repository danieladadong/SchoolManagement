package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.Map;

import com.alibaba.fastjson.JSON;

import Implement.AdminImpl;
import Implement.CourseImpl;
import VO.Course;
import VO.Requests;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class CourseServlet
 */
@WebServlet("/CourseServlet")
public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminImpl admin = new AdminImpl();
    /**
     * Default constructor. 
     */
    public CourseServlet() {
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
		CourseImpl cimp = new CourseImpl();
		Requests req = new Requests();
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String,String> map=(Map<String, String>) session.getAttribute("login_Tag");
		String account=map.get("account");
		req.setAccount(account);
		req.setUrl(request.getRequestURI()+action);
		req.setTime(new Date().toString());
		admin.addRequests(req);
		if("queryAll".equals(action)) {
			String json = JSON.toJSONString(cimp.queryAll());
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryByName".equals(action)) {
			String json = JSON.toJSONString(cimp.queryByName(request.getParameter("c_name")));
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryByTeacherName".equals(action)) {
			String json = JSON.toJSONString(cimp.queryByTeacherName(request.getParameter("c_teacher")));
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryByClass".equals(action)) {
			String json = JSON.toJSONString(cimp.queryByClass(request.getParameter("c_class")));
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("deleteById".equals(action)) {
			int tmp = cimp.deleteCourseById(Integer.parseInt(request.getParameter("id")));
			String message = "";
			if(tmp>0) {
				message = "删除成功！";
			}else {
				message = "删除失败！";
			}
			PrintWriter out = response.getWriter();
			out.println(message);
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
		Course course = new Course();
		course.setC_name(request.getParameter("c_name"));
		course.setC_crs(Integer.parseInt(request.getParameter("c_crs")));
		course.setC_number(Integer.parseInt(request.getParameter("c_number")));
		course.setC_exam(request.getParameter("c_exam"));
		course.setC_type(request.getParameter("c_type"));
		course.setC_week(request.getParameter("c_week"));
		course.setC_time(request.getParameter("c_time"));
		course.setC_address(request.getParameter("c_address"));
		course.setC_class(request.getParameter("c_class"));
		course.setC_teacher(request.getParameter("c_teacher"));
		CourseImpl cimp = new CourseImpl();
		Requests req = new Requests();
		HttpSession session = request.getSession();
		@SuppressWarnings("unchecked")
		Map<String,String> map=(Map<String, String>) session.getAttribute("login_Tag");
		String account=map.get("account");
		req.setAccount(account);
		req.setUrl(request.getRequestURI()+action);
		req.setTime(new Date().toString());
		admin.addRequests(req);
		if("addCourse".equals(action)) {
			int tmp = cimp.addCourse(course);
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
		}else if("updateCourse".equals(action)) {
			int tmp = cimp.updateCourseById(course);
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
