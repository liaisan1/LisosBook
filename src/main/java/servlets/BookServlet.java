package com.bookcollection.servlets;

import com.bookcollection.dao.BookDAO;
import com.bookcollection.dao.CollectionDAO;
import com.bookcollection.dao.UserDAO;
import com.bookcollection.models.Book;
import com.bookcollection.models.User;
import com.bookcollection.services.BookService;
import com.bookcollection.services.CollectionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/books/*")
public class BookServlet extends HttpServlet {
    private BookService bookService;
    private CollectionService collectionService;

    @Override
    public void init() {
        BookDAO bookDAO = new BookDAO();
        CollectionDAO collectionDAO = new CollectionDAO();
        bookService = new BookService(bookDAO);
        collectionService = new CollectionService(collectionDAO);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Проверяем авторизацию
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
            return;
        }

        User user = (User) session.getAttribute("user");
        String action = request.getPathInfo();

        try {
            if (action == null) action = "";

            switch (action) {
                case "/new":
                    request.getRequestDispatcher("/WEB-INF/views/add-book.jsp").forward(request, response);
                    break;
                case "/edit":
                    showEditForm(request, response, user);
                    break;
                case "/delete":
                    deleteBook(request, response, user);
                    break;
                case "/search":
                    searchBooks(request, response, user);
                    break;
                default:
                    listBooks(request, response, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Ошибка базы данных");
            request.getRequestDispatcher("/WEB-INF/views/books.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session == null || session.getAttribute("user") == null) {
            response.sendRedirect(request.getContextPath() + "/auth/login");
            return;
        }

        String action = request.getPathInfo();

        try {
            if (action == null) action = "";

            switch (action) {
                case "/new":
                    createBook(request, response);
                    break;
                case "/edit":
                    updateBook(request, response);
                    break;
                default:
                    response.sendRedirect(request.getContextPath() + "/books");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect(request.getContextPath() + "/books");
        }
    }

    private void listBooks(HttpServletRequest request, HttpServletResponse response, User user)
            throws SQLException, ServletException, IOException {
        List<Book> books = bookService.getAllBooks();
        request.setAttribute("books", books);
        request.getRequestDispatcher("/WEB-INF/views/books.jsp").forward(request, response);
    }

    private void searchBooks(HttpServletRequest request, HttpServletResponse response, User user)
            throws SQLException, ServletException, IOException {
        String query = request.getParameter("q");
        List<Book> books = bookService.searchBooks(query);
        request.setAttribute("books", books);
        request.setAttribute("searchQuery", query);
        request.getRequestDispatcher("/WEB-INF/views/books.jsp").forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response, User user)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.getBookById(id);
        if (book != null) {
            request.setAttribute("book", book);
            request.getRequestDispatcher("/WEB-INF/views/edit-book.jsp").forward(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/books");
        }
    }

    private void createBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        Book book = new Book();
        book.setTitle(request.getParameter("title"));
        book.setAuthor(request.getParameter("author"));
        book.setIsbn(request.getParameter("isbn"));
        book.setPublicationYear(Integer.parseInt(request.getParameter("publicationYear")));
        book.setGenre(request.getParameter("genre"));

        bookService.createBook(book);
        response.sendRedirect(request.getContextPath() + "/books");
    }

    private void updateBook(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Book book = bookService.getBookById(id);

        if (book != null) {
            book.setTitle(request.getParameter("title"));
            book.setAuthor(request.getParameter("author"));
            book.setIsbn(request.getParameter("isbn"));
            book.setPublicationYear(Integer.parseInt(request.getParameter("publicationYear")));
            book.setGenre(request.getParameter("genre"));

            bookService.updateBook(book);
        }
        response.sendRedirect(request.getContextPath() + "/books");
    }

    private void deleteBook(HttpServletRequest request, HttpServletResponse response, User user)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        bookService.deleteBook(id);
        response.sendRedirect(request.getContextPath() + "/books");
    }
}
