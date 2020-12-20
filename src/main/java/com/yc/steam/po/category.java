package com.yc.steam.po;

public class category implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer cid;
	private String ctype;
	public Integer getCid() {
		return cid;
	}
	public void setCid(Integer cid) {
		this.cid = cid;
	}
	public String getCtype() {
		return ctype;
	}
	public void setCtype(String ctype) {
		this.ctype = ctype;
	}
	@Override
	public String toString() {
		return "category [cid=" + cid + ", ctype=" + ctype + "]";
	}
	
}
