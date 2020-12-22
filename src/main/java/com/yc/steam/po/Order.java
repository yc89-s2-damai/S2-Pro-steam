package com.yc.steam.po;

import java.util.Date;

public class Order implements java.io.Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private Integer oid;
	private Integer total;
	private Date orderTime;
	private String addr;
	private Integer phone;
	private Integer uid;
	private Integer state;
	private String name;
	public Integer getOid() {
		return oid;
	}
	public void setOid(Integer oid) {
		this.oid = oid;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	public Integer getUid() {
		return uid;
	}
	public void setUid(Integer uid) {
		this.uid = uid;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "order [oid=" + oid + ", total=" + total + ", orderTime=" + orderTime + ", addr=" + addr + ", phone="
				+ phone + ", uid=" + uid + ", state=" + state + ", name=" + name + "]";
	}
	

}
