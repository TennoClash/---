package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Banner;
import com.service.BannerService;
import com.util.PageHelper;
import com.util.VeDate;

@Controller
@RequestMapping("/banner")
public class BannerController extends BaseController {
	@Autowired
	@Resource
	private BannerService bannerService;

	@RequestMapping("createBanner.action")
	public String createBanner() {
		return "admin/addbanner";
	}

	@RequestMapping("addBanner.action")
	public String addBanner(Banner banner) {
		banner.setAddtime(VeDate.getStringDateShort());
		this.bannerService.insertBanner(banner);
		return "redirect:/banner/createBanner.action";
	}

	@RequestMapping("deleteBanner.action")
	public String deleteBanner(String id) {
		this.bannerService.deleteBanner(id);
		return "redirect:/banner/getAllBanner.action";
	}

	@RequestMapping("deleteBannerByIds.action")
	public String deleteBannerByIds() {
		String[] ids = this.getRequest().getParameterValues("bannerid");
		for (String bannerid : ids) {
			this.bannerService.deleteBanner(bannerid);
		}
		return "redirect:/banner/getAllBanner.action";
	}

	@RequestMapping("updateBanner.action")
	public String updateBanner(Banner banner) {
		this.bannerService.updateBanner(banner);
		return "redirect:/banner/getAllBanner.action";
	}

	@RequestMapping("getAllBanner.action")
	public String getAllBanner(String number) {
		List<Banner> bannerList = this.bannerService.getAllBanner();
		PageHelper.getPage(bannerList, "banner", null, null, 10, number, this.getRequest(), null);
		return "admin/listbanner";
	}

	@RequestMapping("queryBannerByCond.action")
	public String queryBannerByCond(String cond, String name, String number) {
		Banner banner = new Banner();
		if (cond != null) {
			if ("bannername".equals(cond)) {
				banner.setBannername(name);
			}
			if ("addtime".equals(cond)) {
				banner.setAddtime(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.bannerService.getBannerByLike(banner), "banner", nameList, valueList, 10, number, this.getRequest(), "query");
		name = null;
		cond = null;
		return "admin/querybanner";
	}

	@RequestMapping("getBannerById.action")
	public String getBannerById(String id) {
		Banner banner = this.bannerService.getBannerById(id);
		this.getRequest().setAttribute("banner", banner);
		return "admin/editbanner";
	}

	public BannerService getBannerService() {
		return bannerService;
	}

	public void setBannerService(BannerService bannerService) {
		this.bannerService = bannerService;
	}

}
