package com.pkfinal.main.members.vo;

public class MembersVo {
	// Fields
	private String m_id;
	private String m_uid;
	private String m_name;
	private String m_pwd;
	private String m_zipcode;
	private String m_city;
	private String m_gugun;
	private String m_tel;
	private String m_email;
	private String m_gbn;
	private String c_id;
	
	// Getter/Setter
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public String getM_uid() {
		return m_uid;
	}
	public void setM_uid(String m_uid) {
		this.m_uid = m_uid;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_pwd() {
		return m_pwd;
	}
	public void setM_pwd(String m_pwd) {
		this.m_pwd = m_pwd;
	}
	public String getM_zipcode() {
		return m_zipcode;
	}
	public void setM_zipcode(String m_zipcode) {
		this.m_zipcode = m_zipcode;
	}
	public String getM_city() {
		return m_city;
	}
	public void setM_city(String m_city) {
		this.m_city = m_city;
	}
	public String getM_gugun() {
		return m_gugun;
	}
	public void setM_gugun(String m_gugun) {
		this.m_gugun = m_gugun;
	}
	public String getM_tel() {
		return m_tel;
	}
	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	public String getM_email() {
		return m_email;
	}
	public void setM_email(String m_email) {
		this.m_email = m_email;
	}
	public String getM_gbn() {
		return m_gbn;
	}
	public void setM_gbn(String m_gbn) {
		this.m_gbn = m_gbn;
	}
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	
	//Constructors
	public MembersVo() {}
	public MembersVo(String m_id, String m_uid, String m_name, String m_pwd, String m_zipcode, String m_city,
			String m_gugun, String m_tel, String m_email, String m_gbn, String c_id) {
		super();
		this.m_id = m_id;
		this.m_uid = m_uid;
		this.m_name = m_name;
		this.m_pwd = m_pwd;
		this.m_zipcode = m_zipcode;
		this.m_city = m_city;
		this.m_gugun = m_gugun;
		this.m_tel = m_tel;
		this.m_email = m_email;
		this.m_gbn = m_gbn;
		this.c_id = c_id;
	}
	
	//toString
	@Override
	public String toString() {
		return "MembersVo [m_id=" + m_id + ", m_uid=" + m_uid + ", m_name=" + m_name + ", m_pwd=" + m_pwd
				+ ", m_zipcode=" + m_zipcode + ", m_city=" + m_city + ", m_gugun=" + m_gugun + ", m_tel=" + m_tel
				+ ", m_email=" + m_email + ", m_gbn=" + m_gbn + ", c_id=" + c_id + "]";
	}
	
	
	
}
