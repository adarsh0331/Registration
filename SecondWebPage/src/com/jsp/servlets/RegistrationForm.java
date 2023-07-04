package com.jsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

@WebServlet("/RegistrationForm")
public class RegistrationForm  extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		 String name=req.getParameter("name");
		 String mb=req.getParameter("mb");
		 String email=req.getParameter("email");
		 String password=req.getParameter("password");
		 String gender=req.getParameter("gender");
		 String course=req.getParameter("select");
		 String terms=req.getParameter("check");
		 
		 PrintWriter writer=resp.getWriter();
		 
		 if (terms!=null) {
			 
		
		 String url="jdbc:mysql://localhost:3306/teca43?user=root&password=12345";
		 String insert="insert into userinformation(name, mobileno, email, password,gender,course,terms)"+"values(?,?,?,?,?,?,?)";
			
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			
			PreparedStatement ps=connection.prepareStatement(insert);

			ps.setString(1, name);
			ps.setString(2, mb);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.setString(5, gender);
			ps.setString(6, course);
			ps.setString(7, terms);
				
			int num=ps.executeUpdate();
			
			if (num>0) {
				
			RequestDispatcher dispatcher=	req.getRequestDispatcher("Login.html");
			dispatcher.include(req, resp);
				
			} else {
				
				RequestDispatcher dispatcher=	req.getRequestDispatcher("Registration.html");
				dispatcher.include(req, resp);
                
				writer.println("invalid details");
				
			}
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
		 else {
			 writer.println("accept terms and conditions");
		 }
			
		
	}

}
