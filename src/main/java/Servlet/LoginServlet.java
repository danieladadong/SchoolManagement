package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import Implement.AdminImpl;
import Implement.LoginImpl;
import VO.Requests;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AdminImpl admin = new AdminImpl();
    /**
     * Default constructor. 
     */
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if("exit".equals(action)) {
			HttpSession se = request.getSession();
			se.removeAttribute("login_Tag");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		String type = request.getParameter("type");
		LoginImpl login = new LoginImpl();
		Map<String,String> getMap = new HashMap<String,String>();
		HttpSession se = request.getSession();
		Requests req = new Requests();
		req.setAccount(account);
		req.setUrl(request.getRequestURI()+type);
		req.setTime(new Date().toString());
		admin.addRequests(req);
		if("—ß…˙".equals(type)){
			getMap = login.loginAsStudent(account, password);
			if(getMap.get("account")!=null) {
				se.setAttribute("login_Tag", getMap);
				response.sendRedirect("student/studentPage.jsp");
			}else {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°«Î÷ÿ–¬µ«¬º');if(back==true){window.location.href='index.jsp';}</script>");
				out.flush();
				out.close();
			}
		}else if("ΩÃ ¶".equals(type)){
			getMap = login.loginAsTeacher(account, password);
			if(getMap.get("account")!=null) {
				se.setAttribute("login_Tag", getMap);
				response.sendRedirect("teacher/teacherPage.jsp");
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°«Î÷ÿ–¬µ«¬º');if(back==true){window.location.href='index.jsp';}</script>");
				out.flush();
				out.close();
			}
		}else{
			getMap = login.loginAsAdmin(account, password);
			if(getMap.get("account")!=null) {
				se.setAttribute("login_Tag", getMap);
				response.sendRedirect("admin/adminPage.jsp");
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<script>var back = confirm('’À∫≈ªÚ√‹¬Î¥ÌŒÛ£°«Î÷ÿ–¬µ«¬º');if(back==true){window.location.href='index.jsp';}</script>");
				out.flush();
				out.close();
			}
		}
	}

}
