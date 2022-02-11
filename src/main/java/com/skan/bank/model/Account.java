package com.skan.bank.model;

import com.skan.bank.model.enums.AccountType;
import com.skan.bank.model.enums.Currency;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.Objects;

@Entity
@Table(	name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "account_type")
    private AccountType accountType ;

    @Column(name = "balance")
    private Double balance;

    @Column(name="last_operation_date")
    private Instant lastOperationDate;

    @Column(name="currency")
    private Currency currency;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @OneToMany(mappedBy="account")
    private List<Operation> operations;

    public Account(){

    }

    public Account(AccountType accountType, Double balance, Instant lastOperationDate, Currency currency, User user) {
        this.accountType = accountType;
        this.balance = balance;
        this.lastOperationDate = lastOperationDate;
        this.currency = currency;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Instant getLastOperationDate() {
        return lastOperationDate;
    }

    public void setLastOperationDate(Instant lastOperationDate) {
        this.lastOperationDate = lastOperationDate;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id.equals(account.id) && accountType == account.accountType && balance.equals(account.balance) && lastOperationDate.equals(account.lastOperationDate) && currency == account.currency && user.equals(account.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, accountType, balance, lastOperationDate, currency, user);
    }
}
