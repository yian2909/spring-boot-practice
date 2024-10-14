package top.xg.springboot.database.service;

import top.xg.springboot.database.entity.Article;

import java.util.List;

public interface ArticleService {
    Article saveArticle(Article article);
    void deleteArticle(Long id);
    void updateArticle(Article article);
    Article getArticle(Long id);
    List<Article> getAll();
}
