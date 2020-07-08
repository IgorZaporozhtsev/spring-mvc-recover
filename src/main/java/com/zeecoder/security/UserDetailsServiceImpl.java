package com.zeecoder.security;

import com.zeecoder.model.Account;
import com.zeecoder.service.AccountService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements org.springframework.security.core.userdetails.UserDetailsService {

    private final AccountService accountService;

    public UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {

        Account derivedAccount = accountService.findByName(name);

        if (derivedAccount == null){
            throw new UsernameNotFoundException("User '" + name + "' not found");
        }

        return derivedAccount;
    }
}
