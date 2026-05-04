package Test;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest req , HttpServletResponse res)
            throws ServletException, IOException {

        String userName = req.getParameter("username");
        String passWord = req.getParameter("password");

        if("admin".equals(userName) && "1234".equals(passWord)){
            res.sendRedirect("welcome.jsp");
        } else {
            res.getWriter().println("Invalid Credentials..!");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}