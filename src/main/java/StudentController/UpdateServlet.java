package StudentController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDaoClass.StudentDao;
import Studentdto.Student;

public class UpdateServlet  extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		int id=Integer.parseInt(req.getParameter("id"));
		String name=req.getParameter("name");
		String address =req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
	
	
	     Student student=new Student();
	     student.setName(name);
	     student.setPassword(password);
	     student.setEmail(email);
         student.setAddress(address);
         student.setPhone(phone);
         
         
         StudentDao d= new StudentDao();
         Student dbStudent=d.updateStudent(id,student);
         if(dbStudent!=null)
         {
        	 PrintWriter pw=resp.getWriter();
        	 pw.print("Data update sucessfully");
         }
         else
         {
        	 PrintWriter pw=resp.getWriter();
        	 pw.print("Sorry your id is not be present");
         }
	
	}
}
