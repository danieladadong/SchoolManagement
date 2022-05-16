package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import com.alibaba.fastjson.JSON;

import Implement.AdminImpl;
import VO.Requests;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet("/AdminServlet")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * Default constructor. 
     */
    public AdminServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		AdminImpl admin = new AdminImpl();
		if("queryRequests".equals(action)) {
			String json = JSON.toJSONString(admin.queryRequests());
			PrintWriter out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		}else if("queryClasses".equals(action)) {
			String json = JSON.toJSONString(admin.queryClasses());
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
		String message = request.getParameter("me");
		List<String> me = new ArrayList<String>();
		if(message!=null||message!="") {
			ServletContext application = getServletContext();
			me = (List<String>) application.getAttribute("message");
			if(me!=null) {
				me.add(message);
			}else {
				me= new ArrayList<String>();
				me.add(message);
			}
			application.setAttribute("message", me);
			response.sendRedirect("admin/adminPage.jsp");
		}
	}

}
