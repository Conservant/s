package ru.mitenev.services;

import ru.mitenev.domain.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(Long id);
    User save(User user);
}
