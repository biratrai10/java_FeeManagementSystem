/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.fees.util;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class DBConnection {
    public static Connection getConnection()
    {
        final String username="root";
        final String password="toor";
        final String url="jdbc:mysql://localhost:3306/feesmgmt";
        try{
            		//Load the Drivername
            Class.forName("com.mysql.jdbc.Driver");
            		//connect to the database
            Connection con=DriverManager.getConnection(url,username,password);
        return con;
        }
        catch(Exception ex)
        {
            System.out.println(ex);
        }
        return null;
    }
}
