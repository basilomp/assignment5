package ru.geekbrains.dao;

import org.springframework.stereotype.Component;
import ru.geekbrains.entity.Product;

import java.util.List;

public interface Dao {

    Product findById(Long id);

//    Product findByTitle(String title);

    List<Product> findAll();

    void deleteById(Long id);

    Product saveOrUpdate(Product product);
}
