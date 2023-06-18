package com.hz.community.service;

import com.hz.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
//@Scope("prototype") //每次访问bean都会创建一个新的实例
public class AlphaService {

    @Autowired  //要调用AlphaDao,则将其注入给AlphaService
    private AlphaDao alphaDao;

/*

    public AlphaService(){
        System.out.println("实例化AlphaService");
    }

    @PostConstruct //使此方法在构造器之后调用  可以用来初始化数据
    public void init(){
        System.out.println("初始化AlphaService");

    }

    @PreDestroy //此方法会在销毁之前调用  可以提前释放某些资源
    public void destroy(){
        System.out.println("销毁AlphaService");
    }
*/

    public String find(){
        return alphaDao.select();
    }
}
