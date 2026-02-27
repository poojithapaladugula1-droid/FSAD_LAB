# HibernateProductCRUD

## Description
This project demonstrates CRUD operations using Hibernate and MySQL.  
It includes:

- Product entity mapped with JPA annotations
- Hibernate configuration
- ID generation strategies tested (AUTO, IDENTITY, SEQUENCE)
- CRUD operations implemented in `ProductCRUD.java`

## Technologies
- Java 11
- Hibernate 5.6
- MySQL 8
- Maven

## Steps to Run
1. Update `hibernate.cfg.xml` with your MySQL credentials.
2. Run `ProductCRUD.java`.
3. Verify table `product` in MySQL.
4. Observe CRUD operations:

   - 5 products inserted  
   - Product with id = 1 retrieved and updated  
   - Product with id = 5 deleted

## Notes
- Table is truncated before testing to avoid duplicates.
- Tested ID strategies:
  - AUTO
  - IDENTITY
  - SEQUENCE