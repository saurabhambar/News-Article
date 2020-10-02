package org.ambar.news.contollers;

import org.ambar.news.models.Article;
import org.ambar.news.models.Source;
import org.ambar.news.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ArticleController {
    @Autowired
    ArticleService articleService;

    @GetMapping("/")
    public String testServer(){
        return "Server is Up and Running...";
    }

    @PostMapping("/article")
    public Article addArticle(@RequestBody Map<String, Object> body){
        return articleService.addArticle(body);
    }

    @GetMapping("/article/count")
    public Map<String, Long> articleCount(){
        return articleService.countArticles();
    }

    @GetMapping("/article/sources")
    public List<Source> listSources(){
        return articleService.listSources();
    }

    @GetMapping("/article/authors")
    public List<String> listAuthors(){
        return articleService.listAuthors();
    }

    @GetMapping("/articleByDate")
    public List<Article> articlesByDate(@RequestParam("date") String date){
        return articleService.articlesByDate(date);
    }

    @GetMapping("/articleBySource")
    public List<Article> articlesBySource(@RequestParam("source") String source){
        return articleService.articlesBySource(source);
    }

    @GetMapping("/articleByAuthor")
    public List<Article> articlesByAuthor(@RequestParam("author") String author){
        return articleService.articlesByAuthor(author);
    }

    @GetMapping("/article/count/{sourceId}")
    public Map<String, Object> articleCountForSource(@PathVariable String sourceId){
        return articleService.countArticlesForSource(sourceId);
    }

}
