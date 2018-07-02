package lib.Dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import lib.Model.Student;

public class StudentsDao {
	
	//获取所有学生信息
	public List<Student> getAllStudent(){
		
	    
		List<Student> list = new ArrayList<Student>();
		String sql = "select `Snum`,`Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student ";
		//String sql = "select `Snum`,`Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student ";
		
		try {
			Dbutil dbutil = new Dbutil();
			Connection conn=dbutil.getCon();
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
		System.out.println(Snum);
		Student stu = new Student();
	
		//String sql = "select `Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student where `Snum`=?";
		String sql = "select * from student where `Snum`=?";
		
		try {
			Dbutil dbutil = new Dbutil();
			Connection conn=dbutil.getCon();
			PreparedStatement ptmt=conn.prepareStatement(sql);
			ptmt.setString(1, Snum);
			//ResultSet rs=ptmt.executeQuery(sql);
			
			ResultSet rs=ptmt.executeQuery();
			System.out.println(rs);
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
				System.out.println(stu.getSname());
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
		}
/*	@Override
	//添加学生
	public int addStudent(Student student) {
		int row = 0;
		String sql = "insert into student(`id`,`name`,`age`,`sex`,`gradeId`,`profile`) values(?,?,?,?,?,?)";
		Object[] params = {student.getId(),student.getName(),student.getAge(),student.getSex(),student.getGradeId(),student.getProfile()};
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("增加学生成功");
		}else{
			System.out.println("增加学生失败");
		}
		return row;
	}

	@Override
	//删除学生
	public int delStudent(Student student) {
		int row = 0;
		String sql = "delete from student where `id`=?";
		Object[] params = {student.getId()};
		row = this.executeUpdateSQL(sql, params);
		if(row>0){
			System.out.println("删除学生成功");
		}else{
			System.out.println("删除学生失败");
		}
		return row;
	}*/

	
	
	
	/*
	//查找指定的学生存在不存在
	public boolean findStudent(Student student){
		boolean flag = true;
		int row = 0;
		Dbutil dbutil = new Dbutil();
		
		
		String sql = "update student set `Sname`=?,`Ssex`=?,`Sbirth`=?,`Email`=? where `Snum`=?";
		try {
			while(rs.next()){
				row = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		if(row>0){
			System.out.println("此学生已经存在");
			flag = true;
		}else{
			System.out.println("没有这个学生");
			flag = false;
		}
		
		return flag;
		
	}*/

	

}
