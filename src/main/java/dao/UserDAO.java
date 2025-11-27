package dao;

import models.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO {
    private Connection connection;
    //получать юзер по логину
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
        String sqlScript = "insert into users (username, email, passwordHash, role) values (?, ?, ?, ?)";
        try(PreparedStatement ps = connection.prepareStatement(sqlScript)) {
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getPasswordHash());
            ps.setString(4, "USER");
        }

    }

    public void deleteUser(User user) {

    }

    public void updateUserRole(User user, String role) {

    }
}
