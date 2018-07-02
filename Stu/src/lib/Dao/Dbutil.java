package lib.Dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

/**
 * Created by ttop5 on 16-4-18.
 */
public class Dbutil {
	private static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL="jdbc:mysql://localhost:3306/students";
	private static final String USER="root";
	private static final String PASSWORD="root";
	private static Connection con=null;
    /*String url = "jdbc:mysql://localhost:3306/students?"
            + "user=root&password=root&useUnicode=true&characterEncoding=UTF8";

    private String jdbcName="com.mysql.jdbc.Driver";*/

    public Connection getCon() throws Exception{
        Class.forName(DRIVER);
        con=DriverManager.getConnection(URL, USER, PASSWORD);//创建数据库的连接
        //Connection con = DriverManager.getConnection(url);
        return con;
    }

    public void closeCon(Connection con) throws Exception{
        if(con!=null){
            con.close();
        }
    }

    public static void main(String[] args){
        Dbutil dbutil = new Dbutil();

        try {
            dbutil.getCon();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
