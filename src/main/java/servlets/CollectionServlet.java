package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Book;
import models.User;
import services.BookService;
import services.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/collection")
public class CollectionServlet extends HttpServlet {
    private BookService bookService;
    private UserService userService;

    public void init(ServletConfig config) {
        try {
            this.bookService = new BookService();
            this.userService = new UserService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Book> list = null;

        HttpSession session = req.getSession();

        User user = (User) session.getAttribute("user");

        try {
            list = userService.getBooksByUser(user.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        req.setAttribute("list", list);
        req.getRequestDispatcher("/jsp/collection.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookId = req.getParameter("bookId");

        User user = (User) req.getSession().getAttribute("user");

        long userId = user.getId();

        bookService.deleteBookByUser(userId, Long.parseLong(bookId));

        resp.sendRedirect(req.getContextPath() + "/collection");
    }
}
