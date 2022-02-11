package com.skan.bank.lightbeans.forms;

import java.io.Serializable;

public class OperationAmount implements Serializable {
    private static final long serialVersionUID = 5926548583005150707L;

    private double amount;

    public OperationAmount() {

    }

    public OperationAmount(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

}
