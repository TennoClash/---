package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Kind;
import com.service.KindService;
import com.util.PageHelper;

@Controller
@RequestMapping("/kind")
public class KindController extends BaseController {
	@Autowired
	@Resource
	private KindService kindService;

	@RequestMapping("createKind.action")
	public String createKind() {
		return "admin/addkind";
	}

	@RequestMapping("addKind.action")
	public String addKind(Kind kind) {
		this.kindService.insertKind(kind);
		return "redirect:/kind/createKind.action";
	}

	@RequestMapping("deleteKind.action")
	public String deleteKind(String id) {
		this.kindService.deleteKind(id);
		return "redirect:/kind/getAllKind.action";
	}

	@RequestMapping("deleteKindByIds.action")
	public String deleteKindByIds() {
		String[] ids = this.getRequest().getParameterValues("kindid");
		for (String kindid : ids) {
			this.kindService.deleteKind(kindid);
		}
		return "redirect:/kind/getAllKind.action";
	}

	@RequestMapping("updateKind.action")
	public String updateKind(Kind kind) {
		this.kindService.updateKind(kind);
		return "redirect:/kind/getAllKind.action";
	}

	@RequestMapping("getAllKind.action")
	public String getAllKind(String number) {
		List<Kind> kindList = this.kindService.getAllKind();
		PageHelper.getPage(kindList, "kind", null, null, 10, number, this.getRequest(), null);
		return "admin/listkind";
	}

	@RequestMapping("queryKindByCond.action")
	public String queryKindByCond(String cond, String name, String number) {
		Kind kind = new Kind();
		if (cond != null) {
			if ("kindname".equals(cond)) {
				kind.setKindname(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.kindService.getKindByLike(kind), "kind", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querykind";
	}

	@RequestMapping("getKindById.action")
	public String getKindById(String id) {
		Kind kind = this.kindService.getKindById(id);
		this.getRequest().setAttribute("kind", kind);
		return "admin/editkind";
	}

	public KindService getKindService() {
		return kindService;
	}

	public void setKindService(KindService kindService) {
		this.kindService = kindService;
	}

}
