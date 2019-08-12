package com.pkfinal.main.products.vo;

public class ProductVo {
	private String p_id;
	private String p_name;
	private String p_category;
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

	public String getP_category() {
		return p_category;
	}

	public void setP_category(String p_category) {
		this.p_category = p_category;
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
		return "ProductVo [p_id=" + p_id + ", p_name=" + p_name + ", p_category=" + p_category + ", p_ga=" + p_ga
				+ ", p_date=" + p_date + "]";
	}

}
