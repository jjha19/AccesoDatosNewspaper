package newspapercrud.dao.jdbc.mappers;

import newspapercrud.dao.model.ArticleEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ArticleMapper {


    public List<ArticleEntity> map(ResultSet rs) throws SQLException {
        List<ArticleEntity> articles = new ArrayList<>();
        while (rs.next()) {
            int id = rs.getInt("ID");
            String name = rs.getString("Name");
            int npaperID = rs.getInt("NewspaperID");
            articles.add(new ArticleEntity(id, name, null, npaperID));
        }
        return articles;
    }
}
