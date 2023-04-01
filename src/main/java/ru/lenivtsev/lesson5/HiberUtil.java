package ru.lenivtsev.lesson5;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HiberUtil {
    private static final SessionFactory sessionFactory = build();

    private static SessionFactory build() {
        return new Configuration().configure().buildSessionFactory();
    }

    public static SessionFactory getSessionFactory(){
        return sessionFactory;
    }

    public static void sessionFactoryClose(){
        sessionFactory.close();
    }
}
