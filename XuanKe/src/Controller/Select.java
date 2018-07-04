package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.StuCourse;
import service.StuCourseDao;


/**
 * Servlet implementation class Select
 */
//@WebServlet("/Select")
public class Select extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Select() {
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
		
		
		String Cnum = request.getParameter("cnum");
		System.out.println("成功选课"+"-------"+Cnum);
		String Snum = request.getParameter("snum");
		String Tnum = request.getParameter("tnum");
		System.out.println("成功选课"+"--TTTT-----"+Tnum);
		StuCourse c=new StuCourse();
		c.setCnum(Cnum);
		c.setSnum(Snum);
		c.setTnum(Tnum);
		StuCourseDao dao=new StuCourseDao();
		dao.selectCourse(c);
		System.out.println("成功选课");
		request.setAttribute("Snum", Snum);
	    request.getRequestDispatcher("/success.jsp").forward(request, response);
	
	}

}
