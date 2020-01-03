package com.study.web.jpa;

import com.study.web.jpa.entity.User;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class JPATestQuery {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("demo");
        EntityManager em = emf.createEntityManager();

        List list = em.createQuery("Select u From User u").getResultList();
        System.out.println(list);

        List<User> list2 = em.createQuery("Select u From User u", User.class).getResultList();
        System.out.println(list2);

        String sql = "SELECT u FROM User u WHERE u.age = :age";
        Query query = em.createQuery(sql);
        query.setParameter("age", 30);
        System.out.println(query.getResultList());
        
    }
}