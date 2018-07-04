package service;

import Db.Dbutil;
import bean.Student;
import bean.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDao {
    public boolean checkS(String id,String psw) throws SQLException {
        System.out.println("psw----------"+psw);
        StudentDao dao=new StudentDao();
        Student s=dao.queryS(id);
        if(s==null){
            System.out.println("null----------");
            return false;
        }
        else{
        String psw1=s.getPasswd();
            System.out.println(psw1+"n----------");
        if(psw1==psw||psw.equals(psw1)){
            return true;
        }
        else {
            return false;
        }

    }
    }


    public boolean checkT(String id,String psw) throws SQLException {
        System.out.println("psw----------"+psw);
        StudentDao dao=new StudentDao();
       Teacher t=dao.queryT(id);
        if(t==null){
            System.out.println("null----------");
            return false;
        }
        else {
            String psw1 = t.getPasswd();
            System.out.println(psw1 + "n----------");
            if (psw1 == psw || psw.equals(psw1)) {
                return true;
            } else {
                return false;
            }

        }}
}
