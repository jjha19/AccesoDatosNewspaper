package newspapercrud.dao;

import newspapercrud.dao.model.ArticleEntity;
import newspapercrud.dao.model.CredentialsEntity;

import java.util.List;

public interface ArticleRepository {
    List<ArticleEntity> getAll();
    ArticleEntity get(int id);
    int save(ArticleEntity articleEntity);
    void delete(int id);
    void update(int id, ArticleEntity articleEntity);
}
