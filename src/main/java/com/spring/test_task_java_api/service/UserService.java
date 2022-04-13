package com.spring.test_task_java_api.service;

import com.spring.test_task_java_api.entity.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User insertUser(User user);

    User updateUser(int id, User user);

    String deleteUser(int id);

}
