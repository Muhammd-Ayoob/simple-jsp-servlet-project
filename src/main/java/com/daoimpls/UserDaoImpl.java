package com.daoimpls;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.jdbc.DbConnection;
import com.models.User;

public class UserDaoImpl {
	
	
	Connection con = DbConnection.getConnection();	
	
	public void addUser(User user)
	{
		
		try{
			//Sql query to add data in database
	        String query="insert into user(name,password) values(?,?)";
	        
	        PreparedStatement ps=con.prepareStatement(query);
	        
	        if(user.getName()!=null)
	        ps.setString(1, user.getName() );
	        
	        if(user.getPassword()!=null)
	        ps.setString(2, user.getPassword());
	        
	        ps.executeUpdate();
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }	
	}
	
	
	
	
	
	
	
	
	
	
	
	public List<User> getUser()
	{
		List<User> list=new ArrayList<>();   
        try
        {
        	//Sql query to fetch all data from database
            String query="select *from user"; 
            
            PreparedStatement ps=con.prepareStatement(query);
            
            ResultSet rs=ps.executeQuery();
            
            while(rs.next())
            {
            	User user= new User();
                
              user.setId(rs.getInt("id"));
                
             user.setName(rs.getString("name"));
             
             user.setPassword(rs.getString("password"));
             
              
               list.add(user);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return list;
	}
	

}
