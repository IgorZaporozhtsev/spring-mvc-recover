package com.zeecoder.controller;

import com.zeecoder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AuthController {

    private final AccountService service;

    @Autowired
    public AuthController(AccountService service) {
        this.service = service;
    }

    @GetMapping("/")
    public String singIn(Model model){
        return "/auth/login";
    }

    @PostMapping("/sign_in")
    public String singIn(){
        return "redirect:/account";
    }

    @GetMapping("/registration")
    public String singUp(){
        return "/auth/registration";
    }


}
