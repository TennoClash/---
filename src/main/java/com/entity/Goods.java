package com.entity;

import java.io.Serializable;

import com.util.VeDate;

public class Goods implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1113495297320087478L;
	private String goodsid = "G" + VeDate.getStringId();
	private String goodsname;
	private String kindid;
	private String image;
	private String price;
	private String contents;
	private String kindname;

	public String getGoodsid() {
		return goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getGoodsname() {
		return this.goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}

	public String getKindid() {
		return this.kindid;
	}

	public void setKindid(String kindid) {
		this.kindid = kindid;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getKindname() {
		return kindname;
	}

	public void setKindname(String kindname) {
		this.kindname = kindname;
	}
}
