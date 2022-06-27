package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.entity.Product;
import ru.geekbrains.repos.ProductRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow();
    }

    public Product createProduct(String title, int cost) {
        return productRepository.save(new Product(title, cost));
    }

    public List<Product> findByCostBetween(int min, int max) {
        return productRepository.findProductWithCostBetween(min, max);
    }

//    public List<Product> findByCostBiggerThan(int min) {
//        return productRepository.findProductByCostBiggerThan(min);
//    }
//
//    public List<Product> findByCostLessThan(int max) {
//        return productRepository.findProductByCostLessThan(max);
//    }

}
