package ru.geekbrains.services;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.dao.CustomerDao;
import ru.geekbrains.dao.ProductDaoImpl;
import ru.geekbrains.entity.Customer;
import ru.geekbrains.entity.Product;
import ru.geekbrains.session.SessionFactoryUtils;

import java.util.List;

@Service
public class PurchaseHistoryService {

    @Autowired
    private ProductDaoImpl productDao;

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private SessionFactoryUtils sessionFactoryUtils;

    public PurchaseHistoryService(SessionFactoryUtils sessionFactoryUtils) {
        this.sessionFactoryUtils = sessionFactoryUtils;
    }

    public List<Product> getPurchasedProducts(Long customerId) {
        List<Product> purchasedProducts;
        try (Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Customer customer = session.get(Customer.class, customerId);
            purchasedProducts = customer.getProducts();
            System.out.println("Customer: " + customer.getName());
            System.out.println("Purchased products:");
            for (Product p : purchasedProducts) {
                System.out.println(p.getTitle());
            }
            session.getTransaction().commit();
        }
        return purchasedProducts;
    }

    public List<Customer> getProductCustomers(Long productId) {
        List<Customer> productCustomers;
        try(Session session = sessionFactoryUtils.getSession()) {
            session.beginTransaction();
            Product product = session.get(Product.class, productId);
            productCustomers = product.getCustomers();
            System.out.println("Product: " + product.getTitle());
            System.out.println("Purchased by:");
            for (Customer productCustomer : productCustomers) {
                System.out.println(productCustomer.getName());
            }
        }
        return productCustomers;
    }
}
