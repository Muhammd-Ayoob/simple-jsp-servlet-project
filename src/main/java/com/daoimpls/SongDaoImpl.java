package com.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DbConnection;
import com.models.Song;
import com.models.User;

public class SongDaoImpl {
	
	
	
Connection con = DbConnection.getConnection();	
	
	public void addSong(Song song)
	{
		
		try{
			//Sql query to add data in database
	        String query="insert into songs(title,artist,release_date) values(?,?,?)";
	        
	        PreparedStatement ps=con.prepareStatement(query);
	        
	        if(song.getTitle()!=null)
	        ps.setString(1, song.getTitle() );
	        
	        if(song.getArtist()!=null)
	        ps.setString(2, song.getArtist());
	        
	        if(song.getReleaseDate()!=null)
	        ps.setString(3, song.getReleaseDate());
	        
	        ps.executeUpdate();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }	
	}
	
	
	
	
	
	
	
	
	
	
	public void updateSong(Song song)
	{
		
		try{
			//Sql query to add data in database
	        
	        
	        String query="update songs set title=?,artist=?,release_date=? where id=?";
	        
	        PreparedStatement ps=con.prepareStatement(query);
	        
	        if(song.getTitle()!=null)
	        ps.setString(1, song.getTitle() );
	        
	        if(song.getArtist()!=null)
	        ps.setString(2, song.getArtist());
	        
	        if(song.getReleaseDate()!=null)
	        ps.setString(3, song.getReleaseDate());
	        
	        
	        if(song.getId()!=null)
		     ps.setInt(4, song.getId());
	        
	        ps.executeUpdate();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	public List<Song> getSongs()
	{
		List<Song> list=new ArrayList<>();   
        try
        {
        	//Sql query to fetch all data from database
            String query="select *from songs"; 
            
            PreparedStatement ps=con.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	Song song= new Song();
                
            	song.setId(rs.getInt("id"));
                
            	song.setTitle(rs.getString("title"));
             
            	song.setArtist(rs.getString("artist"));
             
            	song.setReleaseDate(rs.getString("release_date"));
            	
                list.add(song);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}
	
	
	
	
	
	
	
	
	
	public void delete(int id){  
        
        try{  
            PreparedStatement ps=con.prepareStatement("delete from songs where id=?");  
            ps.setInt(1,id);  
            ps.executeUpdate();  
               
        }catch(Exception e){e.printStackTrace();}  
          
    }  
	
	
	
	
	public Song getById(int id)
	{
	   Song song= new Song();
	    
	    try{
	    String query="select *from songs where id=?";
	    
	    PreparedStatement ps=con.prepareStatement(query);
	    
	    ps.setInt(1,id);
	    
	    ResultSet rs=ps.executeQuery();
	    
	    while(rs.next())
	    {
	        
	    	song.setId(rs.getInt("id"));
	        
	    	song.setTitle(rs.getString("title"));
            
        	song.setArtist(rs.getString("artist"));
         
        	song.setReleaseDate(rs.getString("release_date"));
        	
	           
	    }
	    }
	    catch(Exception e)
	    {
	        e.printStackTrace();
	    }
	    return song;
	}
		
	

}
