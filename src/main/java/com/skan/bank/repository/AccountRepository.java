package com.skan.bank.repository;

import com.skan.bank.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query ("select acc from Account acc where acc.user.username = ?1")
    Optional<Account> findAccountByUsername(String username);
}
