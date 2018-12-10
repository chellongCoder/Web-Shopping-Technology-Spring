/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.model;

import com.starter.bean.Product;
import com.starter.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chellong
 */
public class ProductModel implements IModel<Product> {
     private Connection conn;
    public ProductModel() throws Exception {
        conn = DBConnector.getConnection();
    }
    
    @Override
    public List<Product> getAll() throws Exception {
        List<Product> list = new ArrayList<>();
        String sql = "SELECT * FROM PRODUCT";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Product product = new Product.ProductBuilder(rs.getInt("idProduct"), rs.getInt("idStore"), rs.getString("nameProduct")).build();
            list.add(product);
        }
        return list;      
    }

    @Override
    public int add(Product t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Product c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public List<Product> selectProductByTypeStore(String type) throws Exception {
        List<Product> list = new ArrayList<>();
        String sql = "select * from PRODUCT join STORE on PRODUCT.`idStore` = STORE.`idStore` where STORE.`type` like ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%"+type+"%");
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Product product = new Product.ProductBuilder(rs.getInt("idProduct"), rs.getInt("idStore"), rs.getString("nameProduct"))
                    .setQuantity(10)
                    .build();
            list.add(product);
        }
        return list;
    }
    
}
