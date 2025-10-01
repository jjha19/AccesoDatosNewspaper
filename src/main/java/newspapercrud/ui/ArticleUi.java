package newspapercrud.ui;

import jakarta.inject.Inject;
import lombok.Data;
import newspapercrud.dao.jdbc.JDBCArticleRepository;
import newspapercrud.domain.model.ArticleDTO;
import newspapercrud.domain.model.TypeDTO;
import newspapercrud.domain.service.ArticleService;

import java.util.List;
import java.util.Scanner;

@Data

public class ArticleUi {
    private final ArticleService articleService;
    private final JDBCArticleRepository basicArticleJDBC;

    @Inject
    public ArticleUi(ArticleService articleService, JDBCArticleRepository basicArticleJDBC) {
        this.basicArticleJDBC = basicArticleJDBC;
        this.articleService = articleService;
    }

    public List<ArticleDTO> getArticles() {
        return articleService.getArticles();
    }

    public ArticleDTO getArticle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Which is the id of the article you want to get?");
        int id = sc.nextInt();
        return articleService.getArticle(id);
    }

    public int saveArticle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the name of the article:");
        String name = sc.nextLine();
        System.out.println("Enter the id of the newspaper:");
        int npaperID = sc.nextInt();
        System.out.println("Enter the id of the type:");
        int typeID = sc.nextInt();
        System.out.println("Enter the average rating of the article:");
        int avgRating = sc.nextInt();
        System.out.println();
        TypeDTO type = new TypeDTO(typeID, null);
        ArticleDTO article = new ArticleDTO(npaperID, name, type, avgRating);
        return articleService.saveArticle(article);
    }

    public void deleteArticle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the article you want to delete:");
        int id = sc.nextInt();
        articleService.deleteArticle(id);
    }

    public void updateArticle() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the id of the article you want to update:");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the new name of the article:");
        String name = sc.nextLine();
        System.out.println("Enter the new id of the newspaper:");
        int npaperID = sc.nextInt();
        System.out.println("Enter the new id of the type:");
        int typeID = sc.nextInt();
        System.out.println();
        TypeDTO type = new TypeDTO(typeID, null);
        ArticleDTO articleDTO = new ArticleDTO(npaperID, name, type, 5);
        articleService.updateArticle(id, articleDTO);
    }

}
