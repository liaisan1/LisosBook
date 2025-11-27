package com.bookcollection.services;

import  com.bookcollection.dao.UserDAO;
import  com.bookcollection.models.User;

import java.sql.SQLException;

public class AuthService {
    private UserDAO userDAO;

    public AuthService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public User register(String username, String email, String password) throws SQLException {
        // Проверяем, нет ли уже такого пользователя
        if (userDAO.findByUsername(username) != null) {
            throw new IllegalArgumentException("Пользователь с таким логином уже существует");
        }
        if (userDAO.findByEmail(email) != null) {
            throw new IllegalArgumentException("Пользователь с таким email уже существует");
        }

        // Шифруем пароль
        String passwordHash = userDAO.hashPassword(password);

        // Создаем пользователя
        User user = new User(username, email, passwordHash);
        return userDAO.createUser(user);
    }

    public User login(String username, String password) throws SQLException {
        // Ищем пользователя
        User user = userDAO.findByUsername(username);

        // Проверяем пароль
        if (user != null && userDAO.validatePassword(password, user.getPasswordHash())) {
            return user;
        }
        return null;
    }
}