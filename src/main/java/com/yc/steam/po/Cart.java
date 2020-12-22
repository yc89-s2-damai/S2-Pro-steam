package com.yc.steam.po;

public class Cart implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer ciid;
	private Integer uid;
	private Integer gid;
	private Integer count;
	public Integer getCiid() {
		return ciid;
	}
	public void setCiid(Integer ciid) {
		this.ciid = ciid;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getGid() {
		return gid;
	}
	public void setGid(Integer gid) {
		this.gid = gid;
	}
	public Integer getCount() {
		return count;
	}
	public void setCount(Integer count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "cart [ciid=" + ciid + ", uid=" + uid + ", gid=" + gid + ", count=" + count + "]";
	}

}
