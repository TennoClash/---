package com.controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.entity.Article;
import com.service.ArticleService;
import com.entity.Banner;
import com.service.BannerService;
import com.util.PageHelper;
import com.util.VeDate;

@Controller
@RequestMapping("/article")
public class ArticleController extends BaseController {
	@Autowired
	@Resource
	private ArticleService articleService;
	@Autowired
	@Resource
	private BannerService bannerService;

	@RequestMapping("createArticle.action")
	public String createArticle() {
		List<Banner> bannerList = this.bannerService.getAllBanner();
		this.getRequest().setAttribute("bannerList", bannerList);
		return "admin/addarticle";
	}

	@RequestMapping("addArticle.action")
	public String addArticle(Article article) {
		article.setAddtime(VeDate.getStringDateShort());
		article.setHits("0");
		this.articleService.insertArticle(article);
		return "redirect:/article/createArticle.action";
	}

	@RequestMapping("deleteArticle.action")
	public String deleteArticle(String id) {
		this.articleService.deleteArticle(id);
		return "redirect:/article/getAllArticle.action";
	}

	@RequestMapping("deleteArticleByIds.action")
	public String deleteArticleByIds() {
		String[] ids = this.getRequest().getParameterValues("articleid");
		for (String articleid : ids) {
			this.articleService.deleteArticle(articleid);
		}
		return "redirect:/article/getAllArticle.action";
	}

	@RequestMapping("updateArticle.action")
	public String updateArticle(Article article) {
		this.articleService.updateArticle(article);
		return "redirect:/article/getAllArticle.action";
	}

	@RequestMapping("getAllArticle.action")
	public String getAllArticle(String number) {
		List<Article> articleList = this.articleService.getAllArticle();
		PageHelper.getPage(articleList, "article", null, null, 10, number, this.getRequest(), null);
		return "admin/listarticle";
	}

	@RequestMapping("queryArticleByCond.action")
	public String queryArticleByCond(String cond, String name, String number) {
		Article article = new Article();
		if (cond != null) {
			if ("title".equals(cond)) {
				article.setTitle(name);
			}
			if ("bannerid".equals(cond)) {
				article.setBannerid(name);
			}
			if ("image".equals(cond)) {
				article.setImage(name);
			}
			if ("istop".equals(cond)) {
				article.setIstop(name);
			}
			if ("isflv".equals(cond)) {
				article.setIsflv(name);
			}
			if ("contents".equals(cond)) {
				article.setContents(name);
			}
			if ("addtime".equals(cond)) {
				article.setAddtime(name);
			}
			if ("hits".equals(cond)) {
				article.setHits(name);
			}
		}

		List<String> nameList = new ArrayList<String>();
		List<String> valueList = new ArrayList<String>();
		nameList.add(cond);
		valueList.add(name);
		PageHelper.getPage(this.articleService.getArticleByLike(article), "article", nameList, valueList, 10, number, this.getRequest(),
				"query");
		name = null;
		cond = null;
		return "admin/queryarticle";
	}

	@RequestMapping("getArticleById.action")
	public String getArticleById(String id) {
		Article article = this.articleService.getArticleById(id);
		this.getRequest().setAttribute("article", article);
		List<Banner> bannerList = this.bannerService.getAllBanner();
		this.getRequest().setAttribute("bannerList", bannerList);
		return "admin/editarticle";
	}

	public ArticleService getArticleService() {
		return articleService;
	}

	public void setArticleService(ArticleService articleService) {
		this.articleService = articleService;
	}

}
