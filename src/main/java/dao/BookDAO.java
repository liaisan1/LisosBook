package dao;

import models.Book;

import java.sql.*;

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

    //получать кнгиу по Чему
    public void createBook(Book book) throws SQLException {
        String sqlScript = "insert into books (title, author, publicationYear, genre) values (?, ?, ?, ?)";
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

    public void updateBook(Book oldBook, Book newBook) throws SQLException {
        String sqlScript = "UPDATE books SET title = ?, author = ?, publication_year = ?, genre = ? WHERE id = ?";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setString(1, newBook.getTitle());
            ps.setString(2, newBook.getAuthor());
            ps.setInt(3, newBook.getPublicationYear());
            ps.setString(4, newBook.getGenre());
            ps.setLong(5, oldBook.getId());
            ps.executeUpdate();
        }
    }

    public Book getBookByTitle(String title) throws SQLException {
        String sql = "select * from users where title = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, title);
            try (ResultSet rs = statement.executeQuery()) {
                if(rs.next()) {
                    Book book = new Book(
                            rs.getLong("id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getInt("publicationYear"),
                            rs.getString("genre")
                    );

                    return book;
                }
            }
        }
        return null;
    }
}
