package com.bookcollection.models;

/**
 * Модель книги
 * Это как "карточка" книги в библиотеке
 */
public class Book {
    private int id;                 // Уникальный номер книги
    private String title;           // Название книги
    private String author;          // Автор
    private String isbn;            // ISBN номер (уникальный идентификатор)
    private int publicationYear;    // Год издания
    private String genre;           // Жанр

    // Конструктор по умолчанию
    public Book() {}

    // Конструктор для создания новой книги
    public Book(String title, String author, String isbn, int publicationYear, String genre) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publicationYear = publicationYear;
        this.genre = genre;
    }

    // === ГЕТТЕРЫ ===
    public int getId() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getIsbn() { return isbn; }
    public int getPublicationYear() { return publicationYear; }
    public String getGenre() { return genre; }

    // === СЕТТЕРЫ ===
    public void setId(int id) { this.id = id; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }
    public void setIsbn(String isbn) { this.isbn = isbn; }
    public void setPublicationYear(int publicationYear) { this.publicationYear = publicationYear; }
    public void setGenre(String genre) { this.genre = genre; }
}