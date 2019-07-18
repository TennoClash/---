package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Items;
import com.service.ItemsService;
import com.entity.Goods;
import com.service.GoodsService;
import com.util.PageHelper;

@Controller
@RequestMapping("/items")
public class ItemsController extends BaseController {
	@Autowired
	@Resource
	private ItemsService itemsService;
	@Autowired
	@Resource
	private GoodsService goodsService;

	@RequestMapping("createItems.action")
	public String createItems() {
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		return "admin/additems";
	}

	@RequestMapping("addItems.action")
	public String addItems(Items items) {
		this.itemsService.insertItems(items);
		return "redirect:/items/createItems.action";
	}

	@RequestMapping("deleteItems.action")
	public String deleteItems(String id) {
		this.itemsService.deleteItems(id);
		return "redirect:/items/getAllItems.action";
	}

	@RequestMapping("deleteItemsByIds.action")
	public String deleteItemsByIds() {
		String[] ids = this.getRequest().getParameterValues("itemsid");
		for (String itemsid : ids) {
			this.itemsService.deleteItems(itemsid);
		}
		return "redirect:/items/getAllItems.action";
	}

	@RequestMapping("updateItems.action")
	public String updateItems(Items items) {
		this.itemsService.updateItems(items);
		return "redirect:/items/getAllItems.action";
	}

	@RequestMapping("getAllItems.action")
	public String getAllItems(String number) {
		List<Items> itemsList = this.itemsService.getAllItems();
		PageHelper.getPage(itemsList, "items", null, null, 10, number, this.getRequest(), null);
		return "admin/listitems";
	}

	//模糊查询
	@RequestMapping("queryItemsByCond.action")
	public String queryItemsByCond(String cond, String name, String number) {
		Items items = new Items();
		if (cond != null) {
			if ("ordercode".equals(cond)) {
				items.setOrdercode(name);
			}
			if ("goodsid".equals(cond)) {
				items.setGoodsid(name);
			}
			if ("num".equals(cond)) {
				items.setNum(name);
			}
			if ("price".equals(cond)) {
				items.setPrice(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.itemsService.getItemsByLike(items), "items", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/queryitems";
	}

	@RequestMapping("getItemsById.action")
	public String getItemsById(String id) {
		Items items = this.itemsService.getItemsById(id);
		this.getRequest().setAttribute("items", items);
		List<Goods> goodsList = this.goodsService.getAllGoods();
		this.getRequest().setAttribute("goodsList", goodsList);
		return "admin/edititems";
	}

	public ItemsService getItemsService() {
		return itemsService;
	}

	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}

}
