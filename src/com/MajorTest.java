package com;

import com.hibernate.demo.User;
import com.hibernate.demo.UserEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class MajorTest {
    public static void main(String[] args) {

        //加载核心配置文件
        Configuration cfg=new Configuration();
        //解释配置文件
        cfg.configure();
        //获取连接工厂 sessionFactory
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        //从工厂中获取session
        Session session = sessionFactory.openSession();
        //开启事务
        session.beginTransaction();
        //持久化操作
        UserEntity user = new UserEntity();
        user.setId(1);
        user.setUsername("feirihai");
        user.setPassword("123");
        session.save(user);
        //提交事务
        session.getTransaction().commit();

        //关闭session
        session.close();
        //关闭sessionFactor
        sessionFactory.close();
    }


}
