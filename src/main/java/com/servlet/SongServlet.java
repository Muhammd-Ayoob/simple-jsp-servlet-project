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
 * Servlet implementation class SongServlet
 */
@WebServlet("/SongServlet")
public class SongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SongServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String title= request.getParameter("title");
		
		String artist= request.getParameter("artist");
		
		String date= request.getParameter("date");
		
		
		Song song= new Song();
		
		song.setTitle(title);
		
		song.setArtist(artist);
		
		song.setReleaseDate(date);
		
		SongDaoImpl daoImpl= new SongDaoImpl();
		
		daoImpl.addSong(song);
		
		PrintWriter out=response.getWriter();
		
		out.println("<script type=\"text/javascript\">");
		
        out.println("alert('SONG ADDED SUCCESSFULLY');");
        
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
