package ru.geekbrains.homework6.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.geekbrains.homework6.model.Product;
import ru.geekbrains.homework6.service.Service;

import java.util.List;

@Component
public class ProductDao {
    private List<Product> products;

    @Autowired
    private Service service;

    public Product findById(Long id) {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, id);
            session.getTransaction().commit();
            return product;
        }
    }


    public List<Product> findAll() {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            List<Product> products = (List<Product>) session.createQuery("from Product").getResultList();
            session.getTransaction().commit();
            return products;
        }
    }


    public void deleteById(Long id) {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.createQuery("DELETE FROM Product p WHERE p.id = :id").setParameter("id", id).executeUpdate();
            session.getTransaction().commit();
        }
    }


    public Product saveOrUpdate(Product product) {
        try (Session session = service.getFactory().getCurrentSession()) {
            session.beginTransaction();
            session.saveOrUpdate(product);
            session.getTransaction().commit();
            return product;
        }
    }
}
