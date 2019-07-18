package com.service.impl;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dao.ArticleDAO;
import com.entity.Article;
import com.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	@Resource
	private ArticleDAO articleDAO;

	@Override 
	public int insertArticle(Article article) {
		return this.articleDAO.insertArticle(article);
	}

	@Override 
	public int updateArticle(Article article) {
		return this.articleDAO.updateArticle(article);
	}

	@Override 
	public int deleteArticle(String articleid) {
		return this.articleDAO.deleteArticle(articleid);
	}

	@Override
	public List<Article> getAllArticle() {
		return this.articleDAO.getAllArticle();
	}

	@Override
	public List<Article> getFlvArticle() {
		return this.articleDAO.getFlvArticle();
	}

	@Override
	public List<Article> getTopArticle() {
		return this.articleDAO.getTopArticle();
	}

	@Override
	public List<Article> getArticleByBanner(String bannerid) {
		return this.articleDAO.getArticleByBanner(bannerid);
	}

	@Override 
	public List<Article> getArticleByCond(Article article) {
		return this.articleDAO.getArticleByCond(article);
	}

	@Override
	public List<Article> getArticleByLike(Article article) {
		return this.articleDAO.getArticleByLike(article);
	}

	@Override
	public Article getArticleById(String articleid) {
		return this.articleDAO.getArticleById(articleid);
	}

}
