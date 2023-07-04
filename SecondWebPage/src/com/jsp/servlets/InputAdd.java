package com.jsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/InputAdd")
public class InputAdd  extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse resp) throws ServletException, IOException {
		String a=req.getParameter("a");
		int num= Integer.parseInt(a);
		String b=req.getParameter("b");
		int num1= Integer.parseInt(b);
		
		
	    int sum=num+num1;
	    
	    

		PrintWriter writer= resp.getWriter();
	    writer.println( sum);
		
		
	}
	

}
