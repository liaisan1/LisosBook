package services;

import dao.UserDAO;
import models.Book;
import models.User;
import utils.HashUtil;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private UserDAO userDAO;

    public UserService() throws SQLException, ClassNotFoundException {
        this.userDAO = new UserDAO();
    }

    public boolean userExist(String username) throws SQLException {
        return userDAO.userExixt(username);
    }

    public void saveNewUser(User user) throws SQLException {
        userDAO.createUser(user);
    }

    public User authUser(String username, String pass) throws SQLException {
        User user = userDAO.getUserByUsername(username);

        if (user!= null &&HashUtil.verify(pass, user.getPasswordHash())) {
            return user;
        }

        return null;
    }

    public List<Book> getBooksByUser(long id) throws SQLException{
        return userDAO.getBooksByUser(id);
    }
}
