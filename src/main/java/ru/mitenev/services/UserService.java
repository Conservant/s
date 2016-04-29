package ru.mitenev.services;

import ru.mitenev.domain.User;

import java.util.List;

public interface UserService {
    List<User> loadAll();
    User findUserById(Long id);
    User create(User user);
    void delete (User id);
    void update (User id);
}
