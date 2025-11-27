package com.bookcollection.dao;

import  com.bookcollection.models.Book;
import  com.bookcollection.models.CollectionItem;
import  com.bookcollection.utils.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CollectionDAO {

    public void addBookToCollection(int userId, int bookId, String condition) throws SQLException {
        String sql = "INSERT INTO collection_items (user_id, book_id, condition) VALUES (?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, bookId);
            stmt.setString(3, condition);
            stmt.executeUpdate();
        }
    }

    public void removeBookFromCollection(int userId, int bookId) throws SQLException {
        String sql = "DELETE FROM collection_items WHERE user_id = ? AND book_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, bookId);
            stmt.executeUpdate();
        }
    }

    public List<CollectionItem> getUserCollection(int userId) throws SQLException {
        List<CollectionItem> collection = new ArrayList<>();
        String sql = "SELECT ci.*, b.title, b.author, b.isbn, b.publication_year, b.genre " +
                "FROM collection_items ci " +
                "JOIN books b ON ci.book_id = b.id " +
                "WHERE ci.user_id = ? " +
                "ORDER BY ci.added_date DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                CollectionItem item = new CollectionItem();
                item.setId(rs.getInt("id"));
                item.setUserId(rs.getInt("user_id"));
                item.setBookId(rs.getInt("book_id"));
                item.setCondition(rs.getString("condition"));
                item.setAddedDate(rs.getTimestamp("added_date").toLocalDateTime());

                Book book = new Book();
                book.setId(rs.getInt("book_id"));
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setIsbn(rs.getString("isbn"));
                book.setPublicationYear(rs.getInt("publication_year"));
                book.setGenre(rs.getString("genre"));

                item.setBook(book);
                collection.add(item);
            }
        }
        return collection;
    }

    public boolean isBookInCollection(int userId, int bookId) throws SQLException {
        String sql = "SELECT 1 FROM collection_items WHERE user_id = ? AND book_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, userId);
            stmt.setInt(2, bookId);
            ResultSet rs = stmt.executeQuery();

            return rs.next();
        }
    }
}
