package StudentController;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import StudentDaoClass.StudentDao;
import Studentdto.Student;

public class LoginSevlet extends HttpServlet
{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException
	{
	
	
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		StudentDao d=new StudentDao();
		List<Student> students =d.getAllStudent();
	
		boolean value=false;
		String dbPassword=null;
		
		for(Student st: students)
		{
			if(email.equals(st.getEmail())) 
			{
			value=true;
			dbPassword=st.getPassword();
			break;
			}
		}	
			if(value) 
			{
				if(password.equals(dbPassword))
				{
//					PrintWriter pw=resp.getWriter();
//					pw.print("Login sucessfully pls Enroll Now ");
				
//				 RequestDispatcher rs=req.getRequestDispatcher("find.html");
//				 rs.forward(req, resp);
//				
					
					resp.sendRedirect("https://www.amazon.in/");
					
				}
				else 
				{
//					PrintWriter pw=resp.getWriter();
//					pw.print("SORRY YOUR PASSWORD IS WRONG CHECK IT NOW");
			        RequestDispatcher rs1=req.getRequestDispatcher("login.html");
			        rs1.include(req, resp);
				}   
				
			
			}
			
			else 
			{
//				PrintWriter pw=resp.getWriter();
//				pw.print("SORRY EMAIL IS WRONG PLS CHECK OUR EMAIL");
			
			
				RequestDispatcher rs2=req.getRequestDispatcher("login.html");
		        rs2.include(req, resp);
			}
			}
	}
	

	

	


		
	
	
	



