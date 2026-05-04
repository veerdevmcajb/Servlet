package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first")
public class FirstServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	PrintWriter pw	= resp.getWriter();
		pw.append("<h1>This is First Servlet Response</h1>");
		
	RequestDispatcher rd	= req.getRequestDispatcher("/second");
		rd.forward(req, resp); // forWord method will give you final Servlet response
		
		//rd.include(req, resp); // include method will give you all the servlet response
		
		
		
	}

}


// Note : RequestDispatcher is a redirect the request to one resource to another resource.
