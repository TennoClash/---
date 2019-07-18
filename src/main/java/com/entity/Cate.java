package com.entity;

import java.io.Serializable;

import com.util.VeDate;

public class Cate implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 6113302332632244921L;
	private String cateid = "C" + VeDate.getStringId();
	private String catename;
	private String addtime;
	private String way;

	public String getCateid() {
		return cateid;
	}

	public void setCateid(String cateid) {
		this.cateid = cateid;
	}

	public String getCatename() {
		return this.catename;
	}

	public void setCatename(String catename) {
		this.catename = catename;
	}

	public String getAddtime() {
		return this.addtime;
	}

	public void setAddtime(String addtime) {
		this.addtime = addtime;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}
}
