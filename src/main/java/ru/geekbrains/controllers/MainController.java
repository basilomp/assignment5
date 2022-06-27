package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.entity.Product;
import ru.geekbrains.services.CustomerService;
import ru.geekbrains.services.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping()
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/products/{id}")
    public Product findProduct(@PathVariable Long id) {
        return productService.findById(id);
    }


    @GetMapping("/products")
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/products")
    public Product createProduct(@RequestParam String title, int cost) {
        return productService.createProduct(title, cost);
    }

    @DeleteMapping ("/products/remove")
    public void removeFromList(@RequestParam("id") Long id) {
        productService.deleteById(id);
    }

    @GetMapping("/products/findBetween")
    public List<Product> findByCostBetween(@RequestParam(name = "min", defaultValue = "0") int min,
                                           @RequestParam(name = "max") int max) {
        System.out.println(productService.findByCostBetween(min, max));
        return productService.findByCostBetween(min, max);
    }

//    @GetMapping("/products/findLessExpensive")
//    public List<Product> findLessExpensive(@RequestParam int max) {
//        return productService.findByCostLessThan(max);
//    }
//
//    @GetMapping("/products/findMoreExpensive")
//    public List<Product> findMoreExpensive(@RequestParam int min) {
//        return productService.findByCostBiggerThan(min);
//    }

}
