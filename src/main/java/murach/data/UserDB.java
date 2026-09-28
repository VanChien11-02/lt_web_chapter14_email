/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.data;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import murach.bussines.Users;

/**
 *
 * @author hp
 */
public class UserDB {
    public static void insert(Users user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();        
        try {
            em.persist(user);
            trans.commit();
        } catch (Exception e) {
            System.out.println(e);
            trans.rollback();
        } finally {
            em.close();
        }
    }
    
    public static void update(Users user) {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.merge(user); 
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
            trans.rollback();
        } finally{
            em.close();
        }
    }
    
    public static void delete(String email) {
        Users user = selectUser(email);
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        EntityTransaction trans = em.getTransaction();
        trans.begin();
        try{
            em.remove(em.merge(user)); 
            trans.commit();
        } catch(Exception e){
            System.out.println(e);
            trans.rollback();
        } finally{
            em.close();
        }
    }
    
    public static Users selectUser(String email){
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        String qString = "select u From Users u " + 
                "where u.email = :email";
        TypedQuery<Users> q = em.createQuery(qString, Users.class);
        q.setParameter("email", email);
        try {
            Users user = q.getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        } finally {
            em.close();
        }
    }

    public static boolean emailExists(String email) {
        Users u = selectUser(email);
        return u != null;
    }  
}

