package utils;

import utils.util.DBService;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

    public static void main(String[] args) throws SQLException, IOException {
        DBService.getInstance().start();
        // statement用来执行SQL语句
        Statement statement = DBService.getInstance().getConnection().createStatement();

        // 要执行的SQL语句id和content是表review中的项。
        String sql = "select * from login where name='Lovell' and password='123456'";

        // 得到结果
        ResultSet rs = statement.executeQuery(sql);

        if(rs.next()){
            System.out.println("Logon");

        }else{
            System.out.println("Login Faild");
        }
        rs.close();
    }

}
