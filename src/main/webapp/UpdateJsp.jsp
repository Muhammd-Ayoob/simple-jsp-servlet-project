<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
    <%@ page import="com.daoimpls.SongDaoImpl" %>
    
    <%@ page import="com.models.Song" %>
    
    <%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update jsp</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
		<h1 class="text-center">SONGS DETAILS</h1>
		
		<%
		SongDaoImpl daoImpl= new SongDaoImpl(); 
		
		String sId= request.getParameter("id");
		
		Integer id= Integer.parseInt(sId);
		
		Song song1 =daoImpl.getById(id);
		
		System.out.println(song1.getTitle());
		
		%>

		<div class="container">
			<form action="UpdateServlet">
			
				 <input type="hidden" id="id" name="id" value="<%=song1.getId() %>">
			
			
				  <div class="form-group">
				    <label for="exampleInputEmail1">SONG TITLE</label>
				    <input type="text" class="form-control" id="title" name="title" aria-describedby="emailHelp" placeholder="ENTER SONG TITLE" value="<%= song1.getTitle() %>">
				    
				  </div>
				  
				  
				  <div class="form-group">
				    <label for="exampleInputEmail1">ARTIST NAME</label>
				    <input type="text" class="form-control" id="artist" name="artist" aria-describedby="emailHelp" placeholder="ENTER ARTIST NAME" value="<%= song1.getArtist() %>">
				  </div>
				  
				  <div class="form-group">
				    <label for="exampleInputPassword1">RELEASE DATE</label>
				    <input type="text" class="form-control" id="date" name="date" placeholder="ENTER SONG RELEASE DATE" value="<%= song1.getReleaseDate() %>">
				  </div>
				  
		
				  <button type="submit" class="btn btn-primary">EDIT</button>
			</form>
				
		</div>
		
		
		<% 
				    		
		List<Song> list=daoImpl.getSongs();		   
	    
		System.out.println(list);
			%>
			
			
<table class="table">
	  <thead>
	    <tr>
	      <th scope="col">#</th>
	      
	      <th scope="col">SONG TITLE</th>
	      
	      <th scope="col">ARTIST NAME</th>
	      
	      <th scope="col">RELEASE DATE</th>
	      
	      <th colspan="2">ACTIONS</th>
	        
	    </tr>
	  </thead>
  <tbody>
  <%for(Song song: list) 
  {%>
    <tr>
      <td><%= song.getId() %></td>
      
      <td><%= song.getTitle() %></td>
      
      <td><%= song.getArtist() %></td>
      
      <td><%= song.getReleaseDate() %></td>
      <%if(song.getId()!=null){ %>
      
   <td><a href='DeleteServlet?id=<%= song.getId() %>' style="text-decoration:none; background-color:red; color:white">delete</a></td>
     
      <td><a href='UpdateJsp.jsp?id=<%= song.getId() %>'style="text-decoration:none; background-color:green; color:white">Update</a></td>
        <%} %>
    </tr>
      
    <%} %>
    
  </tbody>
  
</table>
		
</body>
</html>