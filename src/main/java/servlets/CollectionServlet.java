package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Book;
import services.BookService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/collection")
public class CollectionServlet extends HttpServlet {
    private BookService bookService;

    public void init(ServletConfig config) {
        try {
            this.bookService = new BookService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Book> list = bookService.getAllBook();
            req.setAttribute("list", list);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
        req.getRequestDispatcher("/jsp/collection.jsp").forward(req,resp);
    }
}
