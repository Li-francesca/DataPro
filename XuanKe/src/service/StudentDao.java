package service;

import Db.Dbutil;
import bean.Student;
import bean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {
    public List<Student> query() throws SQLException {
        String sql="select * from student";
        Connection conn= Dbutil.getConnection();
        ResultSet rs=null;
        List<Student> list=new ArrayList<Student>();
        Student student=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            rs=ptmt.executeQuery();
            while(rs.next()){
                student=new Student();
                student.setSnum(rs.getString("Snum"));
                student.setSname(rs.getString("Sname"));
                student.setSsex(rs.getString("Ssex"));
                student.setSbirth(rs.getDate("Sbirth"));
                student.setClnum(rs.getString("Clnum"));
                student.setEmail(rs.getString("email"));
                student.setPasswd(rs.getString("Passwd"));
                student.setStatus(rs.getString("Status"));



                list.add(student);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return list;
    }


    public boolean updateStudent(Student student) throws SQLException {
        String sql="update student set Sbirth=?,Clnum=? email=? Passwd=? Status=? where Sname=?";
        Connection conn=Dbutil.getConnection();

        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setDate(1,student.getSbirth());
            ptmt.setString(2, student.getClnum());
            ptmt.setString(3,student.getEmail());
            ptmt.setString(4, student.getPasswd());
            ptmt.setString(5, student.getStatus());
            ptmt.setString(6, student.getSname());

            ptmt.execute();

            return true;
        } catch (Exception e) {
            // TODO Auto-generated catch block
            return false;
        }


    }



    public Student queryS(String id) throws SQLException {//根据登录名查询
        String sql="select * from student where Snum=?";
        Connection conn= Dbutil.getConnection();
        ResultSet rs=null;

        Student student=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setString(1,id);
            rs=ptmt.executeQuery();
            if(rs.next()){
                student=new Student();
                student.setSnum(rs.getString("Snum"));
                student.setSname(rs.getString("Sname"));
                student.setSsex(rs.getString("Ssex"));
                student.setSbirth(rs.getDate("Sbirth"));
                student.setClnum(rs.getString("Clnum"));
                student.setEmail(rs.getString("email"));
                student.setPasswd(rs.getString("Passwd"));
                student.setStatus(rs.getString("Status"));

            }

        } catch (Exception e) {
            // TODO: handle exception
        }
        return student;
    }

    public Teacher queryT(String id) throws SQLException {//根据登录名查询
        String sql="select * from teacher where Tnum=?";
        Connection conn= Dbutil.getConnection();
        ResultSet rs=null;

        Teacher teacher=null;
        try {
            PreparedStatement ptmt=conn.prepareStatement(sql);
            ptmt.setString(1,id);
            rs=ptmt.executeQuery();
            if(rs.next()){

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
    

	//获取所有学生信息
	public List<Student> getAllStudent(){
		
	    
		List<Student> list = new ArrayList<Student>();
		String sql = "select `Snum`,`Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student ";
		//String sql = "select `Snum`,`Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student ";
		
		try {
			Dbutil dbutil = new Dbutil();
			Connection conn=Dbutil.getConnection();
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ResultSet rs=ptmt.executeQuery();
	
			while (rs.next()) {
				Student stu = new Student();
				stu.setSnum(rs.getString("Snum"));
				stu.setSname(rs.getString("Sname"));
				stu.setSsex(rs.getString("Ssex"));
				stu.setSbirth(rs.getDate("Sbirth"));//出生日期
				stu.setClnum(rs.getString("Clnum"));
				stu.setEmail(rs.getString("Email"));
				stu.setStatus(rs.getString("Status"));
				list.add(stu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	//获取指定学生信息
	public Student getStudentMoreInfo(String Snum) {
		System.out.println("dao:"+Snum);
		Student stu = new Student();
		System.out.println("学号："+Snum);
		String sql = "select * from student left join classes on student.Clnum=classes.Clnum where `Snum`=?";
		try {
			Dbutil dbutil = new Dbutil();
			Connection conn=Dbutil.getConnection();
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, Snum);
			//ResultSet rs=ptmt.executeQuery(sql);
			
			ResultSet rs=ptmt.executeQuery();
			while (rs.next()) {
				
				stu.setSnum(rs.getString("Snum"));
				stu.setSname(rs.getString("Sname"));
				stu.setSsex(rs.getString("Ssex"));
				stu.setSbirth(rs.getDate("Sbirth"));//出生日期
				stu.setClnum(rs.getString("Clnum"));
				stu.setEmail(rs.getString("Email"));
				stu.setStatus(rs.getString("Status"));
				/*stu.setAge(rs.getInt("age"));
				stu.setGradeId(rs.getInt("gradeId"));
				stu.setSex(rs.getString("sex"));
				stu.setName(rs.getString("name"));
				stu.setProfile(rs.getString("profile"));*/
			
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
			String sql = "update student set `Sname`=?,`Ssex`=?,`Sbirth`=?,`Email`=? ,`Clnum`=? ,`Status`=? where `Snum`=?";
			try {
				Connection conn=Dbutil.getConnection();//创建数据库的连接   
				PreparedStatement ptmt=conn.prepareStatement(sql);		//创建一个PreparedStatement对象，执行动态SQL语句   			
				ptmt.setString(1, stu.getSname());
				ptmt.setString(2, stu.getSsex());
				ptmt.setDate(3, stu.getSbirth());
				ptmt.setString(4, stu.getEmail());
				ptmt.setString(5, stu.getClnum());
				ptmt.setString(6, stu.getStatus());
				ptmt.setString(7, stu.getSnum());
				//ptmt.execute(sql);
				ptmt.execute();//执行SQL语句   	
				row=1;
				System.out.println("----------------------");
				System.out.println(stu.getSnum());
				System.out.println(stu.getSname());
				System.out.println(stu.getSsex());
				System.out.println(stu.getEmail());
				System.out.println(stu.getClnum());
				
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
		}
}
