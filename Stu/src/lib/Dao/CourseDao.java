package lib.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import lib.Model.Course;



public class CourseDao {
	//获取所有课程信息
		public List<Course> getAllCourse(){
			
		    //from stucourse left join course on stucourse.Cnum = course.Cnum and stucourse.Tnum=teacher.Tnum  where Snum = ?
			List<Course> list = new ArrayList<Course>();
			String sql = "select `Cnum`,`Cname`,`Credit`,`Period`,`academy` from course left join academy on course.academy=academy.Anum";
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
