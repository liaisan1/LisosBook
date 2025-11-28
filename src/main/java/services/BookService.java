package services;

import dao.BookDAO;
import models.Book;

import java.sql.SQLException;
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

    public void deleteBookByUser(long userId, long bookId) {
        bookDAO.deleteBookByUser(userId,bookId);
    }

    public void setBookByUser(long userId, long bookId) throws SQLException {
        bookDAO.setBookByUser(userId, bookId);
    }
    public List<Book> getAllBook() throws SQLException {
        return bookDAO.getAllBook();
    }
    public Book getBookById(long id) throws SQLException{
        return bookDAO.getBookById(id);
    }
}
