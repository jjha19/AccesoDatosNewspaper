package newspapercrud.dao.utilities;

import jakarta.inject.Inject;
import newspapercrud.common.Configuration;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Configuration configuration;

    @Inject
    private DBConnection(Configuration configuration) {
        this.configuration = configuration;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection(configuration.getProperty("urlDB"),
                configuration.getProperty("user_name"),
                configuration.getProperty("password"));
        return connection;
    }
}
