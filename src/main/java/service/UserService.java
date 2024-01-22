package service;

import dao.UserDAO;
import entity.Users;
import java.util.Map;

public class UserService {
     UserDAO userDao;

    public UserService() {
        this.userDao = new UserDAO();
    }

    public boolean checkLogin(String username, String password) {
        return userDao.checkLogin(username, password);
    }

}
