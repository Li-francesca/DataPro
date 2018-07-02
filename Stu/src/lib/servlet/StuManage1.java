package lib.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import lib.Dao.CourseDao;
import lib.Dao.Dbutil;
import lib.Dao.StudentsDao;
import lib.Dao.UserDao;
import lib.Model.Course;
import lib.Model.Student;
import lib.Model.User;

/**
 * Servlet implementation class StuManage1
 */

//@WebServlet(urlPatterns ="/StuManage1",name="StuManage1")
public class StuManage1 extends HttpServlet {
	 
	private static final long serialVersionUID = 1L;
       
   
    public StuManage1() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		super.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Dbutil dbutil = new Dbutil();
		Student student = new Student();
		//UserDao userDao = new UserDao();
		StudentsDao stuDao = new StudentsDao();
		//CourseDao coursedao = new CourseDao();
    	String Snum = request.getParameter("Snum");
        String Passwd = request.getParameter("Passwd");
        
        
        /*request.setAttribute("Snum", Snum);
        request.setAttribute("password", password);
        request.setAttribute(arg0, arg1);*/
        if (Snum!=null && !Snum.equals("")) {
        	/*student.setSnum(Snum);
            student.setPasswd(Passwd);*/
            if (true) {//`Sname`,`Ssex`,`Sbirth`,`Clnum`,`Email`,`Status` from student where `Snum`=?";
            	student = stuDao.getStudentMoreInfo(Snum);
            	request.setAttribute("Snum", Snum);
    			request.setAttribute("Sname", student.getSname());
    			request.setAttribute("Ssex",student.getSsex() );
    			request.setAttribute("Sbirth",student.getSbirth() );
    			request.setAttribute("Clnum",student.getClnum() );
    			request.setAttribute("Email",student.getEmail() );
    			request.setAttribute("Status",student.getStatus() );
    			System.out.println(student.getSsex());
    			System.out.println(student.getSname());
    			/*request.setAttribute("Email",student.getEmail() );
    			request.setAttribute("nid", String.valueOf(n.getNid()));*/
            	
            	//List<Student> list = new ArrayList<Student>();
            	/*student = stuDao.getStudentMoreInfo(student);
            	List<Course> courses = new ArrayList<Course>();
            	courses = coursedao.getAllCourse();*/
            	//request.setAttribute("courses", courses);
    			request.getRequestDispatcher("/index.jsp").forward(request, response);
            	//response.sendRedirect("/student/index.jsp");
			}else {
				response.sendRedirect("/signout.jsp");
			}
           /* if(uerService.findUser(user)){//存在这个用户，可以正常访问学生信息
				request.getSession().setAttribute("user", user);
				//response.sendRedirect("/Student/pages/stuList.jsp");
				response.sendRedirect("../NewsServlet");
				 //request.getRequestDispatcher("../NewsServlet").forward(request, response);
			}else{//不存在这个用户，给出提示，转回登录页面
				String message = "用户名或密码错误";
				request.getSession().setAttribute("msg", message);
				response.sendRedirect("/Student/login.jsp");
			}
            */
        	
    		//request.getRequestDispatcher("student/index.jsp").forward(request, response);
    		
		}	
       /* if (Snum == null || password.isEmpty()){
        	request.setAttribute("error", "该生不存在!");
        	request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        User user = new User(Snum, password);
        Connection con = null;
        try {
            con = dbutil.getCon();
            User currentUser = userDao.signin(con, user);
            if (currentUser == null){
            	request.setAttribute("error", "用户名或密码错误！");
            	request.getRequestDispatcher("index.jsp").forward(request, response);
            }
            else {
                HttpSession session = request.getSession();
                session.setAttribute("currentUser", currentUser);
                if (currentUser.getRole() == 0) {
                    response.sendRedirect("admin/index.jsp");
                } else if (currentUser.getRole() == 1){
                    response.sendRedirect("teacher/index.jsp");
                } else {
                    response.sendRedirect("student/index.jsp");
                }
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            try {
                dbutil.closeCon(con);
            } catch (Exception e){
                e.printStackTrace();
            }
        }*/
    }
	

}


