package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.daoimpls.UserDaoImpl;
import com.models.User;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name= request.getParameter("person1");
		
		String password= request.getParameter("password");
		
		
		
		boolean b=false;
		
		UserDaoImpl daoImpl= new UserDaoImpl();
		
		List<User> list= daoImpl.getUser();
		
		System.out.println(list);
		
		//Iterating all users from database using list with for loop
		for(User user:list)
		{
			
			//Checking condition either user is registered or not
			if(user.getName().equalsIgnoreCase(name) && user.getPassword().equalsIgnoreCase(password))
			{
				
				b=true;
				HttpSession session=request.getSession();
				
				session.setAttribute("name", name);
				
				
				break;
			}
			else {b=false;}
			
		}
		
		//If user name and password are correct, it will go to welcome page
		if(b)
		{response.sendRedirect("Songs.jsp");}
		
		//If user is not in database, it will go to login page
		else {
			PrintWriter out=response.getWriter();
			
			
			out.println("<script type=\"text/javascript\">");
			
            out.println("alert('WRONG USERNAME OR PASSWORD');");
            
            out.println("window.location.href = \"Login.jsp\";");
            
            out.println("</script>");
			
	}
		
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
