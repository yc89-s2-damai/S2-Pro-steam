package com.yc.steam.po;

public class Admin implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer aid;
	private String aname;
	private String apwd;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public String getAname() {
		return aname;
	}
	public void setAname(String aname) {
		this.aname = aname;
	}
	public String getApwd() {
		return apwd;
	}
	public void setApwd(String apwd) {
		this.apwd = apwd;
	}
	@Override
	public String toString() {
		return "admin [aid=" + aid + ", aname=" + aname + ", apwd=" + apwd + "]";
	}

}
