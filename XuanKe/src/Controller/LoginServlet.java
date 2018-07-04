package Controller;

import bean.*;

import service.StudentDao;
import service.TeacherDao;
import service.loginDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
@WebServlet("/LoginServlet")
public class LoginServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String type=request.getParameter("type");
        String id=request.getParameter("id");
        String psw=request.getParameter("psw");
        if(type=="1"||type.equals("1")){
            try {
                Student(id,psw,request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        else{
            try {
                Teacher(id,psw,request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    public void Student(String id,String psw,javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws ServletException, IOException, SQLException {
        loginDao dao=new loginDao();
        System.out.println("Student---------------1111");
        boolean b=dao.checkS(id,psw);
        System.out.println(" bbb"+b);
        if(b) {
        	
        	Student student = new Student();
    		StudentDao stuDao = new StudentDao();
        	String Snum = request.getParameter("id");
        	System.out.println(request.getParameter("id")+"snum");
        	student = stuDao.getStudentMoreInfo(Snum);
        	request.setAttribute("Snum", Snum);
			request.setAttribute("Sname", student.getSname());
			request.setAttribute("Ssex",student.getSsex() );
			request.setAttribute("Sbirth",student.getSbirth() );
			request.setAttribute("Clnum",student.getClnum() );
			request.setAttribute("Email",student.getEmail() );
			request.setAttribute("Status",student.getStatus() );
			System.out.println("1性别:"+student.getSsex());
			System.out.println("2姓名:"+student.getSname());
			
        	
            System.out.println("success---------------");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        else
            request.getRequestDispatcher("/login.jsp").forward(request, response);


    }

    public void Teacher(String id,String psw,javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws SQLException, ServletException, IOException {
        loginDao dao=new loginDao();
        boolean b=dao.checkT(id,psw);
        System.out.println("bbbb--------------"+b);
        if(b){
           TeacherDao dao1=new TeacherDao();
          List list= dao1.queryT(id);
            System.out.println("teacher-------------"+list);
           request.setAttribute("list",list);

            request.getRequestDispatcher("/teacher.jsp").forward(request, response);}
        else
            request.getRequestDispatcher("/login.jsp").forward(request, response);
    }
}
