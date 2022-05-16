package Interceptor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import VO.Student;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter implements Filter {

    /**
     * Default constructor. 
     */
    public LoginFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		System.out.println("À¹½ØÆ÷ÒÑÏú»Ù");
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	@SuppressWarnings("unchecked")
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here
		// pass the request along the filter chain
		HttpSession se = ((HttpServletRequest)request).getSession();
		Map<String,String> getMap = new HashMap<String,String>();
		getMap = (Map<String, String>) se.getAttribute("login_Tag");
		if(getMap==null) {
			HttpServletResponse resp = (HttpServletResponse) response;
			resp.setContentType("text/html");
			resp.setCharacterEncoding("utf-8");
			PrintWriter out = resp.getWriter();
			out.println("<script>var back = confirm('»¹µÇÂ¼£¬ÇëÏÈµÇÂ¼£¡');if(back==true){window.location.href='../index.jsp';}</script>");
			out.flush();
			out.close();
		}else{
			if(getMap.get("account")!=null) {
				chain.doFilter(request, response);
			}else {
				HttpServletResponse resp = (HttpServletResponse) response;
				resp.setContentType("text/html");
				resp.setCharacterEncoding("utf-8");
				PrintWriter out = resp.getWriter();
				out.println("<script>var back = confirm('»¹µÇÂ¼£¬ÇëÏÈµÇÂ¼£¡');if(back==true){window.location.href='../index.jsp';}</script>");
				out.flush();
				out.close();
			}
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
		System.out.println("À¹½ØÆ÷Æô¶¯³É¹¦£¡");
	}

}
