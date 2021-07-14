package ru.geekbrains.homework6.service;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework6.initdb.InitDataBase;

import javax.annotation.PostConstruct;

@Component
public class Service {
    private SessionFactory factory;

    @PostConstruct
    public void init() {
        InitDataBase.forcePrepareData();
        factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .buildSessionFactory();

    }

    public SessionFactory getFactory() {
        return factory;
    }
}
