package Controller;

import bean.Teacher;
import service.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "updateTeacherServlet")
public class updateTeacherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String Tnum=request.getParameter("Tnum");
        String Tname=request.getParameter("Tname");
        String Tsex=request.getParameter("Tsex");
        String Title=request.getParameter("Title");
        String Tphone=request.getParameter("Tphone");
        String Email=request.getParameter("Email");

      String Tbirth =request.getParameter("Tbirth");

        String psw=request.getParameter("psw");
        TeacherDao dao=new TeacherDao();
        Teacher teacher= null;

        try {
            System.out.println("teacher--laTnum----------"+Tnum);
            teacher = dao.query(Tnum);
            System.out.println("teacher--laallala-----------"+teacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }


        teacher.setPasswd(psw);
        teacher.setTbirth(java.sql.Date.valueOf(Tbirth));
        teacher.setEmail(Email);
        teacher.setTphone(Tphone);
        teacher.setTitle(Title);
        teacher.setTsex(Tsex);
        teacher.setTname(Tname);
        boolean b= false;
        try {
            b = dao.updateTeacher(teacher);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("bbbbbb---------"+b);
        if(b){

        List list= dao.queryT(Tnum);
        System.out.println("teacher-------------"+list);
        request.setAttribute("list",list);
            request.setAttribute("Tnum",Tnum);
        request.getRequestDispatcher("/teacher.jsp").forward(request, response);}
        else{
            request.getRequestDispatcher("/updateTeacher.jsp").forward(request, response);
        }


    }
}
