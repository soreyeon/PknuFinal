package com.spring.user.vo;

public class UserVo {
	private String userid;
	private String userpwd;
	private String username;
	private int userpoint;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUserpwd() {
		return userpwd;
	}
	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getUserpoint() {
		return userpoint;
	}
	public void setUserpoint(int userpoint) {
		this.userpoint = userpoint;
	}
	
	public UserVo(String userid, String userpwd, String username, int userpoint) {
		this.userid = userid;
		this.userpwd = userpwd;
		this.username = username;
		this.userpoint = userpoint;
	}
	
	public UserVo() {

	}
	
	
	@Override
	public String toString() {
		return "UserVo [userid=" + userid + ", userpwd=" + userpwd + ", username=" + username + ", userpoint="
				+ userpoint + "]";
	}
	
	
	
}
