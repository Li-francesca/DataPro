package lib.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import lib.Dao.StudentsDao;
import lib.Model.Student;

/**
 * Servlet implementation class UpStuServlet
 */
//@WebServlet("/UpStuServlet")
public class UpStuServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpStuServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		Student student = new Student();
		StudentsDao studentsDao = new StudentsDao();
		String Snum = request.getParameter("Snum");
		
		student = studentsDao.getStudentMoreInfo(Snum);
		
		
    	request.setAttribute("Snum", Snum);
		request.setAttribute("Sname", student.getSname());
		request.setAttribute("Ssex",student.getSsex() );
		request.setAttribute("Sbirth",student.getSbirth() );
		request.setAttribute("Clnum",student.getClnum() );
		request.setAttribute("Email",student.getEmail() );
		request.setAttribute("Status",student.getStatus() );
		System.out.println("------------------------");
		System.out.println(student.getSsex());
		System.out.println(student.getSname());
		/*
		request.setAttribute("nid", String.valueOf(news.getNid()));
		request.setAttribute("ntid", String.valueOf(news.getNtid()));
		request.setAttribute("ntname", String.valueOf(news.getNtname()));
		request.setAttribute("ntitle", news.getNtitle());
		//request.setAttribute("ncontent", news.getNcontent());
		request.setAttribute("nauthor", news.getNauthor());
		request.setAttribute("ncreatedate", news.getNcreatedate());
		//request.setAttribute("npicPath", news.getNpicpath());
		request.setAttribute("ncontent", news.getNcontent());*/
		request.getRequestDispatcher("/student/updateStu.jsp").forward(request, response);//跳转到更新页面 
	}

	}


