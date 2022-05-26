package ru.geekbrains.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.entity.Product;
import ru.geekbrains.exceptions.AppError;
import ru.geekbrains.repos.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Page<Product> find(Integer p) {
        Specification<Product> spec = Specification.where(null);
        return productRepository.findAll(spec, PageRequest.of(p -1, 5));
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public ProductDto findById(Long id) {
        return productRepository.findById(id).map(p -> new ProductDto(p)).orElseThrow();
    }

//    public Product createProduct(String title, int cost) {
//        return productRepository.save(new Product(title, cost));
//    }

    public Product addProduct(Product product) {
        return productRepository.save(product);
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
