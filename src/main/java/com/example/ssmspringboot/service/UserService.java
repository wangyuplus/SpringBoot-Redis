package com.example.ssmspringboot.service;



import com.example.ssmspringboot.domain.User;

import java.util.ArrayList;

public interface UserService {
    User getUser(String username);
    ArrayList<User> getAll();
    ArrayList<User>  update(User user);
    String delete(Integer id);

    String insert(User user);

    User getUserById(Integer id);
}


