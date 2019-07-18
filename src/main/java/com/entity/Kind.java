package com.entity;

import java.io.Serializable;

import com.util.VeDate;

public class Kind implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7815945897713695115L;
	private String kindid = "K" + VeDate.getStringId();
	private String kindname;

	public String getKindid() {
		return kindid;
	}

	public void setKindid(String kindid) {
		this.kindid = kindid;
	}

	public String getKindname() {
		return this.kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
}
