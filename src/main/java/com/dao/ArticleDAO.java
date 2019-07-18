package com.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.entity.Article;

@Repository("articleDAO") 
public interface ArticleDAO {

	public int insertArticle(Article article);

	public int updateArticle(Article article);

	public int deleteArticle(String articleid);

	public List<Article> getAllArticle();

	public List<Article> getFlvArticle();

	public List<Article> getTopArticle();

	public List<Article> getArticleByBanner(String bannerid);

	public List<Article> getArticleByCond(Article article);

	public List<Article> getArticleByLike(Article article);

	public Article getArticleById(String articleid);

}
