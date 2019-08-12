package com.pkfinal.main.centers.vo;

import lombok.Data;

@Data
public class CentersVo {
	// Fields
	private String c_id;
	private String c_addr;
	private String c_name;
	private String c_tel;
	
	private CGubunVo cGubunVo;
	
	// Getter/Setter
	public String getC_id() {
		return c_id;
	}
	public void setC_id(String c_id) {
		this.c_id = c_id;
	}
	public String getC_addr() {
		return c_addr;
	}
	public void setC_addr(String c_addr) {
		this.c_addr = c_addr;
	}
	public String getC_name() {
		return c_name;
	}
	public void setC_name(String c_name) {
		this.c_name = c_name;
	}
	public String getC_tel() {
		return c_tel;
	}
	public void setC_tel(String c_tel) {
		this.c_tel = c_tel;
	}
	//
	public CGubunVo getcGubunVo() {
		return cGubunVo;
	}
	public void setcGubunVo(CGubunVo cGubunVo) {
		this.cGubunVo = cGubunVo;
	}
	// Constructors
	public CentersVo() {}
	
	
	public CentersVo(String c_id, String c_addr, String c_name, String c_tel, CGubunVo cGubunVo) {
		super();
		this.c_id = c_id;
		this.c_addr = c_addr;
		this.c_name = c_name;
		this.c_tel = c_tel;
		this.cGubunVo = cGubunVo;
	}
	// toString
	@Override
	public String toString() {
		return "CentersVo [c_id=" + c_id + ", c_addr=" + c_addr + ", c_name=" + c_name + ", c_tel=" + c_tel
				+ ", cGubunVo=" + cGubunVo + "]";
	}
	
	
	
	
}
