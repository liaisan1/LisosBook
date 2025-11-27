package com.bookcollection.services;

import com.bookcollection.dao.CollectionDAO;
import com.bookcollection.models.CollectionItem;

import java.sql.SQLException;
import java.util.List;

public class CollectionService {
    private CollectionDAO collectionDAO;

    public CollectionService(CollectionDAO collectionDAO) {
        this.collectionDAO = collectionDAO;
    }

    public void addBookToCollection(int userId, int bookId, String condition) throws SQLException {
        collectionDAO.addBookToCollection(userId, bookId, condition);
    }

    public void removeBookFromCollection(int userId, int bookId) throws SQLException {
        collectionDAO.removeBookFromCollection(userId, bookId);
    }

    public List<CollectionItem> getUserCollection(int userId) throws SQLException {
        return collectionDAO.getUserCollection(userId);
    }

    public boolean isBookInCollection(int userId, int bookId) throws SQLException {
        return collectionDAO.isBookInCollection(userId, bookId);
    }
}