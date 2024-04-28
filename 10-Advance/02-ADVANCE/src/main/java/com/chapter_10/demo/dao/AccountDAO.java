package com.chapter_10.demo.dao;

import com.chapter_10.demo.Account;

import java.util.List;

public interface AccountDAO {

    List<Account> findAccounts();
    void addAccount();

    void addAccount(Account theAccount);

    public String getName();

    public void setName(String name);
    public String getServiceCode();

    public void setServiceCode(String serviceCode);

    List<Account> findAccounts(boolean tripWire);
}
