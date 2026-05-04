package com.in;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Books")
public class LibraryController extends HttpServlet{
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id=req.getParameter("id");
		String name=req.getParameter("name");
		String price = req.getParameter("price");
		PrintWriter writer = resp.getWriter();
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","root12");
			PreparedStatement pstmt	= con.prepareStatement("insert into books values(?,?,?)");
			pstmt.setString(1, id);
			pstmt.setString(2, name);
			pstmt.setString(3, price);
			
			int result = pstmt.executeUpdate();
			System.out.println("Result "+ result);
			if(result >0) {
				writer.print("Data inserted..!");
			}else {
				writer.print("Error...");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

}
