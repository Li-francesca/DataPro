package service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Db.Dbutil;






public class CourseDao {
	//获取所有课程信息
		public List getAllCourse(){
			
		    //from stucourse left join course on stucourse.Cnum = course.Cnum and stucourse.Tnum=teacher.Tnum  where Snum = ?
			 List contentList = new ArrayList();
			String sql = "select Cnum,Cname,Credit,Period,`academy`.Aname,`teacher`.Tname,`teacher`.Tnum from course,academy,teacher where course.academy=academy.Anum and course.Tnum=teacher.Tnum ";
			//String sql = "select `Snum`,`Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student ";
			
			try {
				Dbutil dbutil = new Dbutil();
				Connection conn=Dbutil.getConnection();
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				  
		            contentList=convertList(rs);
				 
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 return contentList;
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
            String sql="select Cnum,Cname,Credit,Period,`academy`.Aname,`teacher`.Tnum,`teacher`.Tname from course,academy,teacher where course.academy=academy.Anum and course.Tnum=teacher.Tnum and course.Cnum=?";
		            Dbutil dbutil = new Dbutil();
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
		            Dbutil dbutil = new Dbutil();
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

	/*	//获取指定学生已选课程信息
		public List<Course> getAllCourse(String snum){
			
		    //String sql=" SELECT * FROM news left join topic on news.ntid = topic.tid where nid = ?" ;	
			List<Course> list = new ArrayList<Course>();
			String sql = "select * from course left join student where course.cnum = student.cnum";
			//String sql = "select `Snum`,`Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student ";
			
			try {
				Dbutil dbutil = new Dbutil();
				Connection conn=dbutil.getCon();
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
		
				while (rs.next()) {
					Course course = new Course();
					course.setCnum(rs.getString("Cnum"));
					course.setCname(rs.getString("Cname"));
					course.setCredit(rs.getString("Credit"));
					course.setPeriod(rs.getString("Period"));
					course.setAcademy(rs.getString("academy"));
					list.add(course);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
		public Student getStudentMoreInfo(Student student) {
			Student stu = new Student();
			String sql = "select `Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student where `Snum`=?";
			Object[] params = { student.getId() };
			ResultSet rs = this.executeQuerySQL(sql, params);
			try {
				Dbutil dbutil = new Dbutil();
				Connection conn=dbutil.getCon();
				PreparedStatement ptmt=conn.prepareStatement(sql);
				ResultSet rs=ptmt.executeQuery();
				while (rs.next()) {
					
					stu.setSnum(rs.getString("Snum"));
					stu.setSname(rs.getString("Sname"));
					stu.setSsex(rs.getString("Ssex"));
					stu.setSbirth(rs.getDate("Sbirth"));//出生日期
					stu.setClnum(rs.getString("Clnum"));
					stu.setEmail(rs.getString("Email"));
					stu.setStatus(rs.getString("Status"));
					stu.setAge(rs.getInt("age"));
					stu.setGradeId(rs.getInt("gradeId"));
					stu.setSex(rs.getString("sex"));
					stu.setName(rs.getString("name"));
					stu.setProfile(rs.getString("profile"));

				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return stu;
		}
		
		//修改学生信息 `Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status`
			public int modifyStudent(Student stu) {

				Dbutil dbutil = new Dbutil();
				
				int row = 0;
				String sql = "update student set `Sname`=?,`Ssex`=?,`Sbirth`=?,`Email`=? where `Snum`=?";
				try {
					Connection conn=dbutil.getCon();//创建数据库的连接   
					PreparedStatement ptmt=conn.prepareStatement(sql);		//创建一个PreparedStatement对象，执行动态SQL语句   			
					ptmt.setString(1, stu.getSname());
					ptmt.setString(2, stu.getSsex());
					ptmt.setDate(3, (Date) stu.getSbirth());
					ptmt.setString(4, stu.getEmail());
					ptmt.setString(5, stu.getSnum());			
					ptmt.execute();//执行SQL语句   	
					row=1;
					System.out.println(stu.getSname());
					System.out.println(stu.getSsex());
					System.out.println(stu.getEmail());
					
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if(row>0){
					System.out.println("修改学生成功");
				}else{
					System.out.println("修改学生失败");
				}
				
				return row;
			}*/
}
