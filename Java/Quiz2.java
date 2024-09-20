
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "person_type", discriminatorType = DiscriminatorType.STRING)
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String phone;

    // getters and setters
}

@Entity
@DiscriminatorValue("Employee")
public class Employee extends Person {
    private int employeeId;
    private Date hireDate;

    // getters and setters
}

@Entity
@DiscriminatorValue("Customer")
public class Customer extends Person {
    private int customerId;
    private Date registrationDate;

    // getters and setters
}


Employee employee = new Employee();
employee.setName("John Doe");
employee.setEmail("john@example.com");
employee.setPhone("555-1234");
employee.setEmployeeId(1001);
employee.setHireDate(new Date());

Customer customer = new Customer();
customer.setName("Alice Smith");
customer.setEmail("alice@example.com");
customer.setPhone("555-5678");
customer.setCustomerId(2001);
customer.setRegistrationDate(new Date());

// Save the entities
Session session = sessionFactory.openSession();
session.beginTransaction();
session.save(employee);
session.save(customer);
session.getTransaction().commit();
session.close();


--Object-relational mapping (ORM) frameworks like Hibernate or JPA (Java Persistence API). 
 @Entity is used in JPA


--Task
package com.codility.domain;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public abstract class Task {
    private Long id;
    private String name;
    private String author;

    Task(String name, String author) {
        this.name = name;
        this.author = author;
    }

    String getName() {
        return name;
    }
}


--Epic
package com.codility.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Epic extends Task{
    @Id
    @GeneratedValue
    private Long id;
    private Long projectId;
    private String productOwner;

    Epic(String name, String author, Long projectId, String productOwner) {
        this.projectId = projectId;
        this.productOwner = productOwner;
    }

    String getName() {
        return "NO NAME";
    }
}

-- Story

package com.codility.domain;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Story extends Task {
    @Id
    @GeneratedValue
    private Long id;
    private Long sprintId;

    Story(String name, String author, Long sprintId) {
        this.sprintId = sprintId;
    }

    String getName() {
        return "NO NAME";
    }
}

