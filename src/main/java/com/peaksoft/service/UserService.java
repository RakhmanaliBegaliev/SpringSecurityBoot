package com.peaksoft.service;

import com.peaksoft.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);

    void update(Long id, User user);

    User getById(Long id);

    List<User> getAll();
    User getUserByUsername(String username);
}
