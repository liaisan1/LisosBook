package servlets;

import dao.BookDAO;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Book;
import models.User;
import services.BookService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/book")
public class BookServlet extends HttpServlet {
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
        List<Book> list = null;
        try {
            list = bookService.getAllBook();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("list", list);
        req.getRequestDispatcher("/jsp/books.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");

        User user = (User) req.getSession().getAttribute("user");

        long userId = user.getId();

        try {
            bookService.setBookByUser(userId, Long.parseLong(bookId));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/book");
    }
}
