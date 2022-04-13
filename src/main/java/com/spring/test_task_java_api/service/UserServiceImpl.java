package com.spring.test_task_java_api.service;


import com.spring.test_task_java_api.dao.UsersRepository;
import com.spring.test_task_java_api.entity.User;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    @Autowired
    private final UsersRepository usersRepository;

    @Override
    public List<User> getAllUsers() {
        return usersRepository.findAll();
    }

    @Override
    public User insertUser(User user) {
        usersRepository.save(user);
        return user;
    }

    @Override
    public User updateUser( int id, User user) {

       final Optional<User> first = usersRepository.findById(String.valueOf(id));
        final User userInList = first
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found"));
       userInList.setId(user.getId());
       userInList.setName(user.getName());
       userInList.setEmail(user.getEmail());
       usersRepository.save(userInList);
       return user;
    }

    @Override
    public String deleteUser(int id) {
        if (!usersRepository.existsById(String.valueOf(id))) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No user found");
        }

        usersRepository.deleteById(String.valueOf(id));
        return "User deleted";

    }
}
