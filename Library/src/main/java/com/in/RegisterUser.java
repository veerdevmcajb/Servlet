package com.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.http.HttpClient;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;

@WebServlet("/register")
public class RegisterUser extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String userName = req.getParameter("username");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		PrintWriter out = resp.getWriter();
		
		// Validation
//        if(userName == null || userName.trim().isEmpty()
//                || email == null || email.trim().isEmpty()
//                || password == null || password.trim().isEmpty()) {
//
//            resp.getWriter().print("All fields are required");
//            return;
//        }

		try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con =
                    (Connection) DriverManager.getConnection(
			        "jdbc:mysql://localhost:3306/school",
			        "root",
			        "root12");

            PreparedStatement ps =
                    ((java.sql.Connection) con).prepareStatement(
                            "insert into users(username,email,password) values(?,?,?)");

            ps.setString(1, userName);
            ps.setString(2, email);
            ps.setString(3, password);

            int result = ps.executeUpdate();
            
            if(result > 0) {
            	
            	resp.getWriter().print("Registration Successful..!");
            	
                resp.sendRedirect("index.html");
            } else {
            	resp.getWriter().print("Registration Failed");
            }

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
		
	}

}
