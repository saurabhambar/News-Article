package org.ambar.news.services;

import org.ambar.news.models.Article;
import org.ambar.news.models.Source;
import org.ambar.news.repositories.ArticleRepository;
import org.ambar.news.repositories.SourceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Autowired
    ArticleRepository articleRepository;
    @Autowired
    SourceRepository sourceRepository;

    @Override
    public Article addArticle(Map<String, Object> article) {
        Timestamp time = Timestamp.valueOf(article.get("publishedAt").toString());
        Article article1 = new Article();
        Source source = new Source();
        source.setSourceId("the-hindu");
        source.setName("The Hindu");

        article1.setAuthor(article.get("author").toString());
        article1.setTitle(article.get("title").toString());
        article1.setDescription(article.get("description").toString());
        article1.setUrl(article.get("url").toString());
        article1.setUrlToImage(article.get("urlToImage").toString());
        article1.setPublishedAt(time);
        article1.setContent(article.get("content").toString());
        article1.setSource(source);

        return articleRepository.save(article1);
    }

    @Override
    public Map<String, Long> countArticles() {
        Map<String, Long> res =  new HashMap<String, Long>();

        long count = articleRepository.count();
        res.put("articleCount", count);

        return res;
    }

    @Override
    public List<Source> listSources() {
        return sourceRepository.findAll();
    }

    @Override
    public List<String> listAuthors() {
        return articleRepository.findDistinctAuthor();
    }

    @Override
    public List<Article> articlesByDate(String date) {
        return articleRepository.findArticlesByDate(Date.valueOf(date));
    }

    @Override
    public List<Article> articlesBySource(String source) {
        Source source1 = sourceRepository.findOne(source);

        return source1.getArticles();
    }

    @Override
    public List<Article> articlesByAuthor(String author) {
        return articleRepository.findByAuthorContaining(author);
    }

    @Override
    public Map<String, Object> countArticlesForSource(String source) {
        Map<String, Object> res = new HashMap<>();
        Source source1 = sourceRepository.findOne(source);
        long count = source1.getArticles().size();
        res.put("sourceId", source);
        res.put("noOfArticles", count);
        return res;
    }
}
