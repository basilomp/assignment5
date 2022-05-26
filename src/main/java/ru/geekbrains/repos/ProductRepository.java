package ru.geekbrains.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Product;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>, JpaSpecificationExecutor<Product> {

    @Query("select p from Product p where p.cost > :min and p.cost < :max order by p.cost desc")
    List<Product> findProductWithCostBetween(int min, int max);

    @Query("select p from Product p where p.id = :id")
    boolean productExistsById(Long id);

    @Query("update Product p set p.title = :title, p.cost = :cost where p.id = :id ")
    Product updateProduct(Long id, String title, int cost);
//    @Query("select p from Product p where p.cost < :cost")
//    List<Product> findProductByCostLessThan(int cost);

//    @Query("select p from Product p where p.cost > :cost")
//    List<Product> findProductByCostBiggerThan(int cost);
}
