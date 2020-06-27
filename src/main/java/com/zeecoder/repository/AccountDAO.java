package com.zeecoder.repository;

import com.zeecoder.model.Account;
import java.util.List;

public interface AccountDAO {

    List<Account> getAll();

    void add(Account account);

    Account getOne(Long id);

    void update(Account account);

    void delete(Long id);
}
