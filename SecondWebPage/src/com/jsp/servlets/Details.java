package com.jsp.servlets;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/Details")
public class Details  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	String name=req.getParameter("name");
	String mobilenumber=req.getParameter("mb");
	String email=req.getParameter("email");
		
		System.out.println("name :"+name);
		System.out.println("mobileno :"+mobilenumber);
		System.out.println("email :"+email);
		
	}                                                                                                          

}
