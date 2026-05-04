package in.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import com.mysql.cj.xdevapi.Statement;


import in.dto.UserDTO;
import in.util.ConnectionFactory;

public class UserDAO {
	
	private static final String Insert_Query = "insert into user_details (username,useremail,userphono) values(?,?,?)";

	private static final String Select_Query = "select * from user_details";
	
	public boolean saveUser(UserDTO userDto) {
		boolean isSave = false;
		
		try {
			
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement pstmt = con.prepareStatement(Insert_Query);
			
			pstmt.setString(1,userDto.getUsername());
			pstmt.setString(2, userDto.getEmail());
			pstmt.setLong(3,userDto.getPhoNo());
			
			
			int count = pstmt.executeUpdate();
			
			if(count > 0) {
				
				isSave = true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		return isSave;
	}
	
	
	public List<UserDTO> getUsers(){
		

		List<UserDTO> users = new ArrayList(); 
		
		try {
			Connection con = ConnectionFactory.getConnection();
			
		java.sql.Statement stamt	= con.createStatement();
		
		
	ResultSet rs = stamt.executeQuery(Select_Query);
	
	while(rs.next()) {
		UserDTO user = new UserDTO();
		user.setUserId(rs.getInt("userid"));
		user.setUsername(rs.getString("username"));
		user.setEmail(rs.getString("useremail"));
		user.setPhoNo(rs.getLong("phoneno"));

		users.add(user);
	}
	
	
		
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return users;
	}
}
