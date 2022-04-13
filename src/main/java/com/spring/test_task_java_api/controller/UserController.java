package com.spring.test_task_java_api.controller;

import com.spring.test_task_java_api.entity.User;
import com.spring.test_task_java_api.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
@AllArgsConstructor
@Slf4j
public class UserController {

    @Autowired
    private final UserServiceImpl userService;

        private List<User> users = new ArrayList<>();

    {
        users.add(new User(1, "John Shepard", "JohnShepard@gmail.com"));
        users.add(new User(2, "David Anderson", "DavidAnderson@gmail.com"));
        users.add(new User(3, "Liara T'Soni", "LiaraT'Soni@gmail.com"));
        users.add(new User(4, "Garrus Vakarian", "GarrusVakarian@gmail.com"));
        users.add(new User(5, "Tali'Zorah vas Normandy", "Tali'ZorahvasNormandy@gmail.com"));
    }


    @GetMapping
    public List<User> getUsers() {

        return userService.getAllUsers();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User insertUser(@RequestBody User user) {

        return userService.insertUser(user);
    }

    @PutMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public User updateUser(@PathVariable int id, @RequestBody User user) {

        return userService.updateUser(id, user);
    }

    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteUser(@PathVariable int id) {

        return userService.deleteUser(id);
    }
}
