package ru.geekbrains;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import ru.geekbrains.dao.CustomerDao;
import ru.geekbrains.dao.ProductDaoImpl;
import ru.geekbrains.services.PurchaseHistoryService;
import ru.geekbrains.session.SessionFactoryUtils;


@SpringBootApplication
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

    }
}
