package ru.geekbrains.homework6.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.geekbrains.homework6.model.Buyer;
import ru.geekbrains.homework6.model.Buyer;
import ru.geekbrains.homework6.service.Service;

import java.util.List;

@Component
public class BuyerDao {
    @Autowired
    private Service service;

    public Buyer findById(Long id) {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            session.getTransaction().commit();
            return buyer;
        }
    }


    public List<Buyer> findAll() {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Buyer> buyers = (List<Buyer>) session.createQuery("from Buyer").getResultList();
            session.getTransaction().commit();
            return buyers;
        }
    }


    public void deleteById(Long id) {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Buyer b WHERE b.id = :id").setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
        }
    }


    public Buyer saveOrUpdate(Buyer buyer) {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(buyer);
            session.getTransaction().commit();
            return buyer;
        }
    }

    public void printBasket(Long id) {
        try (Session session = service.getFactory().getCurrentSession()){
            session.beginTransaction();
            Buyer buyer = session.get(Buyer.class, id);
            System.out.println(buyer);
            session.getTransaction().commit();
        }
    }
}
