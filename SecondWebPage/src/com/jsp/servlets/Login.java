package com.jsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Login")
public class Login extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		 String url="jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		 String select=" select* from userinformation where email=? and password=?";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			 PreparedStatement ps= connection.prepareStatement(select);
			 ps.setString(1, email);
			 ps.setString(2, password);
			 
			 
			ResultSet rs= ps.executeQuery();
			
			PrintWriter writer=resp.getWriter();
			
			if (rs.next()) {
				
				Random r=new Random();
				int otp=r.nextInt(10000);
				if( otp<1000) {
					otp+=1000;
					
				}
				writer.println("your otp is:"+otp);
				
			} else {
				writer.println("invalid details");

			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
 
}
