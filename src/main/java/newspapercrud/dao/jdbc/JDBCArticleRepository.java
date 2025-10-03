package newspapercrud.dao.jdbc;

import jakarta.inject.Inject;
import lombok.Data;
import newspapercrud.dao.ArticleRepository;
import newspapercrud.dao.jdbc.mappers.ArticleMapper;
import newspapercrud.dao.model.ArticleEntity;
import newspapercrud.dao.utilities.DBConnection;
import newspapercrud.dao.utilities.SQLQuery;
import newspapercrud.domain.error.AppError;
import newspapercrud.domain.error.DatabaseError;

import java.sql.*;
import java.util.List;

@Data

public class JDBCArticleRepository implements ArticleRepository {
    private final ArticleMapper mapper;
    private DBConnection db;

    @Inject
    public JDBCArticleRepository(ArticleMapper mapper, DBConnection db) {
        this.db = db;
        this.mapper = mapper;
    }

    @Override
    public List<ArticleEntity> getAll() {

         List<ArticleEntity> articles;

        try (Connection myConnection = db.getConnection();
             Statement stm = myConnection.createStatement();
             ResultSet rs = stm.executeQuery(SQLQuery.GET_ALL_ARTICLES))
        {
            return articles = mapper.map(rs);
        } catch (SQLException e) {
            throw new DatabaseError(e.getMessage());
        }catch (Exception e) {
            throw new AppError(e.getMessage());
        }

    }



    @Override
    public ArticleEntity get(int id) {
        ArticleEntity article;
        try (Connection myConnection = db.getConnection();
             Statement stm = myConnection.createStatement();
             ResultSet rs = stm.executeQuery(SQLQuery.GET_ARTICLE_BY_ID+ id))
        {
            return article = mapper.map(rs).stream().findFirst().orElse(null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public int save(ArticleEntity article) {
        int rowsaffected = 0;
        try(Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.INSERT_ARTICLE)){
            preparedStatement.setInt(1, article.getId());
            preparedStatement.setString(2, article.getName());
            preparedStatement.setInt(3, article.getNpaperID());
            preparedStatement.setInt(4,9);
            rowsaffected = preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.err.format("SQL State: %s%n%s", e.getSQLState(), e.getMessage());
        }catch (Exception e){
            e.printStackTrace();
        }
        return rowsaffected;
    }

    @Override
    public void delete(int id) {
        int rowsaffected = 0;
        try(Connection connection = db.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQLQuery.DELETE_ARTICLE)){
            preparedStatement.setInt(1, id);
            rowsaffected = preparedStatement.executeUpdate();
        } catch (SQLException e){
            System.err.format("SQL State: %s%n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e){
            e.printStackTrace();
        }
        if(rowsaffected == 1){
            System.out.println("Article deleted successfully!");
            System.out.println(rowsaffected);
        }else{
            System.out.println("Article not found!");
        }
    }

    @Override
    public void update(int id, ArticleEntity articleEntity) {

    }
}
