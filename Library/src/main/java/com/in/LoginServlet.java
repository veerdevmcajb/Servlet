package com.in;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException {
	
	String email = req.getParameter("email");
	String password = req.getParameter("password");
	
	 // Validation
    if(email == null || email.trim().isEmpty()
            || password == null || password.trim().isEmpty()) {

        resp.getWriter().print("Email and Password are required");
        return;
    }
	
	try {
	
	Class.forName("com.mysql.cj.jdbc.Driver");
	
	Connection con =
	        (Connection) DriverManager.getConnection(
	        "jdbc:mysql://localhost:3306/school",
	        "root",
	        "root12");

	PreparedStatement ps = ((java.sql.Connection) con).prepareStatement("select * from users where email=? and password=?");
	
	ps.setString(1, email);
	ps.setString(2, password);
	
	ResultSet rs = ps.executeQuery();
	
	if(rs.next()) {
	
	    resp.sendRedirect("dashboard.html");
	
	} else {
	
	    resp.getWriter().print("Invalid Email or Password");
	
	}
	
	con.close();
	
	} catch (Exception e) {
	e.printStackTrace();
	}

	}
	}
