package com.mycommunityapp.usermanagement.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/login")
public class OauthClient {

    @GetMapping(value = "/oauth2/code/google")
    public void oauth(){
        System.out.println("users oauth2");
    }
}
