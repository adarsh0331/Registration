
package com.jsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/EmployeeDetails")
public class EmployeeDetails extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String name= req.getParameter("name");
		String mb= req.getParameter("mb");
		String email= req.getParameter("email");
		String male= req.getParameter("a");
		String female= req.getParameter("a");
		String others= req.getParameter("a");
		String select= req.getParameter("select");
		String check= req.getParameter("check");
		
		
		
		PrintWriter writer= resp.getWriter();
		
		resp.setContentType("text/html");
		
		writer.println( "<h1 style=color:red >name :"+name+"<h1>");
		writer.println("<h1>mobilenumber:"+mb+"<h1>");
		writer.println("<h1>email:"+email+"<h1>");
		writer.println("<h1>"+male+"<h1>");
		writer.println("<h1>"+female+"<h1>");
		writer.println("<h1>"+others+"<h1>");
		writer.println("<h1>"+select+"<h1>");
		writer.println("<h1>"+check+"<h1>");
		
	}

	
	
}
