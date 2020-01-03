package com.study.web.jpa;

import com.study.web.jpa.entity.User;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPATest_Update2 {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();
        System.out.println(em);

        // 取得目標 User
        User user = em.find(User.class, 1L);
        System.out.println("修改前: " + user);
        if (user != null) {
            // 修改 Entity
            user.setName("John2");
            user.setAge(40);
            System.out.println("修改後: " + user);
            user = em.find(User.class, 1L);
            System.out.println("修改後重抓: " + user);
            
            // 斷線
            em.detach(user);

            // 傳入資料庫
            try {
                em.getTransaction().begin();
                em.persist(user);
                em.getTransaction().commit();
            } catch (Exception e) {
                System.out.println("detach 無法修改");
            }

            // 合併
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();

            System.out.println("Update Ok");

        } else {
            System.out.println("無此資料");
        }

        em.close();
    }
}