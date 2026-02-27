package com.example.main;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import com.example.entity.Product;
import com.example.util.HibernateUtil;

public class ProductHQLDemo {

    public static void main(String[] args) {

        // 1️⃣ Open Hibernate session and transaction
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        // 2️⃣ HQL Queries

        // --- 3. Retrieve all products sorted by price ---
        System.out.println("=== Products by Price Ascending ===");
        List<Product> productsAsc = session.createQuery("FROM Product ORDER BY price ASC", Product.class)
                                           .getResultList();
        productsAsc.forEach(System.out::println);

        System.out.println("\n=== Products by Price Descending ===");
        List<Product> productsDesc = session.createQuery("FROM Product ORDER BY price DESC", Product.class)
                                            .getResultList();
        productsDesc.forEach(System.out::println);

        // --- 4. Sort products by quantity (highest first) ---
        System.out.println("\n=== Products by Quantity Desc ===");
        List<Product> productsByQuantity = session.createQuery("FROM Product ORDER BY quantity DESC", Product.class)
                                                  .getResultList();
        productsByQuantity.forEach(System.out::println);

        // --- 5. Pagination ---
        System.out.println("\n=== First 3 Products ===");
        List<Product> first3 = session.createQuery("FROM Product ORDER BY id ASC", Product.class)
                                      .setFirstResult(0)
                                      .setMaxResults(3)
                                      .getResultList();
        first3.forEach(System.out::println);

        System.out.println("\n=== Next 3 Products ===");
        List<Product> next3 = session.createQuery("FROM Product ORDER BY id ASC", Product.class)
                                     .setFirstResult(3)
                                     .setMaxResults(3)
                                     .getResultList();
        next3.forEach(System.out::println);

        // --- 6. Aggregate operations ---
        Long totalProducts = session.createQuery("SELECT COUNT(*) FROM Product", Long.class).getSingleResult();
        System.out.println("\nTotal Products: " + totalProducts);

        Long quantityPositive = session.createQuery("SELECT COUNT(*) FROM Product WHERE quantity > 0", Long.class)
                                       .getSingleResult();
        System.out.println("Products with quantity > 0: " + quantityPositive);

        Double minPrice = session.createQuery("SELECT MIN(price) FROM Product", Double.class).getSingleResult();
        Double maxPrice = session.createQuery("SELECT MAX(price) FROM Product", Double.class).getSingleResult();
        System.out.println("Min Price: " + minPrice + ", Max Price: " + maxPrice);

        System.out.println("\n=== Count by Description ===");
        List<Object[]> countByDescription = session.createQuery(
                "SELECT description, COUNT(*) FROM Product GROUP BY description")
                .getResultList();
        for (Object[] row : countByDescription) {
            System.out.println("Description: " + row[0] + ", Count: " + row[1]);
        }

        // --- 7. Group by description ---
        System.out.println("\n=== Products Grouped by Description ===");
        List<Object[]> groupByDescription = session.createQuery(
                "SELECT description, COUNT(*) FROM Product GROUP BY description")
                .getResultList();
        for (Object[] row : groupByDescription) {
            System.out.println("Description: " + row[0] + ", Count: " + row[1]);
        }

        // --- 8. Filter products within a price range ---
        System.out.println("\n=== Products with Price between 10000 and 50000 ===");
        List<Product> productsInRange = session.createQuery(
                "FROM Product WHERE price BETWEEN 10000 AND 50000", Product.class)
                .getResultList();
        productsInRange.forEach(System.out::println);

        // --- 9. LIKE queries ---
        System.out.println("\n=== Names starting with 'L' ===");
        List<Product> namesStartL = session.createQuery(
                "FROM Product WHERE name LIKE 'L%'", Product.class)
                .getResultList();
        namesStartL.forEach(System.out::println);

        System.out.println("\n=== Names ending with 'e' ===");
        List<Product> namesEndE = session.createQuery(
                "FROM Product WHERE name LIKE '%e'", Product.class)
                .getResultList();
        namesEndE.forEach(System.out::println);

        System.out.println("\n=== Names containing 'top' ===");
        List<Product> namesContainTop = session.createQuery(
                "FROM Product WHERE name LIKE '%top%'", Product.class)
                .getResultList();
        namesContainTop.forEach(System.out::println);

        System.out.println("\n=== Names with exactly 6 characters ===");
        List<Product> namesLength6 = session.createQuery(
                "FROM Product WHERE LENGTH(name) = 6", Product.class)
                .getResultList();
        namesLength6.forEach(System.out::println);

        // 3️⃣ Commit and close session
        tx.commit();
        session.close();
        HibernateUtil.getSessionFactory().close();
    }
}