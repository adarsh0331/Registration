package com.jsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/ForgetPassword")
public class ForgetPassword extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("pass");
		
		String url="jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		 String update=" update userinformation  set password=?  where email=?";
		
		
		
		try {
			
		Class.forName("com.mysql.jdbc.Driver");
		Connection connection =	DriverManager.getConnection(url);
		PreparedStatement ps=connection.prepareStatement(update);
		
		ps.setString(1, password);
		ps.setString(2, email);
		
	    int num= ps.executeUpdate();
	    
	    PrintWriter writer=res.getWriter();
	    
	    
	    
	    if(num>0) {
	    	writer.println("password changed successfully");
	    }
	    else {
	    	writer.println("invalid details");

	    }
		
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
