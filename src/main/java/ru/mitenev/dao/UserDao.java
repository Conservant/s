package ru.mitenev.dao;

import ru.mitenev.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    User getById(Long id);
    void saveUser(User user);
    void delete(User user);
}
