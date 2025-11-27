package com.bookcollection.models;

import java.time.LocalDateTime;

/**
 * Модель элемента коллекции
 * Связывает пользователя и книгу (многие-ко-многим)
 * Это как "чек" из магазина - кто какую книгу купил
 */
public class CollectionItem {
    private int id;              // Уникальный номер записи
    private int userId;          // ID пользователя
    private int bookId;          // ID книги
    private String condition;    // Состояние книги (новая, б/у и т.д.)
    private LocalDateTime addedDate; // Дата добавления в коллекцию
    private Book book;           // Объект книги (для удобства)

    // Конструкторы
    public CollectionItem() {}

    public CollectionItem(int userId, int bookId, String condition) {
        this.userId = userId;
        this.bookId = bookId;
        this.condition = condition;
    }

    // === ГЕТТЕРЫ ===
    public int getId() { return id; }
    public int getUserId() { return userId; }
    public int getBookId() { return bookId; }
    public String getCondition() { return condition; }
    public LocalDateTime getAddedDate() { return addedDate; }
    public Book getBook() { return book; }

    // === СЕТТЕРЫ ===
    public void setId(int id) { this.id = id; }
    public void setUserId(int userId) { this.userId = userId; }
    public void setBookId(int bookId) { this.bookId = bookId; }
    public void setCondition(String condition) { this.condition = condition; }
    public void setAddedDate(LocalDateTime addedDate) { this.addedDate = addedDate; }
    public void setBook(Book book) { this.book = book; }
}