package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

//DB connection class to connect java to databse
public class DbConnection {

	public static Connection getConnection()
    {
         Connection con=null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            
           con=DriverManager.getConnection("jdbc:mysql://localhost:3306/songs_management", "root", "admin");
          
        }
        catch(Exception e)
        {
            e.printStackTrace();
            
        }
   return con;
    
    }
}
