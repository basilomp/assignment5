package ru.geekbrains.repos.specification;

import org.springframework.data.jpa.domain.Specification;
import ru.geekbrains.entity.Product;

public class ProductSpecification {

    public static Specification<Product> findProductWithCostBetween(int min, int max) {
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("cost"), min, max);
    }
}
