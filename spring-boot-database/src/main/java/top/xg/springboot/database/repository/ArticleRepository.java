package top.xg.springboot.database.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import top.xg.springboot.database.entity.Article;

public interface ArticleRepository extends JpaRepository<Article,Long> {
}
