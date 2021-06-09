package utils.util;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

public class DBService {
    private Connection connection;

    private static DBService dBService;
    public static DBService getInstance(){
        if (dBService == null) {
            dBService = new DBService();
        }
        return dBService;
    }
    HikariDataSource dataSource = new HikariDataSource();

    public void start() throws IOException, SQLException {
        HikariConfig config = new HikariConfig();
        config.setMaximumPoolSize(1);
        config.setDataSourceClassName("com.mysql.jdbc.jdbc2.optional.MysqlDataSource");
        config.addDataSourceProperty("serverName", "127.0.0.1");
        config.addDataSourceProperty("port", "3306");
        config.addDataSourceProperty("databaseName", "db");
        config.addDataSourceProperty("user", "root");
        config.addDataSourceProperty("password", "123456");
        dataSource = new HikariDataSource(config);

    }


    public Connection getConnection() throws SQLException {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            dataSource.resumePool();
            return null;
        }    }

    public boolean stop() throws SQLException {
        dataSource.close();
        return true;
    }
}
