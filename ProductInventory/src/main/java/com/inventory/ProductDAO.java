package com.inventory;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ProductDAO {

	private SessionFactory factory;

	public ProductDAO() {
		factory = new Configuration().configure().buildSessionFactory();
	}

	public void addProduct(Product product) {

		Session session = factory.openSession();

		session.beginTransaction();

		session.persist(product);

		session.getTransaction().commit();

		session.close();

		System.out.println("Product added successfully");
	}

	public void viewProducts() {

		Session session = factory.openSession();

		List<Product> products = session.createQuery("from Product", Product.class).list();

		for (Product p : products) {
			System.out.println(p);
		}

		session.close();
	}

	public void updateProduct(int id, double price, int quantity) {

		Session session = factory.openSession();

		session.beginTransaction();

		Product product = session.get(Product.class, id);

		if (product != null) {
			product.setPrice(price);
			product.setQuantity(quantity);
			System.out.println("Product updated successfully");
		} else {
			System.out.println("Product not found");
		}

		session.getTransaction().commit();

		session.close();
	}

	public void deleteProduct(int id) {

		Session session = factory.openSession();

		session.beginTransaction();

		Product product = session.get(Product.class, id);

		if (product != null) {
			session.remove(product);
			System.out.println("Product deleted successfully");
		} else {
			System.out.println("Product not found");
		}

		session.getTransaction().commit();

		session.close();
	}
}
