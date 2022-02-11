package com.skan.bank.service;

import com.skan.bank.model.Account;
import com.skan.bank.model.Operation;
import com.skan.bank.model.enums.OperationType;
import com.skan.bank.repository.AccountRepository;
import com.skan.bank.repository.OperationRepository;
import com.skan.bank.service.exception.WithDrawlNotAllowedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.time.Instant;
import java.util.Optional;

@Service
public class OperationService {
    @Autowired
    AccountRepository accountRepository;

    @Autowired
    OperationRepository operationRepository;

    public Optional<Account> withdraw(Double amount, Principal principal) throws WithDrawlNotAllowedException {
        Optional<Account> optionalAccount = accountRepository.findAccountByUsername(principal.getName());
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
            if (amount > account.getBalance()){
                throw new WithDrawlNotAllowedException("Amount exceeds current balance");
            }
            else {
                Instant currentDate = Instant.now();
                account.setBalance(account.getBalance() - amount);
                account.setLastOperationDate(currentDate);
                Operation operation = new Operation(
                        OperationType.WITHDRAWL,
                        currentDate,
                        amount,
                        account);
                operationRepository.save(operation);
                accountRepository.save(account);

            }
        }
        return optionalAccount;
    }


    public Optional<Account> deposit(Double amount, Principal principal)  {
        Optional<Account> optionalAccount = accountRepository.findAccountByUsername(principal.getName());
        if (optionalAccount.isPresent()){
            Account account = optionalAccount.get();
                Instant currentDate = Instant.now();
                account.setBalance(account.getBalance() + amount);
                account.setLastOperationDate(currentDate);
                Operation operation = new Operation(
                        OperationType.DEPOSIT,
                        currentDate,
                        amount,
                        account);
                operationRepository.save(operation);
                accountRepository.save(account);

            }

        return optionalAccount;
    }

}
