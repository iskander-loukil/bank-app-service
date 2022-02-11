package com.skan.bank.controller;

import com.skan.bank.lightbeans.forms.JwtRequest;
import com.skan.bank.lightbeans.forms.OperationAmount;
import com.skan.bank.model.Account;
import com.skan.bank.service.OperationService;
import com.skan.bank.service.exception.WithDrawlNotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Optional;

@RestController
@CrossOrigin
public class OperationController {

    @Autowired
    OperationService operationService;

    @RequestMapping(value = "/withdraw", method = RequestMethod.POST)
    public ResponseEntity<?> withdrawAmount(@RequestBody OperationAmount operationAmount, Principal principal) throws Exception {
        try {
            Optional<Account> account = operationService.withdraw(operationAmount.getAmount(), principal);
            return account.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));

        } catch (WithDrawlNotAllowedException e) {
            return new ResponseEntity(HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @RequestMapping(value = "/deposit", method = RequestMethod.POST)
    public ResponseEntity<?> depositAmount(@RequestBody OperationAmount operationAmount, Principal principal) throws Exception {

        Optional<Account> account = operationService.deposit(operationAmount.getAmount(), principal);
        return account.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

}
