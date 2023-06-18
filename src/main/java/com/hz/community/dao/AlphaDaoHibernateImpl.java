package com.hz.community.dao;

import org.springframework.stereotype.Repository;

@Repository("alphaHibernate") //括号里可给bean重新自定义名字
public class AlphaDaoHibernateImpl implements AlphaDao{
    @Override
    public String select() {
        return "Hibernate";
    }
}
