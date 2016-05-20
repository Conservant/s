package ru.mitenev.services.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import ru.mitenev.dao.UserDao;
import ru.mitenev.domain.User;
import ru.mitenev.services.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return Lists.newArrayList(userDao.getAll());
    }

    @Transactional(readOnly = true)
    @Override
    public User findById(Long id) {
        return userDao.getById(id);
    }

    @Override
    public User save(User user) {
        return userDao.saveUser(user);
    }
}
