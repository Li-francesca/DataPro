package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Db.Dbutil;
import bean.Course;
import bean.StuCourse;

public class StuCourseDao {
	//获取指定学生已选课程信息
			public List<StuCourse> getAllStuCourse(String snum){
				
			    //String sql=" SELECT * FROM news left join topic on news.ntid = topic.tid where nid = ?" ;	
				List<StuCourse> list = new ArrayList<StuCourse>();
				String sql = "select * from stucourse left join course on stucourse.Cnum = course.Cnum and stucourse.Tnum=teacher.Tnum  where Snum = ?";
				
				try {
					Dbutil dbutil = new Dbutil();
					Connection conn=Dbutil.getConnection();
					PreparedStatement ptmt=conn.prepareStatement(sql);
					ResultSet rs=ptmt.executeQuery();
			
					while (rs.next()) {
						StuCourse stucourse = new StuCourse();
						Course course = new Course();
						stucourse.setCnum(rs.getString("Cnum"));
						stucourse.setGrade(rs.getString("Grade"));
						stucourse.setTnum(rs.getString("Tnum"));
						stucourse.setYnum(rs.getDate("Ynum"));
						stucourse.setTerm(rs.getInt("Term"));
						
						/*course.setCname(rs.getString("Cname"));
						course.setCredit(rs.getString("Credit"));
						course.setPeriod(rs.getString("Period"));
						course.setAcademy(rs.getString("academy"));*/
						list.add(stucourse);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return list;
			}
			
			//选课
			public void selectCourse(StuCourse c) {
						
						String sql="INSERT INTO stucourse(Snum,Cnum,Tnum) VALUES(?,?,?) ";
						try {
							
							Dbutil dbutil = new Dbutil();
							Connection conn=Dbutil.getConnection();
							PreparedStatement ptmt=conn.prepareStatement(sql);
							ptmt.setString(1,c.getSnum());
							ptmt.setString(2, c.getCnum());	
							ptmt.setString(3, c.getTnum());
							 
							//StuCourse stucourse = new StuCourse();
								
						 
							
							ptmt.execute();	//执行SQL语句   	
							
						} catch (SQLException e){
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
}
