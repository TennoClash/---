package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Goods;
import com.service.GoodsService;
import com.entity.Kind;
import com.service.KindService;
import com.util.PageHelper;

@Controller
@RequestMapping("/goods")
public class GoodsController extends BaseController {
	@Autowired
	@Resource
	private GoodsService goodsService;
	@Autowired
	@Resource
	private KindService kindService;

	@RequestMapping("createGoods.action")
	public String createGoods() {
		List<Kind> kindList = this.kindService.getAllKind();
		this.getRequest().setAttribute("kindList", kindList);
		return "admin/addgoods";
	}

	@RequestMapping("addGoods.action")
	public String addGoods(Goods goods) {
		this.goodsService.insertGoods(goods);
		return "redirect:/goods/createGoods.action";
	}

	@RequestMapping("deleteGoods.action")
	public String deleteGoods(String id) {
		this.goodsService.deleteGoods(id);
		return "redirect:/goods/getAllGoods.action";
	}

	@RequestMapping("deleteGoodsByIds.action")
	public String deleteGoodsByIds() {
		String[] ids = this.getRequest().getParameterValues("goodsid");
		for (String goodsid : ids) {
			this.goodsService.deleteGoods(goodsid);
		}
		return "redirect:/goods/getAllGoods.action";
	}

	@RequestMapping("updateGoods.action")
	public String updateGoods(Goods goods) {
		this.goodsService.updateGoods(goods);
		return "redirect:/goods/getAllGoods.action";
	}

	@RequestMapping("getAllGoods.action")
	public String getAllGoods(String number) {
		List<Goods> goodsList = this.goodsService.getAllGoods();
		PageHelper.getPage(goodsList, "goods", null, null, 10, number, this.getRequest(), null);
		return "admin/listgoods";
	}

	@RequestMapping("queryGoodsByCond.action")
	public String queryGoodsByCond(String cond, String name, String number) {
		Goods goods = new Goods();
		if (cond != null) {
			if ("goodsname".equals(cond)) {
				goods.setGoodsname(name);
			}
			if ("kindid".equals(cond)) {
				goods.setKindid(name);
			}
			if ("image".equals(cond)) {
				goods.setImage(name);
			}
			if ("price".equals(cond)) {
				goods.setPrice(name);
			}
			if ("contents".equals(cond)) {
				goods.setContents(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.goodsService.getGoodsByLike(goods), "goods", nameList, valueList, 10, number,
				this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querygoods";
	}

	@RequestMapping("getGoodsById.action")
	public String getGoodsById(String id) {
		Goods goods = this.goodsService.getGoodsById(id);
		this.getRequest().setAttribute("goods", goods);
		List<Kind> kindList = this.kindService.getAllKind();
		this.getRequest().setAttribute("kindList", kindList);
		return "admin/editgoods";
	}

	public GoodsService getGoodsService() {
		return goodsService;
	}

	public void setGoodsService(GoodsService goodsService) {
		this.goodsService = goodsService;
	}

}
