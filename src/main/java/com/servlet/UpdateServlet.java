package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.daoimpls.SongDaoImpl;
import com.models.Song;

/**
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String sId= request.getParameter("id");
		
		Integer id = Integer.parseInt(sId);
		
		String title= request.getParameter("title");
		
		String artist= request.getParameter("artist");
		
		String date= request.getParameter("date");
		
		Song song= new Song();
		
		song.setId(id);
		
		song.setTitle(title);
		
		song.setArtist(artist);
		
		song.setReleaseDate(date);
		
		SongDaoImpl daoImpl=new SongDaoImpl();
		
		daoImpl.updateSong(song);
		
PrintWriter out=response.getWriter();
		
		out.println("<script type=\"text/javascript\">");
		
        out.println("alert('SONG UPDATED SUCCESSFULLY');");
        
        out.println("window.location.href = \"Songs.jsp\";");
        
        out.println("</script>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
