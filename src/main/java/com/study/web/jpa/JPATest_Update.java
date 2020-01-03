package com.study.web.jpa;

import com.study.web.jpa.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest_Update {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();
        System.out.println(em);

        // 取得目標 User
        User user = em.find(User.class, 1L);
        System.out.println("修改前: " + user);
        if (user != null) {
            // 修改 Entity
            user.setName("John");
            user.setAge(30);
            System.out.println("修改後: " + user);
            user = em.find(User.class, 1L);
            System.out.println("修改後重抓: " + user);
            
            // 正常修改
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
            
            System.out.println("Update Ok");

        } else {
            System.out.println("無此資料");
        }

        em.close();
    }
}