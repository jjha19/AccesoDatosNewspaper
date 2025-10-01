package newspapercrud.dao.basic;

import newspapercrud.dao.ArticleRepository;
import newspapercrud.dao.model.ArticleEntity;
import newspapercrud.dao.model.TypeEntity;

import java.util.ArrayList;
import java.util.List;

public class BasicArticleRepository {

    public static final List<ArticleEntity> articles = new ArrayList<>();
    public void createList() {
        articles.add(new ArticleEntity(1, "Article 1", new TypeEntity(1, "Type 1"), 5));
        articles.add(new ArticleEntity(2, "Article 2", new TypeEntity(2, "Type 2"), 4));
        articles.add(new ArticleEntity(3, "Article 3", new TypeEntity(3, "Type 3"), 3));
    }

    public List<ArticleEntity> getAll() {

        return articles;

    }

    public ArticleEntity get(int id) {
        ArticleEntity article = articles.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        return article;
    }


    public int save(ArticleEntity articleEntity) {
        articles.add(articleEntity);
        return articleEntity.getId();
    }


    public void delete(int id) {
        articles.remove(get(id));
    }


    public void update(int id, ArticleEntity articleEntity) {
        ArticleEntity article = articles.stream().filter(a -> a.getId() == id).findFirst().orElse(null);
        if (article != null) {
            article.setName(articleEntity.getName());
            article.setType(articleEntity.getType());
            article.setNpaperID(articleEntity.getNpaperID());

        }

    }


}
