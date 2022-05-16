package Interceptor;

import Implement.AdminImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {
	 public void contextInitialized(ServletContextEvent event) {  
	        System.out.println("服务器启动————初始化");
	 } 
	 public void contextDestroyed(ServletContextEvent event) {
		 AdminImpl admin = new AdminImpl();
		 if(admin.delRequests()>0) {
			 System.out.println("日志清除完毕，服务器关闭");
		 }else {
			 System.out.println("日志清除失败，请手动清除");
		 }
	 }

}
