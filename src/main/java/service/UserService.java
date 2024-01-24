package service;

import dao.UserDAO;
import entity.Users;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserService {
    UserDAO userDao;

    public UserService() {
        this.userDao = new UserDAO();
    }

    public boolean checkLogin(String username, String password) {
        return userDao.checkLogin(username, password);
    }

    public List<Users> getAdmin(int status) {
        return userDao.getAdmin(status);
    }
    public Users get(int id) {
        return userDao.get(id);
    }
}
