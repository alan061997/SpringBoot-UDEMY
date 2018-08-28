package com.in28minutes.restwebservices.restfulwebservices.resource;

import com.in28minutes.restwebservices.restfulwebservices.dao.UserDaoService;
import com.in28minutes.restwebservices.restfulwebservices.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserResource {

    @Autowired
    private UserDaoService userService;

    /*
        GET /users
        Retreive all Users
    */
    @GetMapping("/users")
    private List<User> retrieveAllUsers() {
        return userService.findAll();
    }

    /*
        GET /users/{id}
        Retrieve User by Id
    */
    @GetMapping("/users/{id}")
    private User retrieveUser(@PathVariable final int id){
        return userService.findOne(id);
    }

    /*
        POST /users
        Add new  User
    */
    @PostMapping("/users")
    private void createUser(@RequestBody User user){
        userService.save(user);
    }

}
