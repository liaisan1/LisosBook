package com.bookcollection.models;

import java.time.LocalDateTime;

/**
 * Модель пользователя
 * Это как "анкета" пользователя с полями для заполнения
 */
public class User {
    private int id;              // Уникальный номер (как ID в паспорте)
    private String username;     // Логин для входа
    private String email;        // Email адрес
    private String passwordHash; // Зашифрованный пароль
    private LocalDateTime createdAt; // Дата регистрации

    // Конструктор по умолчанию (нужен для JSP)
    public User() {}

    // Конструктор для создания нового пользователя
    public User(String username, String email, String passwordHash) {
        this.username = username;
        this.email = email;
        this.passwordHash = passwordHash;
    }

    // === ГЕТТЕРЫ (получить значение) ===
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public LocalDateTime getCreatedAt() { return createdAt; }

    // === СЕТТЕРЫ (установить значение) ===
    public void setId(int id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setEmail(String email) { this.email = email; }
    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }
    public void setCreatedAt(LocalDateTime createdAt) { this.createdAt = createdAt; }
}