package servlets;

import dao.BookDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Book;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/book/search")
public class BookSearchServlet extends HttpServlet {
    private BookDAO bookDAO = new BookDAO(); // твой DAO

    public BookSearchServlet() throws SQLException, ClassNotFoundException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String query = req.getParameter("q"); // получаем значение из формы
        List<Book> books;

        if (query == null || query.trim().isEmpty()) {
            try {
                books = bookDAO.getAllBook();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            try {
                books = bookDAO.searchBooks(query);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }

        req.setAttribute("list", books);
        req.setAttribute("searchQuery", query); // чтобы текст оставался в поле
        req.getRequestDispatcher("/jsp/books.jsp").forward(req, resp);
    }
}

