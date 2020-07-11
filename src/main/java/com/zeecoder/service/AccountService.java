package com.zeecoder.service;

import com.zeecoder.model.Account;

import java.util.List;

public interface AccountService {

    List<Account> getAll();

    void add(Account account);

    Account getOne(Long id);

    void update(Account account);

    void delete(Long id);

    Account findByName(String nickname);
}
