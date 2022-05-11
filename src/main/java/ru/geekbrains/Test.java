package ru.geekbrains;

import ru.geekbrains.dao.ProductDaoImpl;
import ru.geekbrains.services.PurchaseHistoryService;
import ru.geekbrains.session.SessionFactoryUtils;

public class Test {
    public static void main(String[] args) {
        SessionFactoryUtils sessionFactoryUtils = new SessionFactoryUtils();
        PurchaseHistoryService purchaseHistoryService = new PurchaseHistoryService(sessionFactoryUtils);

//        **Acquire the list of products for the customer with 'id' = 1
//        CustomerDao customerDao = new CustomerDao(sessionFactoryUtils);
//        purchaseHistoryService.getPurchasedProducts(1L);


//        **Acquire the list of customers for the product with 'id' = 15
        ProductDaoImpl productDao = new ProductDaoImpl(sessionFactoryUtils);
        purchaseHistoryService.getProductCustomers(15L);
    }
}
