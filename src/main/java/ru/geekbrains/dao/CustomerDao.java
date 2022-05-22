package ru.geekbrains.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Customer;
import ru.geekbrains.entity.Product;
import ru.geekbrains.session.SessionFactoryUtils;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@ComponentScan("ru.geekbrains.session")
public class CustomerDao {

//    @Autowired
//    private SessionFactoryUtils sessionFactoryUtils;
//
//    public CustomerDao(SessionFactoryUtils sessionFactoryUtils) {
//        this.sessionFactoryUtils = sessionFactoryUtils;
//    }
//
//
//    public Customer findById(Long id) {
//        try (Session session = sessionFactoryUtils.getSession()){
//            session.beginTransaction();
//            Customer customer = session.get(Customer.class, id);
//            session
//                    .getTransaction()
//                    .commit();
//            return customer;
//        }
//    }
//
//    public List<Customer> findAll() {
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            List<Customer> customers = session.createQuery("select c from Customer c").getResultList();
//            session.getTransaction().commit();
//            return customers;
//        }
//    }
//
//    public void deleteById(Long id) {
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            Customer customer = session.get(Customer.class, id);
//            session.delete(customer);
//            session.getTransaction().commit();
//        }
//    }
//
//    public Customer saveOrUpdate(Customer customer) {
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            session.saveOrUpdate(customer);
//            session.getTransaction().commit();
//            return customer;
//        }
//    }
}

