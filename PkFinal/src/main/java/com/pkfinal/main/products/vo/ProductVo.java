package com.pkfinal.main.products.vo;

public class ProductVo {
	private String p_id;
	private String p_name;
	private String pc_code;
	private int p_ga;
	private String p_date;
	public String getP_id() {
		return p_id;
	}
	public void setP_id(String p_id) {
		this.p_id = p_id;
	}
	public String getP_name() {
		return p_name;
	}
	public void setP_name(String p_name) {
		this.p_name = p_name;
	}
	public String getPc_code() {
		return pc_code;
	}
	public void setPc_code(String pc_code) {
		this.pc_code = pc_code;
	}
	public int getP_ga() {
		return p_ga;
	}
	public void setP_ga(int p_ga) {
		this.p_ga = p_ga;
	}
	public String getP_date() {
		return p_date;
	}
	public void setP_date(String p_date) {
		this.p_date = p_date;
	}
	@Override
	public String toString() {
		return "ProductVo [p_id=" + p_id + ", p_name=" + p_name + ", pc_code=" + pc_code + ", p_ga=" + p_ga
				+ ", p_date=" + p_date + "]";
	}
}
