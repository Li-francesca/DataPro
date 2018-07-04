package Db;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class Dbutil {
   /* private static final String URL="jdbc:mysql://localhost:3306/blog";//链接数据库
    private static final String USER="root";//loginName
    private static final String PASSWORD="root";//psw

    private static Connection conn=null;
    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection(URL,USER,PASSWORD);
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static void release(Connection conn, Statement st, ResultSet rs) {
        if(rs!=null) {
            try{
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(st!=null) {
            try{
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try{
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    public static Connection getConnection(){
        return conn;
    }
*/

    private static Properties config = new Properties();

    static{
        InputStream in =Dbutil.class.getClassLoader().getResourceAsStream("database.properties");
        try{
            config.load(in);
            Class.forName(config.getProperty("jdbc.driver"));


        }catch (Exception e) {
            throw new ExceptionInInitializerError(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        String url = config.getProperty("jdbc.url");
        String username = config.getProperty("jdbc.username");
        String password = config.getProperty("jdbc.password");
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    public static void release(Connection conn,Statement st,ResultSet rs) {
        if(rs!=null) {
            try{
                rs.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(st!=null) {
            try{
                st.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(conn!=null) {
            try{
                conn.close();
            }catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
