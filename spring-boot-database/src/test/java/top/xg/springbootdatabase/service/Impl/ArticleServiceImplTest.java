package top.xg.springbootdatabase.service.Impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import top.xg.springboot.database.entity.Article;
import top.xg.springboot.database.service.ArticleService;

import java.util.List;

@SpringBootTest
@Slf4j
class ArticleServiceImplTest {
    @Resource
    private ArticleService articleService;
    @Test
    void saveArticle() {
        Article article = Article.builder()
                .title("FrontedStudy")
                .author("李四")
                .content("前端学习")
                .build();
        Article savedArticle = articleService.saveArticle(article);
        log.info(String.valueOf(savedArticle));
    }

    @Test
    void deleteArticle() {
        Article article = articleService.getArticle(1L);
        articleService.deleteArticle(1L);
    }

    @Test
    void updateArticle() {
        Article article = articleService.getArticle(1L);
        article.setTitle("SpringBoot2.0");
        articleService.updateArticle(article);
    }

    @Test
    void getArticle() {
        Article article = articleService.getArticle(1L);
        log.info(String.valueOf(article));
    }

    @Test
    void getAll() {
        List<Article> articles = articleService.getAll();
        log.info(String.valueOf(articles));
    }
}