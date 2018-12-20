/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.model;

import com.starter.bean.Customer;
import com.starter.bean.Store;
import com.starter.bean.User;
import com.starter.db.DBConnector;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author chellong
 */
public class StoreModel implements IModel<Store> {
    private Connection conn;
    private static StoreModel instance;
    
    private  StoreModel() throws Exception {
       conn = DBConnector.getConnection();
    }
    
    public static StoreModel getInstance () throws Exception {
        if(StoreModel.instance == null) {
            StoreModel.instance = new StoreModel();
        }
        return StoreModel.instance;
    }
    
    public List<Store> getAll() throws Exception {
        List<Store> list = new ArrayList<>();
        String sql = "SELECT * FROM STORE";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Store store = new Store.StoreBuilder(rs.getInt("idStore"), new Store.Type(rs.getString("type"))).build();
            list.add(store);
        }
        return list;
    }

    @Override
    public int add(Store t) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(Store c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Store getById(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
