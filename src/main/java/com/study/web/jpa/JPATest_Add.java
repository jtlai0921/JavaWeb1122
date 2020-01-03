package com.study.web.jpa;

import com.study.web.jpa.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest_Add {
    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();
        System.out.println(em);
        
        // 建立 User entity 物件
        User user = new User();
        user.setName("vin");
        user.setAge(18);
        
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();
        
        em.close();
    }
}