package com.zeecoder.controller;

import com.zeecoder.model.Account;
import com.zeecoder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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

    @GetMapping
    public String greeting(){
        return "/auth/login";
    }

    @PostMapping
    public String error(){
        return "/auth/login";
    }

    @GetMapping("/registration")
    public String singUp(){
        return "/auth/registration";
    }

    @PostMapping("/add")
    public String addAccount(@ModelAttribute("account") Account account)  {
        service.add(account);
        return "redirect:/";
    }



}
