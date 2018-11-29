/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.model;

import com.starter.bean.User;
import com.starter.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class UserModel {

    public List<User> getAll() throws Exception {
        Connection conn = DBConnector.getConnection();
        List<User> list = new ArrayList<>();
        String sql = "SELECT * FROM users";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            User c = new User();
            c.setId(rs.getInt(1));
            c.setUsername(rs.getString(2));
            c.setPassword(rs.getString(3));
            list.add(c);
        }
        return list;
    }

    public int add(User c) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "INSERT INTO users(username, password) VALUES(?,?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, c.getUsername());
        pstmt.setString(2, c.getPassword());
        return pstmt.executeUpdate();
    }

    public int update(User c) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "UPDATE users SET username = ? , password = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, c.getUsername());
        pstmt.setString(2, c.getPassword());
        pstmt.setInt(3, c.getId());
        return pstmt.executeUpdate();
    }

    public int delete(int id) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "DELETE FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        return pstmt.executeUpdate();
    }

    public User getById(int id) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "SELECT * FROM users WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        User c = new User();
        while (rs.next()) {
            c.setId(rs.getInt("id"));
            c.setUsername(rs.getString("username"));
            c.setPassword(rs.getString("password"));
        }
        return c;
    }

}
