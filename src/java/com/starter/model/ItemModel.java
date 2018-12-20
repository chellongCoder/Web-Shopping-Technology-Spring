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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chellong
 */
public class ItemModel implements IModel<Item> {

    private Connection conn;
    private static ItemModel instance = null;
    public static List<Integer> prices;

    private ItemModel() throws Exception {
        conn = DBConnector.getConnection();
    }

    public static ItemModel getInstance() throws Exception {
        if (ItemModel.instance == null) {
            ItemModel.instance = new ItemModel();
            prices = new ArrayList<>();
            prices.add(0);
            prices.add(1000);
            prices.add(1500);
            prices.add(2000);
            prices.add(2500);
            prices.add(3000);
        }
        return ItemModel.instance;
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

    public List<Item> getItemByTypeProduct(String product, int offset, int limit) throws Exception {
        List<Item> list = new ArrayList<>();
        String sql = "select * from ITEM join PRODUCT on ITEM.`idProduct` = PRODUCT.`idProduct` where PRODUCT.`nameProduct` like ? limit ?,?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + product + "%");
        statement.setInt(2, offset);
        statement.setInt(3, limit);
        ResultSet rs = statement.executeQuery();
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
    
    public List<Item> getItemByTypeProductAndPrice(String product, int min, int max, int offset, int limit) throws Exception {
        List<Item> list = new ArrayList<>();
        String sql = "select * from ITEM join PRODUCT on ITEM.`idProduct` = PRODUCT.`idProduct` where PRODUCT.`nameProduct` like ? and ITEM.`price` >= ? and ITEM.`price` <= ? limit ?,?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + product + "%");
        statement.setInt(2, min);
        statement.setInt(3, max);
        statement.setInt(4, offset);
        statement.setInt(5, limit);
        ResultSet rs = statement.executeQuery();
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
    
    public List<Item> getItemByPrice(int min, int max, int  offset, int limit) throws Exception {
       List<Item> list = new ArrayList<>();
       String sql = "select * from ITEM where ITEM.`price` >= ? and ITEM.`price` <= ? limit ?,?";
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setInt(1, min);
       statement.setInt(2, max);
       statement.setInt(3, offset);
       statement.setInt(4, limit);
       ResultSet rs = statement.executeQuery();
       while(rs.next()) {
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
    public int getCountItemByPrice(int min, int max) throws Exception {
       List<Item> list = new ArrayList<>();
       String sql = "select Count(\"*\") as count from ITEM where ITEM.`price` >= ? and ITEM.`price` <= ?";
       PreparedStatement statement = conn.prepareStatement(sql);
       statement.setInt(1, min);
       statement.setInt(2, max);
       ResultSet rs = statement.executeQuery();
       if (rs.next()) {
        return rs.getInt("count");
       }
        return 0;
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

    public int getCountPage() throws Exception {
        String sql = "SELECT COUNT('*') as count FROM ITEM";
        PreparedStatement statement = conn.prepareStatement(sql);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }

    public int getCountInStore(String type) throws Exception {
        String sql = "select COUNT(\"*\") as count from ITEM where ITEM.`idProduct` in (select PRODUCT.`idProduct` from PRODUCT join STORE on PRODUCT.`idStore` = STORE.`idStore` where STORE.`type` like ?)";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, type);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }
    
    public int getCountItemByTypeProductAndPrice(String product, int min, int max) throws Exception {
        String sql = "select COUNT(\"*\") as count from ITEM join PRODUCT on ITEM.`idProduct` = PRODUCT.`idProduct` where PRODUCT.`nameProduct` like ? and ITEM.`price` >= ? and ITEM.`price` <= ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + product + "%");
        statement.setInt(2, min);
        statement.setInt(3, max);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }
    
    public int getCountItemInStoreByPrice(String type, int max, int min) throws Exception {
        String sql = "select COUNT(\"*\") as count from ITEM where ITEM.`idProduct` in (select PRODUCT.`idProduct` from PRODUCT join STORE on PRODUCT.`idStore` = STORE.`idStore` where STORE.`type` like ?) and ITEM.`price` >= ? and ITEM.`price` <= ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%"+type+"%");
        statement.setInt(2, max);
        statement.setInt(3, min);
        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
            return rs.getInt("count");
        }
        return 0;
    }

    public int getCountInProduct(String type) throws Exception {
        String sql = "select COUNT(\"*\") as count from ITEM join PRODUCT on ITEM.`idProduct` = PRODUCT.`idProduct` where PRODUCT.`nameProduct` like ?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, type);

        ResultSet rs = statement.executeQuery();
        if (rs.next()) {
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
        while (rs.next()) {
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
    
    public List<Item> getAllItemInStoreByPrice(String type, int max, int min, int offset, int limit) throws Exception {
        List<Item> list = new ArrayList<>();
        String sql = "select * from ITEM where ITEM.`idProduct` in (select PRODUCT.`idProduct` from PRODUCT join STORE on PRODUCT.`idStore` = STORE.`idStore` where STORE.`type` like ?) and ITEM.`price` >= ? and ITEM.`price` <= ? limit ?,?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + type + "%");
        statement.setInt(2, max);
        statement.setInt(3, min);
        statement.setInt(4, offset);
        statement.setInt(5, limit);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
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
    
    public List<Item> getAllItemInStore(String type, int offset, int limit) throws Exception {
        List<Item> list = new ArrayList<>();
        String sql = "select * from ITEM where ITEM.`idProduct` in (select PRODUCT.`idProduct` from PRODUCT join STORE on PRODUCT.`idStore` = STORE.`idStore` where STORE.`type` like ?) limit ?,?";
        PreparedStatement statement = conn.prepareStatement(sql);
        statement.setString(1, "%" + type + "%");
        statement.setInt(2, offset);
        statement.setInt(3, limit);
        ResultSet rs = statement.executeQuery();
        while (rs.next()) {
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
