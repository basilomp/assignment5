package ru.geekbrains.session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Component;


@Component
public class SessionFactoryUtils {

    private SessionFactory sessionFactory;

    public SessionFactoryUtils() {
    }

    public void init() {
            sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .buildSessionFactory();
}

    public Session getSession() {
        init();
        sessionFactory.openSession();
        return sessionFactory.getCurrentSession();
    }

    public void shutdown() {
        if(sessionFactory != null) {
            sessionFactory.close();
        }
    }

}
