package VeraxFeather.controleurs;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import VeraxFeather.modele.articles.IArticlesDataManager;
import VeraxFeather.modele.articles.stub.StubArticles;
import VeraxFeather.modele.articles.Article;

import java.util.List;

@RestController
public class ArticlesControleur {

    private final IArticlesDataManager articlesDataManager = new StubArticles();

    @GetMapping(value="/articles", produces="application/json")
    public List<Article> getAllArticles() {
        return articlesDataManager.getAllArticles();
    }

    @GetMapping(value="/articles/{id}", produces="application/json")
    public Article getArticle(@PathVariable int id) {

        System.out.println("Id renseigné : " + id);
        return articlesDataManager.getArticle(id);
    }

    @GetMapping(value="/test")
    public String testAPI() {
        return "L'API fonctionne correctement!";
    }
}
