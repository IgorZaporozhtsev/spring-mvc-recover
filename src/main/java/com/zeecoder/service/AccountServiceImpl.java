package com.zeecoder.service;

import com.zeecoder.model.Account;
import com.zeecoder.repository.AccountDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {

    private final PasswordEncoder passwordEncoder;
    private final AccountDAO accountDAO;

    @Autowired //@Lazy - resolve Circular Dependency https://www.baeldung.com/circular-dependencies-in-spring
    public AccountServiceImpl(@Lazy PasswordEncoder passwordEncoder, AccountDAO accountDAO) {
        this.passwordEncoder = passwordEncoder;
        this.accountDAO = accountDAO;
    }

    @Override
    public List<Account> getAll() {
        return accountDAO.getAll();
    }

    @Override
    public void add(Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        accountDAO.add(account);
    }

    @Override
    public Account getOne(Long id) {
        return accountDAO.getOne(id);
    }

    @Override
    public void update(Account account) {
        accountDAO.update(account);
    }

    @Override
    public void delete(Long id) {
        accountDAO.delete(id);
    }

    @Override
    public Account findByName(String nickname) {
        return accountDAO.findByName(nickname);
    }
}
