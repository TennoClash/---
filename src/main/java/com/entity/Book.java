package com.entity;

import java.io.Serializable;

import com.util.VeDate;

public class Book implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -5979431019187905521L;
	private String bookid = "B" + VeDate.getStringId();
	private String bookno;
	private String cateid;
	private String addtime;
	private String money;
	private String adminid;
	private String memo;
	private String catename;
	private String realname;
	private String way;

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public String getBookid() {
		return bookid;
	}

	public void setBookid(String bookid) {
		this.bookid = bookid;
	}

	public String getBookno() {
		return this.bookno;
	}

	public void setBookno(String bookno) {
		this.bookno = bookno;
	}

	public String getCateid() {
		return this.cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getMoney() {
		return this.money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getAdminid() {
		return this.adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getMemo() {
		return this.memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getCatename() {
		return catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getRealname() {
		return this.realname;
	}

	public void setRealname(String realname) {
		this.realname = realname;
	}
}
