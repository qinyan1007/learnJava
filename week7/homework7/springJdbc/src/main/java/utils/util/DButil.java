package utils.util;





import java.io.IOException;
import java.sql.*;

public class DButil {
    public static  void insert() throws Exception {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://172.31.6.111:3306/test?useOldAliasMetadataBehavior=true&useUnicode=true&characterEncoding=utf-8&verifyServerCertificate=false&useSSL=false&requireSSL=false&rewriteBatchedStatements=true";
        String username = "root";
        String paaaword = "Hengbao@123";
        connection = DriverManager.getConnection(url, username, paaaword);
        connection.setAutoCommit(false);

            Long beginTime = System.currentTimeMillis();
            preparedStatement = connection.prepareStatement("insert into `order` (userId, goodId,payType)\n" +
                    "    values(?,?,?)");
            //1万次循环
            for(int i=1;i<=1000000;i++){
                preparedStatement.setInt(1, i);
                preparedStatement.setInt(2, i);
                preparedStatement.setString(3, "zhifubao");
                preparedStatement.addBatch();
                //每1000次提交一次
                 if(i%1000==0){//可以设置不同的大小；如50，100，500，1000等等
                    preparedStatement.executeBatch();
                    connection.commit();
                    preparedStatement.clearBatch();
                }
            }
            Long endTime = System.currentTimeMillis();
            System.out.println("pst+batch："+(endTime-beginTime)/1000+"秒");
        }catch(Exception e){
        e.printStackTrace();
        }  finally {
        preparedStatement.close();
        connection.close();
        }
        }
    public static void main(String[] args) throws Exception {
        insert();
    }
}
