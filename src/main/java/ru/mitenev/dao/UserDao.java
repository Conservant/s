package ru.mitenev.dao;

import ru.mitenev.domain.User;

import java.util.List;

public interface UserDao {
    List<User> getAll();
    List<User> getUsersWithKnowledges();
    User getById(Long id);
    User saveUser(User user);
    void delete(User user);
}
