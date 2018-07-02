package lib.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lib.Dao.StudentsDao;
import lib.Model.Student;

/**
 * Servlet implementation class updateStu
 */
@WebServlet("/updateStu")
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
		Student student = new Student();
		StudentsDao studentsDao = new StudentsDao();
		String Snum = request.getParameter("Snum");
		
		String Sname = request.getParameter("Sname");
		String Ssex = request.getParameter("Ssex");
		//SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String Sbirth = request.getParameter("Sbirth");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date Sbirthdate = null;
		try {
			Sbirthdate = sdf.parse(Sbirth);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//news.setNmodifydate(format.format(new Date()));
		
		String Clnum = request.getParameter("Clnum");
		String Email = request.getParameter("Email");
		String Status = request.getParameter("Status");
		
		student.setSname(Sname);
		student.setSsex(Ssex);
		student.setClnum(Clnum);
		student.setEmail(Email);
		student.setSbirth(Sbirthdate);
		student.setStatus(Status);
		boolean data = true;
		int i = studentsDao.modifyStudent(student);
		if (i > 0) {
			data = true;
			student = studentsDao.getStudentMoreInfo(Snum);
        	request.setAttribute("Snum", Snum);
			request.setAttribute("Sname", student.getSname());
			request.setAttribute("Ssex",student.getSsex() );
			request.setAttribute("Sbirth",student.getSbirth() );
			request.setAttribute("Clnum",student.getClnum() );
			request.setAttribute("Email",student.getEmail() );
			request.setAttribute("Status",student.getStatus() );
		} else {
			data = false;
		}
		request.getRequestDispatcher("/index.jsp").forward(request, response);
		/*Page<News> page=new Page(request,response);
		NewServices newServices = new NewsServiceImol();
		News news = new News();
	
		String nid = request.getParameter("nid");
		String[] ntids = request.getParameterValues("ntid");
		String ntitle = request.getParameter("ntitle");
		String ntname = request.getParameter("ntname");
		String nauthor = request.getParameter("nauthor");
	
		String ncontent = request.getParameter("ncontent");
	
		
		if (ntids != null) {
			for (String ntid : ntids) {
				news.setNtid(ntid);
			}
		}
		
		news.setNid(nid);
		
		news.setNtitle(ntitle);
		news.setNtname(ntname);
		news.setNauthor(nauthor);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		news.setNmodifydate(format.format(new Date()));
	
		news.setNcontent(ncontent);
		
		boolean data = true;
		int i = newServices.upadte(news);
		if (i > 0) {
			data = true;
		} else {
			data = false;
		}
		System.out.println("updateNews");
		try {
			page = newServices.pageQuery(page);
			System.out.println("更新分页");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//request.setAttribute("page", page);
		
	}

}
