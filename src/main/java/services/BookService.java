package com.bookcollection.services;

import com.bookcollection.dao.BookDAO;
import com.bookcollection.models.Book;

import java.sql.SQLException;
import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> getAllBooks() throws SQLException {
        return bookDAO.getAllBooks();
    }

    public Book getBookById(int id) throws SQLException {
        return bookDAO.findById(id);
    }

    public Book createBook(Book book) throws SQLException {
        return bookDAO.createBook(book);
    }

    public void updateBook(Book book) throws SQLException {
        bookDAO.updateBook(book);
    }

    public void deleteBook(int id) throws SQLException {
        bookDAO.deleteBook(id);
    }

    public List<Book> searchBooks(String query) throws SQLException {
        return bookDAO.searchBooks(query);
    }
}
