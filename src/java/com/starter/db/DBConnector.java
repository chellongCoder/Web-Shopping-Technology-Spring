/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pc
 */
public class DBConnector {
    
    final static String SERVER  = "125.212.227.42";
    final static String PORT    = "3336";
    final static String DB_NAME = "ManTel";
    final static String DB_USER = "root";
    final static String DB_PASS = "toor";
    
    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        StringBuilder builder = new StringBuilder();
        builder.append("jdbc:mysql://").append(SERVER).append(":").append(PORT)
                .append("/").append(DB_NAME).append("?autoReconnect=true&useSSL=false");
        return DriverManager.getConnection(builder.toString(), DB_USER, DB_PASS);
    }
    
    public static void main(String[] args) {
        try {
            Connection conn = getConnection();
            if(conn!=null) System.out.println("ok");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
