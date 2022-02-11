package com.skan.bank.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(	name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "account_code")
    private String accountCode;

    @Column(name = "password")
    private String password;

    public User() {
    }

    public User(String firstName, String lastName, String accountCode, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.accountCode = accountCode;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAccountCode() {
        return accountCode;
    }

    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && firstName.equals(user.firstName) && lastName.equals(user.lastName) && accountCode.equals(user.accountCode) && password.equals(user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, accountCode, password);
    }
}