package com.hz.community;

import com.hz.community.dao.AlphaDao;
import com.hz.community.service.AlphaService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.security.Signature;
import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class) //希望启用和正式环境一样的那个CommunityApplication为配置类
class CommunityApplicationTests implements ApplicationContextAware { //哪个类想得到spring容器就实现这个接口

    private ApplicationContext applicationContext; //记录spring容器   容器管理bean

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Test
    public void testApplicationContext(){  //测试spring容器
        System.out.println(applicationContext);

        AlphaDao alphaDao = applicationContext.getBean(AlphaDao.class); //依赖的是接口，好处：实现类就不用动
        System.out.println(alphaDao.select());

        alphaDao = applicationContext.getBean("alphaHibernate", AlphaDao.class);//通过类名获取,再转型成它
        System.out.println(alphaDao.select());
    }

    @Test
    public void testBeanManagement(){ //被spring容器管理的bean默认是属于单例的，只实例化一次
        AlphaService alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);

        alphaService = applicationContext.getBean(AlphaService.class);
        System.out.println(alphaService);
    }

    @Test
    public void testBeanConfig(){
        SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
        System.out.println(simpleDateFormat.format(new Date()));
    }

    //依赖注入的方式： 声明一个属性，写一个Autowired注解，这个bean就有了，可以直接用

    @Autowired //依赖注入  加在一个成员变量（属性）之前即可  希望spring容器将AlphaDao注入给alphaDao这个属性    也可加在类的构造器前面来注入 或者set方法前
    @Qualifier("alphaHibernate") //希望alphaDao注入的不是那个默认的优先级Primary，希望还是alphaHibernate这个名字的bean
    private AlphaDao alphaDao;  //当前bean依赖的是接口，底层的实现是不直接耦合的，降低了耦合度  很方便不用实例化

    @Autowired
    private AlphaService alphaService;

    @Autowired
    private SimpleDateFormat simpleDateFormat;

    @Test
    public void testDI(){ //测试依赖注入
        System.out.println(alphaDao);
        System.out.println(alphaService);
        System.out.println(simpleDateFormat);
    }

}
