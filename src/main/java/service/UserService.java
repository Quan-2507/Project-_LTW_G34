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

    public List<Users> getAdmin(int role) {
        return userDao.getAdmin(role);
    }
    public List<Users> getUser(int role){
        return  userDao.getUser(role);
    }
    public Users get(int id) {
        return userDao.get(id);
    }
    public List<Users> getAll() {
        return userDao.getAll();
    }
    public void insert(Users user) {
            userDao.insert(user);
    }
    public void edit(Users user) {
        userDao.edit(user);
    }
    public void delete(int id) {
        userDao.delete(id);
    }
}
