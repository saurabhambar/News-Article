package org.ambar.news.services;

import org.ambar.news.models.Article;
import org.ambar.news.models.Source;

import java.util.List;
import java.util.Map;

public interface ArticleService {
    Article addArticle(Map<String, Object> article);
    Map<String, Long> countArticles();
    List<Source> listSources();
    List<String> listAuthors();
    List<Article> articlesByDate(String date);
    List<Article> articlesBySource(String source);
    List<Article> articlesByAuthor(String author);
    Map<String, Object> countArticlesForSource(String source);
}
