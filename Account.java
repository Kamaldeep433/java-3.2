package com.example.model;

import jakarta.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String holder;
    private double balance;

    public Account() {}
    public Account(String holder, double balance) { this.holder=holder; this.balance=balance; }

    public int getId() { return id; }
    public String getHolder() { return holder; }
    public void setHolder(String holder) { this.holder=holder; }
    public double getBalance() { return balance; }
    public void setBalance(double balance) { this.balance=balance; }
}
