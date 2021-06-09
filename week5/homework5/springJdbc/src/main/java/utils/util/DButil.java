package utils.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DButil {
    public void insert() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://127.0.0.1:3306/mybatis-01";
        String username = "root";
        String paaaword = "821365";
        connection = DriverManager.getConnection(url, username, paaaword);
        String sql = "SELECT * FROM tb_user WHERE id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setLong(1,2);

        resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
        System.out.println( resultSet.getString("name"));
        System.out.println(resultSet.getString("user_name"));
        System.out.println(resultSet.getInt("age"));
        }
        }catch(Exception e){
        e.printStackTrace();
        }  finally {
        resultSet.close();
        preparedStatement.close();
        connection.close();
        }
        }

}
