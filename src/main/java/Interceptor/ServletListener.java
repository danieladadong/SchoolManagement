package Interceptor;

import Implement.AdminImpl;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;

public class ServletListener implements ServletContextListener {
	 public void contextInitialized(ServletContextEvent event) {  
	        System.out.println("��������������������ʼ��");
	 } 
	 public void contextDestroyed(ServletContextEvent event) {
		 AdminImpl admin = new AdminImpl();
		 if(admin.delRequests()>0) {
			 System.out.println("��־�����ϣ��������ر�");
		 }else {
			 System.out.println("��־���ʧ�ܣ����ֶ����");
		 }
	 }

}
