package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Course;
import service.CourseDao;


//@WebServlet("/SelectServlet")
public class SelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SelectServlet() {
        super();
     
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Course course = new Course();
		CourseDao coursedao = new CourseDao();
		String Cnum=request.getParameter("cnum");
    	String Snum = request.getParameter("Snum");
       
        List<Course> courses = new ArrayList<>();
        if (Snum!=null && !Snum.equals("")) {
        	
            if (true) {//`Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student where `Snum`=?";
            	courses = coursedao.getAllCourse();
            	System.out.println("=====++++"+courses.size());
            	request.setAttribute("courses", courses);
            	request.setAttribute("Snum", Snum);
            	
    			request.getRequestDispatcher("/Select.jsp").forward(request, response);
            	
			}else {
				response.sendRedirect("/signout.jsp");
			}
          
		}	
	}

}
