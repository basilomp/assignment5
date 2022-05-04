package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dao.ProductDaoImpl;
import ru.geekbrains.entity.Product;

import java.util.List;

@RestController
public class MainController {

    @Autowired
    private ProductDaoImpl productDaoImpl;

    @GetMapping("/products")
    public List<Product> getProducts() {
        return productDaoImpl.findAll();
    }

    @DeleteMapping ("/products/remove")
    public void removeFromList(@RequestParam("id") Long id) {
        productDaoImpl.deleteById(id);
    }
}
