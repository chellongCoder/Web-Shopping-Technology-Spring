/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.model;

import com.starter.bean.Customer;
import com.starter.bean.User;
import com.starter.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author chellong
 */
public class CustomerModel {
    public static final int LOOP_HASH = 4;
    
    public static int add(Customer cus) throws Exception {
        System.out.println("====================");
        System.out.println("cus " + cus);
        System.out.println("====================");
        String hashPassword = CustomerModel.hashPassword(cus.getPassword());
        System.out.println("Hash " + hashPassword);
        Connection conn = DBConnector.getConnection();
        String sql = "INSERT INTO CUSTOMER(email, password, name) VALUES(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cus.getEmail());
        pstmt.setString(2, hashPassword);
        pstmt.setString(3, cus.getName());
        return pstmt.executeUpdate();
    }
    
    public static Customer login (String email, String password) throws Exception {
         Connection conn = DBConnector.getConnection();
        String sql = "SELECT * FROM CUSTOMER WHERE email = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, email);
        ResultSet rs = pstmt.executeQuery();
        
        while(rs.next()) {
            Customer cus = new Customer.CustomerBuilder(rs.getString("email"), rs.getString("password"), rs.getString("name")).build();
            if(checkPassword(password, cus.getPassword())) {
                return cus;
            }
        }
        return null;
    }
    
    public static String hashPassword (String pass) {
        return BCrypt.hashpw(pass, BCrypt.gensalt(LOOP_HASH));
    }
    
    public static boolean checkPassword (String password, String hashPassword) {
        return BCrypt.checkpw(password, hashPassword);
    }
    
}
