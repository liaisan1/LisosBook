package dao;

import models.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    Connection connection;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        Connection connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/lisosbook",
                "postgres",
                "1234"
        );
        return connection;
    }

    public BookDAO() throws SQLException, ClassNotFoundException {
        this.connection = getConnection();
    }

    public void createBook(Book book) throws SQLException {
        String sqlScript = "insert into books (title, author, publication_year, genre) values (?, ?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setInt(3, book.getPublicationYear());
            ps.setString(4, book.getGenre());
            ps.executeUpdate();
        }

    }

    public void deleteBook(Book book) throws SQLException {
        String sqlScript = "DELETE FROM books WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setLong(1, book.getId());
            ps.executeUpdate();
        }
    }

    public List<Book> getAllBook() throws SQLException {
        List<Book> books = new ArrayList<>();

        String sqlScript = "select * from books order by id";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript);ResultSet rs = ps.executeQuery()) {
            while(rs.next()) {
                Book book = new Book(rs.getLong("id"), rs.getString("title"), rs.getString("author"), rs.getInt("publication_year"), rs.getString("genre"));

                books.add(book);
            }
            return books;
        }
    }

    public List<Book> searchBooks(String query) throws SQLException {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title ILIKE ? OR author ILIKE ?"; // ILIKE для регистронезависимого поиска

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, "%" + query + "%");
            ps.setString(2, "%" + query + "%");

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Book book = new Book(rs.getLong("id"), rs.getString("title"), rs.getString("author"), rs.getInt("publication_year"), rs.getString("genre"));
                    books.add(book);
                }
            }
        }

        return books;
    }
    public void setBookByUser(long userId, long bookId) throws SQLException {
        List<Book> books = new ArrayList<>();
        String sqlScript = "INSERT INTO user_books (user_id, book_id) VALUES (?, ?) ON CONFLICT (user_id, book_id) DO NOTHING";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setLong(1, userId);
            ps.setLong(2, bookId);
            ps.executeUpdate();
        }

    }

    public void deleteBookByUser(long userId, long bookId) {
        String sqlScript = "delete from user_books where user_id = ? and book_id = ?";

        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setLong(1, userId);
            ps.setLong(2, bookId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Book getBookById(long id) throws SQLException {
        String sql = "select * from books where id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet rs = statement.executeQuery()) {
                if(rs.next()) {
                    Book book = new Book(
                            rs.getLong("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getInt("publication_year"),
                            rs.getString("genre")
                    );

                    return book;
                }
            }
        }
        return null;
    }

}
