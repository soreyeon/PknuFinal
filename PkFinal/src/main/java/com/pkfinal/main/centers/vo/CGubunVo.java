package com.pkfinal.main.centers.vo;

public class CGubunVo {
	// Fields
	private String c_id;
	private String idx;
	private String gu_name;

	// Getter/Setter
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getIdx() {
		return idx;
	}
	public void setIdx(String idx) {
		this.idx = idx;
	}
	public String getGu_name() {
		return gu_name;
	}
	public void setGu_name(String gu_name) {
		this.gu_name = gu_name;
	}
	// Constructors
	public CGubunVo() {}
	
	public CGubunVo(String c_id, String idx, String gu_name) {
		super();
		this.c_id = c_id;
		this.idx = idx;
		this.gu_name = gu_name;
	}
	// toString
	@Override
	public String toString() {
		return "CGubunVo [c_id=" + c_id + ", idx=" + idx + ", gu_name=" + gu_name + "]";
	}
	
	
	
	
	
}
