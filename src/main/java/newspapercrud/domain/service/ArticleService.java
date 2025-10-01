package newspapercrud.domain.service;

import jakarta.inject.Inject;
import lombok.Data;
import newspapercrud.dao.basic.BasicArticleRepository;
import newspapercrud.dao.jdbc.JDBCArticleRepository;
import newspapercrud.dao.model.ArticleEntity;
import newspapercrud.domain.model.ArticleDTO;

import java.util.ArrayList;
import java.util.List;

@Data
public class ArticleService {
    private final BasicArticleRepository articleRepository;
    private final JDBCArticleRepository basicArticleJDBC;

    @Inject
    public ArticleService(BasicArticleRepository articleRepository, JDBCArticleRepository basicArticleJDBC) {
        this.articleRepository = articleRepository;
        this.basicArticleJDBC = basicArticleJDBC;
    }


    public List<ArticleDTO> getArticles() {
        List<ArticleEntity> articles = basicArticleJDBC.getAll();
        List<ArticleDTO> articleDTOs = new ArrayList<>();
        articles.forEach(article -> {
            articleDTOs.add(new ArticleDTO(article.getId(), article.getName(), null, 5));
        });

        return articleDTOs;
    }

    public ArticleDTO getArticle(int id) {
        ArticleEntity article = articleRepository.get(id);
        return new ArticleDTO(article.getId(), article.getName(), null, 5);
    }
    public int saveArticle(ArticleDTO articleDTO) {
        ArticleEntity articleEntity = new ArticleEntity(articleDTO.getId(), articleDTO.getName(), null, articleDTO.getAvgRating());
        return articleRepository.save(articleEntity);
    }
    public void deleteArticle(int id) {

        articleRepository.delete(id);
    }
    public void updateArticle(int id, ArticleDTO articleDTO) {
        ArticleEntity articleEntity = new ArticleEntity(articleDTO.getId(), articleDTO.getName(), null, articleDTO.getAvgRating());
        articleRepository.update(id, articleEntity);
    }
}
