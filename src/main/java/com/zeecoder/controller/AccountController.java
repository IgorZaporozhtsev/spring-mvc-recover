package com.zeecoder.controller;

import com.zeecoder.model.Account;
import com.zeecoder.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class AccountController {

    @Autowired
    AccountDAO accountDAO;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Account> accounts = accountDAO.getAll();
        model.addAttribute("accounts", accounts);
        return "account";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addAccount(@ModelAttribute("account") Account account)  {
        accountDAO.add(account);
        return "redirect:/account";
    }


    @RequestMapping(value = "account/edit/{id}", method = RequestMethod.GET)
    public String showUpdateForm(@PathVariable("id") long id, Model model) {
        Account student = accountDAO.getOne(id);
        model.addAttribute("account", student);
        return "update-account";
    }

    @RequestMapping(value = "account/update/{id}", method = RequestMethod.POST)
    public String updateStudent(@PathVariable("id") Long id, Account account, Model model) {
        accountDAO.update(account);
        model.addAttribute("accounts", accountDAO.getAll());
        return "redirect:/account";
    }

    @RequestMapping(value = "account/delete/{id}", method = RequestMethod.GET)
    public String delete(@PathVariable(value = "id")  Long id) {
        accountDAO.delete(id);
        return "redirect:/account";
    }

}
