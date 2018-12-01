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

/**
 *
 * @author chellong
 */
public class CustomerModel {
    public int add(Customer cus) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "INSERT INTO users(name, email, password) VALUES(?,?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, cus.getName());
        pstmt.setString(1, cus.getEmail());
        pstmt.setString(2, cus.getPassword());
        return pstmt.executeUpdate();
    }
}
