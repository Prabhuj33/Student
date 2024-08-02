package StudentController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import StudentDaoClass.StudentDao;
import Studentdto.Student;

public class SigupServlet  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String name=req.getParameter("name");
		String address=req.getParameter("address");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		long phone=Long.parseLong(req.getParameter("phone"));
	
	     Student s =new Student();
	     s.setName(name);
	     s.setAddress(address);
         s.setEmail(email);
         s.setPassword(password);
         s.setPhone(phone);
         
         
         StudentDao d=new StudentDao();
         d.saveStudent(s);
	
	
//         PrintWriter pw=res.getWriter();
//         pw.print("Signup Sucessfully Pls Login Our Pages");
	
	
	    RequestDispatcher rs=req.getRequestDispatcher("login.html");
	    rs.forward(req, res);
	}

}
