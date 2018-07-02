package lib.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import lib.Model.Course;
import lib.Model.StuCourse;

public class StuCourseDao {
	//获取指定学生已选课程信息
			public List<StuCourse> getAllStuCourse(String snum){
				
			    //String sql=" SELECT * FROM news left join topic on news.ntid = topic.tid where nid = ?" ;	
				List<StuCourse> list = new ArrayList<StuCourse>();
				String sql = "select * from stucourse left join course on stucourse.Cnum = course.Cnum and stucourse.Tnum=teacher.Tnum  where Snum = ?";
				
				try {
					Dbutil dbutil = new Dbutil();
					Connection conn=dbutil.getCon();
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
			public void selectCourse(Course course) {
						
						String sql="INSERT INTO stucourse(Snum,Cnum) VALUES(?,?) ";
						try {
							
							Dbutil dbutil = new Dbutil();
							Connection conn=dbutil.getCon();
							PreparedStatement ptmt=conn.prepareStatement(sql);
							ResultSet rs=ptmt.executeQuery();
							StuCourse stucourse = new StuCourse();
								
							ptmt.setString(1, stucourse.getSnum());
							ptmt.setString(2, stucourse.getCnum());	
							
							ptmt.execute();	//执行SQL语句   	
							
						} catch (SQLException e){
							e.printStackTrace();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
}
