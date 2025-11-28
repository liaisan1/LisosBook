package servlets;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.User;
import services.UserService;
import utils.HashUtil;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) throws ServletException {
        try {
            this.userService = new UserService();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        req.getRequestDispatcher("/jsp/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html;charset=UTF-8");

        String username = req.getParameter("username");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        String confirmPassword = req.getParameter("confirmPassword");

        String error = "";

        if(username == null) {
            error += "Логин не может быть пустым, пожвлуйста попробуйте еще раз";
        }

        if(email == null) {
            error += "почта не может быть пустой, пожалуйста попробуйте еще раз";
        }

        if(password == null) {
            error += "пароль не может быть пустым, пожалуйста попробуйте еще раз";
        }

        if(!confirmPassword.equals(password)) {
            error += "пароли не совпадают, пожалуйста попробуйте еще раз";
        }

        try {
            if(userService.userExist(username)) {
                error += "такой пользователь уже существует";
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        if (!error.isEmpty()) {
            resp.getWriter().write(error);
            return;
        }

        String hashPass = HashUtil.hashPassword(password);

        User user = new User(username, email, hashPass);

        System.out.println("Создаем пользователя: " + username + ", хеш: " + hashPass);

        try {
            userService.saveNewUser(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
