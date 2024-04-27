package com.chapter_10.demo.dao;

import com.chapter_10.demo.Account;
import org.springframework.stereotype.Repository;

@Repository
public class AccountDAOimpl implements AccountDAO{

    private String name;

    private String serviceCode;

    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my db work by adding an account");
    }

    @Override
    public void addAccount(Account theAccount) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }
}