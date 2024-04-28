package com.chapter_10.demo.dao;

import com.chapter_10.demo.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Account> findAccounts() {
        return findAccounts(false);
    }

    @Override
    public List<Account> findAccounts(boolean tripWire) {

        if(tripWire){
            throw new RuntimeException("No soup for you!");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Madhu", "gold");
        Account temp3 = new Account("luca", "nem");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
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