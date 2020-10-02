package org.ambar.news.repositories;

import org.ambar.news.models.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Integer> {
    List<Article> findByAuthorContaining(String text);

    @Query("SELECT DISTINCT a.author FROM Article a")
    List<String> findDistinctAuthor();

    @Query("SELECT a FROM Article a WHERE DATE(a.publishedAt) = ?1")
    List<Article> findArticlesByDate(Date date);
}
