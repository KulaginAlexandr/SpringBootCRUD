package com.kulagin.SpringBootCRUD.service;

import com.kulagin.SpringBootCRUD.dao.UserDao;
import com.kulagin.SpringBootCRUD.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserSeviceImp implements UserService {

    private UserDao userDao;

    @Autowired
    public UserSeviceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    @Override
    public void saveUser(User user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void updateUser(User user) {
        User buffUser = userDao.getOne(user.getId());
        buffUser.setFirstName(user.getFirstName());
        buffUser.setLastName(user.getLastName());
        buffUser.setEmail(user.getEmail());
        userDao.save(buffUser);
    }

    @Transactional
    @Override
    public void deleteUserById(long id) {
        userDao.deleteById(id);
    }

    @Override
    public List<User> getUserList() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getOne(id);
    }
}
