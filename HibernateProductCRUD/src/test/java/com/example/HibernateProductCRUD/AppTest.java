package com.example.HibernateProductCRUD;

import org.hibernate.Session;
import org.junit.Test;

import com.example.util.HibernateUtil;

public class AppTest {

    @Test
    public void testHibernateConnection() {

        Session session = HibernateUtil.getSessionFactory().openSession();

        if (session != null) {
            System.out.println("Hibernate Session Created Successfully");
        }

        session.close();
    }
}