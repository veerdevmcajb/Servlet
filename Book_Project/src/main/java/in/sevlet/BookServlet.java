package in.sevlet;

import in.dao.BookDAO;
import in.dto.BookDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/bookServlet")
public class BookServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {

            // capture form data
            String id = req.getParameter("bookId");
            String name = req.getParameter("bookName");
            String price = req.getParameter("bookPrice");

            int bookId = Integer.parseInt(id);
            double bookPrice = Double.parseDouble(price);

            BookDTO dto = new BookDTO();
            dto.setBookId(bookId);
            dto.setBookName(name);
            dto.setBookPrice(bookPrice);

            // call DAO method by giving form data
            BookDAO dao = new BookDAO();
            boolean status = dao.saveBook(dto);

            // send response to client

            String response = null;
            if (status) {
                response = "Record Inserted ";
            } else {
                response = " Insertion Failed ";
            }

            PrintWriter pw = resp.getWriter();
            pw.append(response);

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
