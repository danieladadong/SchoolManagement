package Controller;

import java.util.Map;

public interface LoginController {
	public abstract Map<String,String> loginAsStudent(String account,String password);
	public abstract Map<String,String> loginAsTeacher(String account,String password);
	public abstract Map<String,String> loginAsAdmin(String account,String password);
}
