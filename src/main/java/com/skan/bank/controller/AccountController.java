package com.skan.bank.controller;

import com.skan.bank.model.Account;
import com.skan.bank.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> currentUserName(Principal principal) {
        Optional<Account> account = this.accountService.getUserAccount(principal);
        return account.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
