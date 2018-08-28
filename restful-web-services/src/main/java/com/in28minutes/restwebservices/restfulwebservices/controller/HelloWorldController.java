package com.in28minutes.restwebservices.restfulwebservices.controller;

import com.in28minutes.restwebservices.restfulwebservices.domain.HelloWorldBean;
import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@Getter
@RestController
public class HelloWorldController {
    private String message;

    //GET METHOD
    // URI - /hello-world
    // Method "Hello World"
    //@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
    @GetMapping("/hello-world")
    public String helloWorld() {
        return "Hello World!";
    }

    //GET METHOD
    // URI - /hello-world-bean
    // Method "Hello World Bean"
    @GetMapping("/hello-world-bean")
    public HelloWorldBean helloWorldBean() {
        return new HelloWorldBean("Hello World!");
    }

    //GET METHOD
    // URI - /hello-world-bean
    // Method "Hello World Bean" qith Path Variables
    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable("name") final String name) {
        return new HelloWorldBean(String.format("Hello World, %s!", name));
    }
}
