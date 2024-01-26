package service;

import dao.UserDAO;
import entity.Users;
import entity.VerifyAccount;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.*;

public class UserService {
    static UserDAO userDao;
    static UserService instance;
    public UserService() {
        this.userDao = new UserDAO();
    }
    public static UserService getInstance() {
        if (instance == null)
            instance = new UserService();
        return instance;
    }
    public static boolean checkLogin(String username, String password) {
        return userDao.checkLogin(username, password);
    }

    public Users get(int id) {
        return userDao.get(id);
    }
    public boolean checkExistUserName(String userName) {
        return userDao.checkExistUserName(userName);
    }

    public boolean checkExistEmail(String email) {
        return userDao.checkExistEmail(email);
    }

    public int registerAccount(Users a) {
        return userDao.registerAccount(a);
    }

    public int insertVerify(VerifyAccount v) {
        return userDao.insertVerify(v);
    }

    public int updateStateVerify(VerifyAccount v) {
        return userDao.updateStateVerify(v);
    }

    public Users selectAccountByUserName(String userName) {
        return userDao.selectAccountByUserName(userName);
    }
    public Users selectAccountByEmail(String email) {
        return userDao.selectAccountByEmail(email);
    }
    public  VerifyAccount selectVerifyAccountByIdAccount(int idAccount) {
        return userDao.selectVerifyAccountByIdAccount(idAccount);
    }
    public  int updateVerify(int newCode, LocalDateTime timeNew, int idAccount) {
        return userDao.updateVerify(newCode, timeNew, idAccount);}
    public  int updateInfor(Users account)  { return userDao.updateInfor(account);}
    public  Users selectById(int id){
        return userDao.selectById(id);
    }

    public VerifyAccount getVrfOfAccount(int idAccount) {
        return userDao.getVrfOfAccount(idAccount);
    }
    public static int updatePassword(String passEnCrypt, int idAccount) {
        return userDao.updatePassword(passEnCrypt, idAccount);
    }
    public ArrayList<Users> listAllAccount()  {
        ArrayList<Users> listAccount = userDao.listAllAccount();
        for(Users a:listAccount) {
            VerifyAccount vrf = userDao.selectVerifyAccountByIdAccount(a.getId());
            a.setVerifyAccount(vrf);
        }
        return listAccount;
    }
    public int updateStatus(int id, boolean status) {
        try {
            return userDao.updateStatus(id, status);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int updateInforAccount(Users a) throws SQLException {
        return userDao.updateInforAccount(a);
    }
}
