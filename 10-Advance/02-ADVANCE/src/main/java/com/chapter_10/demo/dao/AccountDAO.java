package com.chapter_10.demo.dao;

import com.chapter_10.demo.Account;

public interface AccountDAO {

    void addAccount();

    void addAccount(Account theAccount);

    public String getName();

    public void setName(String name);
    public String getServiceCode();

    public void setServiceCode(String serviceCode);
}
