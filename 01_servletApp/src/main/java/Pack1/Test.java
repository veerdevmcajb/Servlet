package Pack1;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/test")
public class Test extends HttpServlet {

    public void doGet(HttpServletRequest req , HttpServletResponse res) throws IOException {
       PrintWriter pw = res.getWriter();
       pw.append("<h1>Welcome to Servlet..</h1>");

    }
}
