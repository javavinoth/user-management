package com.mycommunityapp.usermanagement.controller;

import com.mycommunityapp.usermanagement.model.User;
import com.mycommunityapp.usermanagement.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = "/v1/users")
@Api(value="/v1/users",consumes="application/json",produces="application/json")
public class UserController {


    private final UserService userService;

    private HttpServletRequest httpServletRequest;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ApiOperation(value="To Sign up Users")
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> addUser(@RequestBody User user) {
        userService.createUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation(value="To Sign in the Registered Users")
    @GetMapping(value = "/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<?> getUser(@PathVariable final String id){
        User user = userService.readUser(id);
        return (user != null)?new ResponseEntity<User>(user, HttpStatus.FOUND) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/oauth2")
    public void oauth(){
        System.out.println("users oauth2");
    }
}
