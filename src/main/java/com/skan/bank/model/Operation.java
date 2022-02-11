package com.skan.bank.model;


import com.skan.bank.model.enums.OperationType;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(	name = "operations")
public class Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    private OperationType type;

    @Column (name="date")
    private Instant date;

    @Column (name="amount")
    private Double amount;

    @ManyToOne
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    public Operation(){

    }

    public Operation(OperationType type, Instant date, Double amount, Account account) {
        this.type = type;
        this.date = date;
        this.amount = amount;
        this.account = account;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OperationType getType() {
        return type;
    }

    public void setType(OperationType type) {
        this.type = type;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
