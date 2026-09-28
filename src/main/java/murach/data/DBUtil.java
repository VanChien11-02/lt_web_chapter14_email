/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package murach.data;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author hp
 */
public class DBUtil {
    private static final EntityManagerFactory emf;

    static {
        Map<String, String> configOverrides = new HashMap<>();

        String dbUrl = System.getenv("JDBC_DATABASE_URL");
        String dbUser = System.getenv("JDBC_DATABASE_USERNAME");
        String dbPassword = System.getenv("JDBC_DATABASE_PASSWORD");

        if (dbUrl != null && !dbUrl.trim().isEmpty()) {
            configOverrides.put("jakarta.persistence.jdbc.url", dbUrl);
        }
        if (dbUser != null && !dbUser.trim().isEmpty()) {
            configOverrides.put("jakarta.persistence.jdbc.user", dbUser);
        }
        if (dbPassword != null && !dbPassword.trim().isEmpty()) {
            configOverrides.put("jakarta.persistence.jdbc.password", dbPassword);
        }

        emf = Persistence.createEntityManagerFactory("emailListPU", configOverrides);
    }
    
    public static EntityManagerFactory getEmFactory(){
        return emf;
    }
}
