package com.in28minutes.restwebservices.restfulwebservices.resource;

import com.in28minutes.restwebservices.restfulwebservices.dao.UserDaoService;
import com.in28minutes.restwebservices.restfulwebservices.domain.User;
import com.in28minutes.restwebservices.restfulwebservices.exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponents;

import java.net.URI;
import java.nio.file.attribute.UserPrincipalNotFoundException;
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
    private User retrieveUser(@PathVariable final int id) {
        User user = userService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id-" + id);
        }
        return user;
    }

    /*
        POST /users
        Add new  User
    */
    @PostMapping("/users")
    private ResponseEntity<Object> createUser(@RequestBody User user) {
        User savedUser = userService.save(user);
        // USER CREATED
        // /user/{id} savedUser.getId();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
