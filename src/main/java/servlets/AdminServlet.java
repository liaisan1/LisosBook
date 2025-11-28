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

@WebServlet("/admin")
public class AdminServlet extends HttpServlet {
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
        req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String action = req.getParameter("action");
        String title = req.getParameter("title");
        String author = req.getParameter("author");
        String publicationYear = req.getParameter("publicationYear");
        String genre = req.getParameter("genre");

        String errorMessage = null;

        if(action == null) {
            errorMessage = "Не выбрано действие";
            req.setAttribute("errorMessage", errorMessage);
            req.getRequestDispatcher("/jsp/admin.jsp").forward(req,resp);
        }

        try {
            switch (action) {
                case "addBook":
                    if(title != null && author!= null && publicationYear != null && genre != null) {
                        Book book = new Book(title, author, Integer.parseInt(publicationYear), genre);
                        bookService.addBook(book);
                    } else {
                        errorMessage = "Поля должны быть заполнены";
                    }
                    break;

                case "deleteBook":
                    if(title != null) {
                        Book book = new Book(title, author, Integer.parseInt(publicationYear), genre);
                        bookService.deleteBook(book);
                    } else {
                        errorMessage = "Название книги не может быть пустым";
                    }
                    break;
                default:
                    errorMessage = "Неизвестное действие";
            }
        }catch (Exception e) {
            e.printStackTrace();
            errorMessage = "Ошибка при выполнении действия:" + e.getMessage();
        }

    }
}
