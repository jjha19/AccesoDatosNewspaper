package newspapercrud.dao.utilities;

public class SQLQuery {
    public static final String GET_ALL_ARTICLES = "SELECT * FROM Articles";
    public static final String GET_ARTICLE_BY_ID = "SELECT * FROM Articles WHERE ID = ?";
    public static final String INSERT_ARTICLE = "INSERT INTO Articles (ID, Name, NewspaperID,TypeID) VALUES (?, ?, ?, ?)";
    public static final String DELETE_ARTICLE = "DELETE FROM Articles WHERE ID = ?";

}
