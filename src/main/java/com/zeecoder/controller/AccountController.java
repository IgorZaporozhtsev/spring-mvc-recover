package com.zeecoder.controller;

import com.zeecoder.model.Account;
import com.zeecoder.repository.AccountDAOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;


@Controller
public class AccountController {

    @Autowired
    AccountDAOImpl accountDAO;

    @GetMapping("/account")
    public String getAll(Model model) {
        List<Account> accounts = accountDAO.getAll();
        model.addAttribute("accounts", accounts);
        return "account";
    }

    @PostMapping("/add")
    public String addAccount(@ModelAttribute("account") Account account)  {
        accountDAO.add(account);
        return "redirect:/account";
    }

    @GetMapping
    public Account getOne(Long id){
        return accountDAO.getOne(id);
    }

    @PutMapping("/account")
    public void update(Account account) {
        accountDAO.update(account);
    }

    @DeleteMapping("/account")
    public void delete(Long id) {
        accountDAO.delete(id);
    }

}
