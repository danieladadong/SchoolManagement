package Controller;

import java.util.List;

import VO.Requests;

public interface AdminController {
	public abstract List<Requests> queryRequests();
	public abstract List<Requests> queryByAccount(String account);
	public abstract int addRequests(Requests requests);
	public abstract int delRequests();
}
