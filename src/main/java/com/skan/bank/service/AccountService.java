package com.skan.bank.service;

import com.skan.bank.model.Account;
import com.skan.bank.repository.AccountRepository;
import org.apache.catalina.security.SecurityUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class AccountService {

    @Autowired
    AccountRepository accountRepository;

    public Optional<Account> getUserAccount(Principal principal){
        return this.accountRepository.findAccountByUsername(principal.getName());
    }
}
