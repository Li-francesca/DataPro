package Controller;

import bean.Teacher;
import service.StudentDao;
import service.TeacherDao;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;


@WebServlet(name = "AcademyMessageServlet ")
public class AcademyMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String idA=request.getParameter("idA");
        String name=request.getParameter("name");
        String Tnum=request.getParameter("Tnum");
        String Anum=request.getParameter("Anum");
        StudentDao dao1=new StudentDao();
        Teacher teacher=new Teacher();
        try {
            teacher=dao1.queryT(Tnum);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String psw=teacher.getPasswd();
        TeacherDao dao=new TeacherDao();

        List listD=dao.charge(idA);

     
        request.setAttribute("list",listD);
    
        request.setAttribute("name",name);
        request.setAttribute("psw",psw);
        request.setAttribute("Tnum",Tnum);
        request.setAttribute("Anum",Anum);


        request.getRequestDispatcher("/academyMessage.jsp").forward(request, response);
    }
}
