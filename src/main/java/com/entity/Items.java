package com.entity;

import java.io.Serializable;

import com.util.VeDate;

public class Items implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1201857815018499198L;
	private String itemsid = "I" + VeDate.getStringId();
	private String ordercode;
	private String goodsid;
	private String num;
	private String price;
	private String goodsname;

	public String getItemsid() {
		return itemsid;
	}

	public void setItemsid(String itemsid) {
		this.itemsid = itemsid;
	}

	public String getOrdercode() {
		return this.ordercode;
	}

	public void setOrdercode(String ordercode) {
		this.ordercode = ordercode;
	}

	public String getGoodsid() {
		return this.goodsid;
	}

	public void setGoodsid(String goodsid) {
		this.goodsid = goodsid;
	}

	public String getNum() {
		return this.num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getPrice() {
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getGoodsname() {
		return goodsname;
	}

	public void setGoodsname(String goodsname) {
		this.goodsname = goodsname;
	}
}
