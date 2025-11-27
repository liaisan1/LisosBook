package com.bookcollection.servlets;

import com.bookcollection.dao.CollectionDAO;
import com.bookcollection.dao.UserDAO;
import com.bookcollection.models.User;
import com.bookcollection.services.CollectionService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/collection/*")
public class CollectionServlet extends HttpServlet {
    private CollectionService collectionService;

    @Override
    public void init() {
        CollectionDAO collectionDAO = new CollectionDAO();
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
                case "/add":
                    addBookToCollection(request, response, user);
                    break;
                case "/remove":
                    removeBookFromCollection(request, response, user);
                    break;
                default:
                    showCollection(request, response, user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("error", "Ошибка базы данных");
            request.getRequestDispatcher("/WEB-INF/views/collection.jsp").forward(request, response);
        }
    }

    private void showCollection(HttpServletRequest request, HttpServletResponse response, User user)
            throws SQLException, ServletException, IOException {
        // Получаем коллекцию пользователя
        var collection = collectionService.getUserCollection(user.getId());
        request.setAttribute("collection", collection);
        request.getRequestDispatcher("/WEB-INF/views/collection.jsp").forward(request, response);
    }

    private void addBookToCollection(HttpServletRequest request, HttpServletResponse response, User user)
            throws SQLException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));
        String condition = request.getParameter("condition");

        // Добавляем книгу в коллекцию
        collectionService.addBookToCollection(user.getId(), bookId, condition);

        // Возвращаем на предыдущую страницу
        String referer = request.getHeader("Referer");
        response.sendRedirect(referer != null ? referer : request.getContextPath() + "/books");
    }

    private void removeBookFromCollection(HttpServletRequest request, HttpServletResponse response, User user)
            throws SQLException, IOException {
        int bookId = Integer.parseInt(request.getParameter("bookId"));

        // Удаляем книгу из коллекции
        collectionService.removeBookFromCollection(user.getId(), bookId);
        response.sendRedirect(request.getContextPath() + "/collection");
    }
}
