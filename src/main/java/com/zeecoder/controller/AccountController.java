package com.zeecoder.controller;

import com.zeecoder.model.Account;
import com.zeecoder.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping(value = "account")
public class AccountController {

    private final AccountService service;

    @Autowired
    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping
    public String getAll(Model model) {
        List<Account> accounts = service.getAll();
        model.addAttribute("accounts", accounts);
        return "account";
    }

    @GetMapping("/add")
    public String showaddForm(Model model)  {
        return "add-account";
    }

    @PostMapping("/add")
    public String addAccount(@ModelAttribute("account") Account account)  {
        service.add(account);
        return "redirect:/account";
    }

    @GetMapping("/edit/{id}")
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Account account = service.getOne(id);
        model.addAttribute("account", account);
        return "update-account";
    }

    @PostMapping("/update")
    public String update(Account account, Model model) {
        service.update(account);
        model.addAttribute("accounts", service.getAll());
        return "redirect:/account";
    }

    @GetMapping(value = "/delete/{id}")
    public String delete(@PathVariable(value = "id")  Long id) {
        service.delete(id);
        return "redirect:/account";
    }

}
