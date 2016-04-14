package ru.mitenev.services;

import ru.mitenev.domain.User;

import java.util.List;

public interface UserService {
    List<User> loadAll();

}
