package Controller;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.Student;
import service.StudentDao;


/**
 * Servlet implementation class updateStu
 */
//@WebServlet("/updateStu")
public class updateStu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateStu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
	 
		 
		StudentDao studentsDao = new StudentDao();
		String Snum = request.getParameter("Snum");
		Student student =studentsDao.getStudentMoreInfo(Snum);
		System.out.println("88---------:"+student);
		System.out.println("88:"+Snum);
		String Sname = request.getParameter("Sname");
		System.out.println("88888:"+Sname);
		String Ssex = request.getParameter("Ssex");
		String Sbirth = request.getParameter("Sbirth");
		String Clnum = request.getParameter("Clnum");
		String Email = request.getParameter("Email");
		String Status = request.getParameter("Status");
		student.setSnum(Snum);
		System.out.println("99:"+student.getSnum());
		student.setSname(Sname);
		student.setSsex(Ssex);
		student.setClnum(Clnum);
		student.setEmail(Email);
		student.setSbirth(java.sql.Date.valueOf(Sbirth));
		student.setStatus(Status);
		//student = studentsDao.getStudentMoreInfo(Snum);
		studentsDao.modifyStudent(student);
		Student student1=studentsDao.getStudentMoreInfo(Snum);
    	request.setAttribute("Snum", Snum);
		request.setAttribute("Sname", student1.getSname());
		request.setAttribute("Ssex",student1.getSsex() );
		request.setAttribute("Sbirth",student1.getSbirth() );
		request.setAttribute("Clnum",student1.getClnum() );
		request.setAttribute("Email",student1.getEmail() );
		request.setAttribute("Status",student1.getStatus() );
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		
	}

}
