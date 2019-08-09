package com.pknufinal.vo;

public class PknuVo {
	private String mn_id;
	private String mn_name;
	private String mn_seq;
	private String mn_gbn;
	private String mn_url;
	
	public String getMn_id() {
		return mn_id;
	}
	public void setMn_id(String mn_id) {
		this.mn_id = mn_id;
	}
	public String getMn_name() {
		return mn_name;
	}
	public void setMn_name(String mn_name) {
		this.mn_name = mn_name;
	}
	public String getMn_seq() {
		return mn_seq;
	}
	public void setMn_seq(String mn_seq) {
		this.mn_seq = mn_seq;
	}
	public String getMn_gbn() {
		return mn_gbn;
	}
	public void setMn_gbn(String mn_gbn) {
		this.mn_gbn = mn_gbn;
	}
	public String getMn_url() {
		return mn_url;
	}
	public void setMn_url(String mn_url) {
		this.mn_url = mn_url;
	}
	
	@Override
	public String toString() {
		return "PknuVo [mn_id=" + mn_id + ", mn_name=" + mn_name + ", mn_seq=" + mn_seq + ", mn_gbn=" + mn_gbn
				+ ", mn_url=" + mn_url + "]";
	}
	
	public PknuVo(String mn_id, String mn_name, String mn_seq, String mn_gbn, String mn_url) {

		this.mn_id = mn_id;
		this.mn_name = mn_name;
		this.mn_seq = mn_seq;
		this.mn_gbn = mn_gbn;
		this.mn_url = mn_url;
	}

	public PknuVo() {

	}
	
	
}
