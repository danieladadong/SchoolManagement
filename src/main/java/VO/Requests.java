package VO;

import com.alibaba.fastjson.annotation.JSONField;

public class Requests {
	@JSONField(ordinal=1)
	private int id;
	@JSONField(ordinal=2)
	private String account;
	@JSONField(ordinal=3)
	private String url;
	@JSONField(ordinal=4)
	private String time;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
}
