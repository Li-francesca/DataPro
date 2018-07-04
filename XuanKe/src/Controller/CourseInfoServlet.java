package Controller;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.Dao;
import bean.KKXX;
import bean.XKXQ;

/**
 * Servlet implementation class CourseInfoServlet
 */
@WebServlet("/CourseInfoServlet")
public class CourseInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String flag=request.getParameter("flag");
		switch(flag){
		  case "kkxx":
			  kkXx(request,response);
			  break;
		  case "xkxq":
			  XKXQ(request,response);
			  break;
		  case "doGrade":
			  doGrade(request,response);
			  break;
		}
		
    }

	private void doGrade(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String glist=request.getParameter("");//得到分数集
		String snum=request.getParameter("");//得到学生学号集合
		String cnum=(String) request.getSession().getAttribute("cmun");
		String[] num=snum.split(",");
		String[] g=glist.split(",");
		new Dao().doGrade(g, num, cnum);
		List<XKXQ> xkxqs=new Dao().findXkxq("1");
		request.setAttribute("xkxqs", xkxqs);
		request.getRequestDispatcher("courstu.jsp").forward(request,response);
	}

	private void XKXQ(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<XKXQ> xkxqs=new Dao().findXkxq("1");
		request.setAttribute("xkxqs", xkxqs);
		request.getRequestDispatcher("courstu.jsp").forward(request,response);
	}

	private void kkXx(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<KKXX> kkxxlist=new Dao().findKkxx("11");
		request.setAttribute("kkxxlist", kkxxlist);
		request.getRequestDispatcher("courseinfor.jsp").forward(request,response);
	}

}
