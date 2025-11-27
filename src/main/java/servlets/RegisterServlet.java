package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import models.User;
import utils.HashUtil;

import java.io.IOException;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/jsp/register.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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

        if(confirmPassword.equals(password)) {
            error += "пароли не совпадают, пожалуйста попробуйте еще раз";
        }


        if (!error.isEmpty()) {
            resp.getWriter().write(error);
            return;
        }

        String hashPass = HashUtil.hashPassword(password);

        User user = new User(username, email, hashPass);

        HttpSession session = (HttpSession) req.getSession();

        Cookie cookie = new Cookie("loginUser", username);

        resp.addCookie(cookie);

        resp.sendRedirect(req.getContextPath() + "/login");
    }
}
