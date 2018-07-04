package service;

import Db.Dbutil;
import bean.Student;
import bean.Teacher;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TeacherDao {
    public  Teacher query(String id) throws SQLException {
        String sql="select * from teacher where Tnum=?";
        Connection conn= Dbutil.getConnection();
        ResultSet rs=null;

        Teacher teacher=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setString(1,id);
            rs=ptmt.executeQuery();
            while(rs.next()){
                teacher=new Teacher();
                teacher.setTnum(rs.getString("Tnum"));
                teacher.setTname(rs.getString("Tname"));
                teacher.setTsex(rs.getString("Tsex"));
                teacher.setTitle(rs.getString("title"));
                teacher.setTphone(rs.getString("Tphone"));
                teacher.setEmail(rs.getString("email"));
                teacher.setTbirth(rs.getDate("Tbirth"));
                teacher.setAcademy(rs.getString("academy"));
                teacher.setPasswd(rs.getString("Passwd"));




            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return teacher;
    }


    public static List<Map<String, Object>> convertList(ResultSet rs) {
        // 新建一个map list集合用于存放多条查询记录
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        try {
            ResultSetMetaData md = rs.getMetaData();// 结果集(rs)的结构信息，比如字段数、字段名等。
            int columnCount = md.getColumnCount();// 取得查询出来的字段个数
            while (rs.next()) {// 迭代rs
                // 新建一个map集合 将查询出内容按照字段名：值 的键值对形式存储在map集合中
                Map<String, Object> rowData = new HashMap<String, Object>();
                for (int i = 1; i <= columnCount; i++) {// 循环所有查询出字段
                    rowData.put(md.getColumnName(i), rs.getObject(i));
                    // getColumnName(i) 获取第i个列名
                    // getObject(i) 获取第i个对象的值
                }
                list.add(rowData);// 将map放入list集合中
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {// 关闭连接
            try {
                if (rs != null)
                    rs.close();
                rs = null;
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    public  List<Map<String, Object>> queryT(String id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{

            //  select * from cms_article limit (page.getPageNo())*page.getPageSize(),page.getPageSize()
            String sql="select Tnum,Tname ,Tsex,Title,Tphone,Email,Tbirth,academy.Aname,academy.Anum,Passwd  from teacher,academy where`academy`.Anum=teacher.academy and Tnum=?";
            conn=Dbutil.getConnection();

            st = conn.prepareStatement(sql);
            st.setString(1, id);

            rs = st.executeQuery();
            List contentList = new ArrayList();
            contentList=convertList(rs);
			/*while(rs.next()) {
				Blog blog=new Blog();
				blog.setId(rs.getInt("id"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setPublicDate(rs.getDate("publicDate"));
				blog.setPublicDate(rs.getDate("lastUpdateDate"));
				blog.setAuthor_id(rs.getInt("author_id"));
				contentList.add(blog);
			}*/

            return contentList;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  List<Map<String, Object>> charge(String id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{

            //  select * from cms_article limit (page.getPageNo())*page.getPageSize(),page.getPageSize()
            String sql="select `academy`.Aname,`depart`.Dnum,Dname,`teacher`.Tname from  depart,teacher,academy where `depart`.Anum=`academy`.Anum and `depart`.Director=`teacher`.Tnum and `academy`.Anum=?";
            conn=Dbutil.getConnection();

            st = conn.prepareStatement(sql);
            st.setString(1, id);

            rs = st.executeQuery();
            List contentList = new ArrayList();
            contentList=convertList(rs);
			/*while(rs.next()) {
				Blog blog=new Blog();
				blog.setId(rs.getInt("id"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setPublicDate(rs.getDate("publicDate"));
				blog.setPublicDate(rs.getDate("lastUpdateDate"));
				blog.setAuthor_id(rs.getInt("author_id"));
				contentList.add(blog);
			}*/

            return contentList;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public  List<Map<String, Object>> charge1(String id) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try{

            //  select * from cms_article limit (page.getPageNo())*page.getPageSize(),page.getPageSize()
            String sql=" select `depart`.Dnum,Dname,`classes`.Cname,`classes`.Clnum from  depart,classes where  `classes`.Dnum=`depart`.Dnum and `depart`.Dnum=?";
            conn=Dbutil.getConnection();

            st = conn.prepareStatement(sql);
            st.setString(1, id);

            rs = st.executeQuery();
            List contentList = new ArrayList();
            contentList=convertList(rs);
			/*while(rs.next()) {
				Blog blog=new Blog();
				blog.setId(rs.getInt("id"));
				blog.setTitle(rs.getString("title"));
				blog.setContent(rs.getString("content"));
				blog.setPublicDate(rs.getDate("publicDate"));
				blog.setPublicDate(rs.getDate("lastUpdateDate"));
				blog.setAuthor_id(rs.getInt("author_id"));
				contentList.add(blog);
			}*/

            return contentList;
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public boolean updateTeacher(Teacher teacher) throws SQLException {
        String sql="update teacher set Tname=?,Tsex=?,Title=?,Tphone=?,Email=?,Tbirth=?,Passwd=? where Tnum=?";
        Connection conn=Dbutil.getConnection();
System.out.println(teacher.getTnum()+"============");
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
           ptmt.setString(1,teacher.getTname());
            ptmt.setString(2,teacher.getTsex());
            ptmt.setString(3,teacher.getTitle());
            ptmt.setString(4, teacher.getTphone());
            ptmt.setString(5, teacher.getEmail());

            ptmt.setDate(6, teacher.getTbirth());
            ptmt.setString(7, teacher.getPasswd());
            ptmt.setString(8, teacher.getTnum());
            ptmt.execute();

            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
        }


    }

}
