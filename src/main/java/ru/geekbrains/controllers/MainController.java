package ru.geekbrains.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.dto.ProductDto;
import ru.geekbrains.entity.Product;
import ru.geekbrains.services.CustomerService;
import ru.geekbrains.services.ProductService;

import java.util.List;

@RestController
@RequestMapping("/app/api/v1/products")
public class MainController {

    @Autowired
    private ProductService productService;

    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ProductDto findProduct(@PathVariable Long id) {
        return productService.findById(id);
    }


//    @GetMapping("/products")
//    public List<Product> getProducts() {
//        return productService.getAllProducts();
//    }


    @GetMapping()
    public Page<Product> getProducts(@RequestParam(name = "p", defaultValue = "1") Integer page) {
        if(page < 1) {
            page = 1;
        }
        return productService.find(page);
    }

    @PostMapping()
    public Product createProduct(@RequestBody Product product) {
        if(product.getId() != null) {
            product.setId(null);
        }
        return productService.addProduct(product);
    }

    @DeleteMapping ("/remove")
    public void removeFromList(@RequestParam("id") Long id) {
        productService.deleteById(id);
    }

    @PutMapping()
    public Product updateStudent(@RequestBody Product product) {
        return productService.addProduct(product);
    }
    @GetMapping("/findBetween")
    public List<Product> findByCostBetween(@RequestParam(name = "min", defaultValue = "0") int min,
                                           @RequestParam(name = "max") int max) {
        System.out.println(productService.findByCostBetween(min, max));
        return productService.findByCostBetween(min, max);
    }

//    public Product updateProduct(@RequestBody Product product) {
//        return productService.creat
//    }

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
