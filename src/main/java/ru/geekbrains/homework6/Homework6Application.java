package ru.geekbrains.homework6;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.geekbrains.homework6.dao.BuyerDao;
import ru.geekbrains.homework6.dao.ProductDao;
import ru.geekbrains.homework6.model.Buyer;
import ru.geekbrains.homework6.model.Product;
import ru.geekbrains.homework6.service.AppConfig;

import java.util.List;

@SpringBootApplication
public class Homework6Application {

	public static void main(String[] args) {
		//SpringApplication.run(Homework6Application.class, args);
		AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);

		ProductDao productDao = applicationContext.getBean(ProductDao.class);
		BuyerDao buyerDao = applicationContext.getBean(BuyerDao.class);
		Product productF = productDao.findById(2L);
		System.out.println(productF);
		System.out.println("_____________________");
		System.out.println(productF.getBuyers());

		Buyer buyerN = buyerDao.findById(1L);
		System.out.println(buyerN);
		System.out.println("_____________________");
		System.out.println(buyerN.getProducts());
		applicationContext.close();
	}
}
