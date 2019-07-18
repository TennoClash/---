package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Cate;
import com.service.CateService;
import com.util.PageHelper;
import com.util.VeDate;

@Controller
@RequestMapping("/cate")
public class CateController extends BaseController {
	@Autowired
	@Resource
	private CateService cateService;

	@RequestMapping("createCate.action")
	public String createCate() {
		return "admin/addcate";
	}

	@RequestMapping("addCate.action")
	public String addCate(Cate cate) {
		cate.setAddtime(VeDate.getStringDateShort());
		this.cateService.insertCate(cate);
		return "redirect:/cate/createCate.action";
	}

	@RequestMapping("deleteCate.action")
	public String deleteCate(String id) {
		this.cateService.deleteCate(id);
		return "redirect:/cate/getAllCate.action";
	}

	@RequestMapping("deleteCateByIds.action")
	public String deleteCateByIds() {
		String[] ids = this.getRequest().getParameterValues("cateid");
		for (String cateid : ids) {
			this.cateService.deleteCate(cateid);
		}
		return "redirect:/cate/getAllCate.action";
	}

	@RequestMapping("updateCate.action")
	public String updateCate(Cate cate) {
		this.cateService.updateCate(cate);
		return "redirect:/cate/getAllCate.action";
	}

	@RequestMapping("getAllCate.action")
	public String getAllCate(String number) {
		List<Cate> cateList = this.cateService.getAllCate();
		PageHelper.getPage(cateList, "cate", null, null, 10, number, this.getRequest(), null);
		return "admin/listcate";
	}

	@RequestMapping("queryCateByCond.action")
	public String queryCateByCond(String cond, String name, String number) {
		Cate cate = new Cate();
		if (cond != null) {
			if ("catename".equals(cond)) {
				cate.setCatename(name);
			}
			if ("addtime".equals(cond)) {
				cate.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.cateService.getCateByLike(cate), "cate", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querycate";
	}

	@RequestMapping("getCateById.action")
	public String getCateById(String id) {
		Cate cate = this.cateService.getCateById(id);
		this.getRequest().setAttribute("cate", cate);
		return "admin/editcate";
	}

	public CateService getCateService() {
		return cateService;
	}

	public void setCateService(CateService cateService) {
		this.cateService = cateService;
	}

}
