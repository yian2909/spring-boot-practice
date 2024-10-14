package top.xg.springboot.database.service.Impl;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import top.xg.springboot.database.entity.Article;
import top.xg.springboot.database.repository.ArticleRepository;
import top.xg.springboot.database.service.ArticleService;

import java.util.List;
import java.util.Optional;

/**
 * @author Lenovo
 */
@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    private ArticleRepository articleRepository;

    @Override
    public Article saveArticle(Article article) {
        articleRepository.save(article);
        return article;
    }

    @Override
    public void deleteArticle(Long id) {
        articleRepository.deleteById(id);
    }

    @Override
    public void updateArticle(Article article) {
        articleRepository.save(article);
    }

    @Override
    public Article getArticle(Long id) {
        Optional<Article> article = articleRepository.findById(id);
        return article.orElse(null);
    }

    @Override
    public List<Article> getAll() {
        return articleRepository.findAll();
    }
}
