package com.chapter_10.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOimpl implements AccountDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my db work by adding an account");
    }
}