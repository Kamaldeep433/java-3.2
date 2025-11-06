package com.example.config;

import com.example.model.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class AccountService {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public void transfer(int fromId, int toId, double amount) {
        Account from = sessionFactory.getCurrentSession().get(Account.class, fromId);
        Account to = sessionFactory.getCurrentSession().get(Account.class, toId);
        from.setBalance(from.getBalance()-amount);
        to.setBalance(to.getBalance()+amount);
    }
}
