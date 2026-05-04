package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/greet")
public class GreetServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		PrintWriter pw = resp.getWriter();
			pw.append("<h1>Welcome to Web Development </h1>");
			
		PrintWriter out	= resp.getWriter();
		
		LocalTime currentTime = LocalTime.now();
		int hours = currentTime.getHour();
		
		String message;
		
		if(hours >=6 && hours <12) {
			message=" Good Morning";
		}else if(hours >=12 && hours<16) {
			message = "Good Afternoon ";
		}else if(hours >=16 && hours <20) {
			message = "Good Evening";
		}else {
			message=" Good Night";
		}
		
		out.println("<html><body>");
		out.println("<h1>"+ message + "</h1>");
		out.println("<p> Current Time "+ currentTime + "</p>");
		out.println("</body></html>");
		
	}

}
