package service;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import Db.C3p0Con;
import bean.KKXX;
import bean.XKXQ;

public class Dao {
	Connection conn = C3p0Con.getConnection();
	QueryRunner runner = new QueryRunner();
	
	public List<KKXX> findKkxx(String UUID) {
	    String sql="SELECT course.Cnum,course.Cname,course.Credit,course.Period,academy.Aname,"
	    		+"stucourse.Ynum,stucourse.Term FROM course,stucourse,academy"
	    		+" WHERE stucourse.Tnum=? AND stucourse.Cnum=course.Cnum AND academy.Anum=course.academy";
		try {
			List<KKXX> cresult = runner.query(conn, sql, new BeanListHandler<KKXX>(KKXX.class),UUID);
			return cresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;	
	}
	
	public List<XKXQ> findXkxq(String UUID) {
	    String sql="SELECT student.Clnum,student.Sname,stucourse.Grade FROM student,stucourse WHERE stucourse.Cnum=? AND stucourse.Snum=student.Clnum";
		try {
			List<XKXQ> cresult = runner.query(conn, sql, new BeanListHandler<XKXQ>(XKXQ.class),UUID);
			return cresult;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			C3p0Con.closeConn(conn);
		}
		return null;	
	}
	
	public void doGrade(String[]g,String[]n,String cnum){
		String sql="UPDATE stucourse SET Grade=? WHERE stucourse.Cnum=? AND stucourse.Snum=?";
		try {
			for (int i = 0; i < g.length; i++) {
				Object[] params = {g[i],cnum,n[i]};
				runner.update(conn, sql, params);//此方法有int返回值，可以写成 int r = runner.update(conn, sql, params);接受返回值，可用于测试
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			C3p0Con.closeConn(conn);
		}
	}
}
