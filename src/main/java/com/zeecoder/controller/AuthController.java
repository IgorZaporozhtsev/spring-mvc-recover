package com.zeecoder.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    @GetMapping
    public String greeting(){
        return "/auth/login";
    }

    @PostMapping
    public String error(){
        return "/auth/login";
    }
}
