package ru.geekbrains.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Product;
import ru.geekbrains.session.SessionFactoryUtils;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
@ComponentScan("ru.geekbrains.session")
public abstract class ProductDaoImpl implements Dao{

//    @Autowired
//    private SessionFactoryUtils sessionFactoryUtils;
//
//    public ProductDaoImpl(SessionFactoryUtils sessionFactoryUtils) {
//        this.sessionFactoryUtils = sessionFactoryUtils;
//    }
//
//
//    @Override
//    public Product findById(Long id) {
//        try (Session session = sessionFactoryUtils.getSession()){
//            session.beginTransaction();
//            Product product = session.get(Product.class, id);
//            session
//                    .getTransaction()
//                    .commit();
//            return product;
//        }
//    }
//
//    @Override
//    public List<Product> findAll() {
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            List<Product> products = session.createQuery("select p from Product p").getResultList();
//            session.getTransaction().commit();
//            return products;
//        }
//    }
//
//    @Override
//    public void deleteById(Long id) {
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            Product product = session.get(Product.class, id);
//            session.delete(product);
//            session.getTransaction().commit();
//        }
//    }
//
//    @Override
//    public Product saveOrUpdate(Product product) {
//        try (Session session = sessionFactoryUtils.getSession()) {
//            session.beginTransaction();
//            session.saveOrUpdate(product);
//            session.getTransaction().commit();
//            return product;
//        }
//    }
//

}
