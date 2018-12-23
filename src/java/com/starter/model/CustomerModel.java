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
import java.util.ArrayList;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author chellong
 */
public class CustomerModel implements IModel<Customer> {
    public static final int LOOP_HASH = 4;
     private Connection conn;
    private static CustomerModel instance;
    
    private CustomerModel() throws Exception {
        conn = DBConnector.getConnection();
    }
    
    public static CustomerModel getInstance() throws Exception {
        if(CustomerModel.instance == null) {
            CustomerModel.instance = new CustomerModel();
        }
        return CustomerModel.instance;
    }
    @Override
    public int add(Customer cus) throws Exception {
        
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
    
     public int getCountPage() throws Exception {
        String sql = "SELECT COUNT('*') as count FROM CUSTOMER";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }
     public List<Customer> getCustomerPerPage(int offset, int limit) throws Exception {
        List<Customer> list = new ArrayList<>();
        String sql = "select * from CUSTOMER limit ?,?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, offset);
        statement.setInt(2, limit);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
            Customer cus = new Customer.CustomerBuilder(rs.getString("email"), rs.getString("password"), rs.getString("name"))
                    .setUsername(rs.getString("username"))
                    .setAbout(rs.getString("about"))
                    .setAddress(rs.getString("address"))
                    .setCity(rs.getString("city"))
                    .setIdCustomer(rs.getInt("idCustomer"))
                    .setPostcode(rs.getInt("postcode"))
                    .setTypeCustomer(rs.getString("typeCustomer"))
                    .build();
            list.add(cus);
        }
        return list;
    }

    
    public static String hashPassword (String pass) {
        return BCrypt.hashpw(pass, BCrypt.gensalt(LOOP_HASH));
    }
    
    public static boolean checkPassword (String password, String hashPassword) {
        return BCrypt.checkpw(password, hashPassword);
    }

    @Override
    public List<Customer> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Customer c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Customer getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
