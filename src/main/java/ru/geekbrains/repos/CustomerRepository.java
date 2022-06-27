package ru.geekbrains.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
