/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.model;

import com.starter.bean.Item;
import com.starter.bean.Store;
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
public class ItemModel implements IModel<Item> {
    private Connection conn;
    public ItemModel() throws Exception {
        conn = DBConnector.getConnection();
    }
    
    @Override
    public List<Item> getAll() throws Exception {
        
        List<Item> list = new ArrayList<>();
        String sql = "select * from ITEM";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Item item = new Item.ItemBuilder(rs.getString("status"))
                    .setIdItem(rs.getInt("idItem"))
                    .setIdProduct(rs.getInt("idProduct"))
                    .setPrice(rs.getDouble("price"))
                    .setUrlImage(rs.getString("urlImage"))
                    .setNote(rs.getString("note"))
                    .build();
            System.out.println("item " + item);
            list.add(item);
        }
        return list;
    }

    @Override
    public int add(Item t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Item c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Item getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public int getCountPage() throws Exception{
       String sql = "SELECT COUNT('*') as count FROM ITEM";
       PreparedStatement statement = conn.prepareStatement(sql);
       ResultSet rs = statement.executeQuery();
       if(rs.next()) {
           return rs.getInt("count");
       }
       return 0;
    }

    public List<Item> getItemPerPage(int offset, int limit) throws Exception {
        List<Item> list = new ArrayList<>();
        String sql = "select * from ITEM limit ?,?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setInt(1, offset);
        statement.setInt(2, limit);
        ResultSet rs = statement.executeQuery();
        while(rs.next()) {
            Item item = new Item.ItemBuilder(rs.getString("status"))
                    .setIdItem(rs.getInt("idItem"))
                    .setIdProduct(rs.getInt("idProduct"))
                    .setPrice(rs.getDouble("price"))
                    .setUrlImage(rs.getString("urlImage"))
                    .setNote(rs.getString("note"))
                    .build();
            list.add(item);
        }
        return list;
    }
    
    
}
