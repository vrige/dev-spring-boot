package com.chapter_10.demo.dao;

import org.springframework.stereotype.Repository;

@Repository
public class MemberDAOimpl implements MemberDAO{
    @Override
    public void addAccount() {
        System.out.println(getClass() + ": Doing my db work by adding a MEmbership account");
    }
}