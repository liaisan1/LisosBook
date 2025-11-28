package dao;

import models.Book;
import models.User;
import services.BookService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
    Connection connection;
    BookService bookService;

    public Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");
        this.connection = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/lisosbook",
                "postgres",
                "1234"
        );
        return this.connection;
    }

    public UserDAO() throws SQLException, ClassNotFoundException {
        this.connection = getConnection();
        this.bookService = new BookService(); //костыль)
    }


    //Проверка на существование юзера
    public boolean userExixt(String username) throws SQLException {
        String sql = "select 1 from users where username = ?";

        try(PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            try(ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        }
    }
    public List<Book> getBooksByUser(long userId) throws SQLException {
        List<Book> books = new ArrayList<>();

        String sql = "select * from user_books where user_id = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setLong(1, userId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    long bookId = rs.getLong("book_id");
                    Book book = bookService.getBookById(bookId);
                    books.add(book);
                }
            }
        }

        return books;
    }



    public User getUserByUsername(String username) throws SQLException {
        String sql = "select * from users where username = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, username);

            try (ResultSet rs = statement.executeQuery()) {
                if (rs.next()) {
                    User user = new User(
                            rs.getLong("id"),
                            rs.getString("username"),
                            rs.getString("email"),
                            rs.getString("password_hash"),
                            rs.getString("role")
                    );

                    return user;
                }
            }
        }
        return null;
    }

    public void createUser(User user) throws SQLException {
        String sqlScript = "insert into users (username, email, password_hash, role) values (?, ?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, "USER");
            ps.executeUpdate();
        }

    }

    public void deleteUser(User user) throws SQLException {
        String sqlScript = "DELETE FROM users WHERE username = ?";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setString(1, user.getUsername());
            ps.executeUpdate();
        }
    }

    public void updateUserRole(User user, String role) throws SQLException {
        String sqlScript = "UPDATE users SET role = ? WHERE username = ?";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setString(1, role);
            ps.setString(2, user.getUsername());
            ps.executeUpdate();
        }

    }
}
