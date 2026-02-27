package com.example.main;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.example.entity.Product;
import com.example.util.HibernateUtil;

public class ProductCRUD {

    public static void main(String[] args) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // CREATE (Insert Products)

        Product p1 = new Product("Laptop","Dell Laptop",55000,10);
        Product p2 = new Product("Mobile","Samsung Galaxy",25000,20);
        Product p3 = new Product("Headphones","Sony Headphones",5000,15);
        Product p4 = new Product("Keyboard","Mechanical Keyboard",3000,30);
        Product p5 = new Product("Mouse","Wireless Mouse",1500,40);

        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save(p5);

        tx.commit();
        session.close();

        System.out.println("5 Products Inserted Successfully");



        // READ (Retrieve product by ID)

        session = HibernateUtil.getSessionFactory().openSession();

        Product product = session.get(Product.class, 1);

        if(product != null){
            System.out.println("Retrieved Product: " + product);
        }

        session.close();



        // UPDATE (Update price and quantity)

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Product updateProduct = session.get(Product.class, 1);

        if(updateProduct != null){
            updateProduct.setPrice(60000);
            updateProduct.setQuantity(12);

            session.update(updateProduct);
        }

        tx.commit();
        session.close();

        System.out.println("Product Updated Successfully");



        // DELETE (Delete discontinued product)

        session = HibernateUtil.getSessionFactory().openSession();
        tx = session.beginTransaction();

        Product deleteProduct = session.get(Product.class, 5);

        if(deleteProduct != null){
            session.delete(deleteProduct);
        }

        tx.commit();
        session.close();

        System.out.println("Product Deleted Successfully");
    }
}