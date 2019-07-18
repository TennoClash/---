package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Goods;
import com.entity.Items;
import com.service.GoodsService;
import com.service.ItemsService;

@Controller
@RequestMapping("/ajax")
public class AjaxController extends BaseController {

	@Autowired
	@Resource
	private ItemsService itemsService;
	@Autowired
	@Resource
	private GoodsService goodsService;

	@RequestMapping("save.action")
	public void save(HttpServletResponse response) {
		String str = this.getRequest().getParameter("str");
		String[] s = str.split(",");
		Items items = new Items();
		items.setOrdercode(s[0]);
		items.setGoodsid(s[1]);
		items.setNum(s[2]);
		Goods goods = this.goodsService.getGoodsById(items.getGoodsid());
		items.setPrice(goods.getPrice());
		this.itemsService.insertItems(items);
		PrintWriter out = null;
		try {
			response.setCharacterEncoding("UTF-8");
			out = response.getWriter();
		} catch (IOException ex) {
		}
		out.write(items.getItemsid());
		out.close();
	}

}
