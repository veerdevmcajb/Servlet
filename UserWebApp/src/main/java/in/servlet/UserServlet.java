package in.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.dao.UserDAO;
import in.dto.UserDTO;

@WebServlet("/user")
public class UserServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDAO userDao= new UserDAO();
		List<UserDTO> users= userDao.getUsers();
		
		req.setAttribute("users", users);
		
		req.getRequestDispatcher("/viewUsers.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// capture form data
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String phno = req.getParameter("phono");
		
		// set form data into userDto object
		
		UserDTO users = new UserDTO();	
		users.setUsername(name);
		users.setEmail(email);
		users.setPhoNo(Long.parseLong(phno));
		
		// call dao method 
		UserDAO dao = new UserDAO();
		//boolean isSaved = dao.saveUser(users);
		boolean isSaved = dao.saveUser(users);
	
		String msg=null;
		
		if(isSaved) {
			msg ="Saved";
		}else {
			msg ="Not Saved";
		}
		
		req.setAttribute("msg", msg);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}
 
}

//411041
