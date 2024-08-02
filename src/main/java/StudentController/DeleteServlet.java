package StudentController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDaoClass.StudentDao;
import Studentdto.Student;

public class DeleteServlet  extends HttpServlet
{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		
		StudentDao d= new StudentDao();
		Student student=d.deleteStudent(id);
		PrintWriter pw=resp.getWriter();
		if(student!=null)
		{
			pw.print("data deleted ");
		}
		else 
		{
			pw.print("sorry id is not be present");
		}
	}
}
