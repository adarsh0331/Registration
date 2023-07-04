package com.jsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/RuntimeDetails")
public class RuntimeDetails extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp ) throws ServletException, IOException {
		String name= req.getParameter("name");
		String mb= req.getParameter("mb");
		String email= req.getParameter("email");
		String select= req.getParameter("select");
		String gender= req.getParameter("gender");
	
		
		String url="jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		String insert="insert into runtimedetails(Name, EmailId, MobileNumber, Course,Gender)"+"values(?,?,?,?,?)";
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(insert);
			ps.setString(1, name);
			ps.setString(2, mb);
			ps.setString(3, email);
			ps.setString(4, select);
			ps.setString(5, gender);
			
			
			int num=ps.executeUpdate();
			
			PrintWriter writer=resp.getWriter();
			resp.setContentType("text/html");
			
			if (num>0) {
				writer.println("<h1><center>Registration successful</center></h1>");
			} else {
				writer.println("Invalid details");
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
