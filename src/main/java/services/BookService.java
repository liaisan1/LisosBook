package services;

import dao.BookDAO;
import models.Book;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookService {
    private BookDAO bookDAO;

    public BookService() throws SQLException, ClassNotFoundException {
        this.bookDAO = new BookDAO();
    }

    public void addBook(Book book) throws SQLException {
        bookDAO.createBook(book);

        System.out.println(book);
    }

    public void deleteBook(Book book) throws SQLException {
        bookDAO.deleteBook(book);
    }

    public List<Book> getAllBook() throws SQLException {
        return bookDAO.getAllBook();
    }
}
