/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.model;

import com.starter.bean.Item;
import com.starter.db.DBConnector;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.imageio.ImageIO;

/**
 *
 * @author chellong
 */
public class TestModel {

    static BufferedImage deepCopy(BufferedImage bi, int index) throws IOException {
        String saveAs = index < 9 ? "system0" + (index + 1) + ".jpg" : "system" + (index + 1) + ".jpg";
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        BufferedImage cImg = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        File saveImage = new File("/Users/chellong/OneDriver/OneDrive - hocvienact.edu.vn/Ao IT/System/system", saveAs);
        ImageIO.write(cImg, "jpg", saveImage);
        return cImg;
    }

    public static void renameFile() throws Exception {
        String path = "/Users/chellong/OneDriver/OneDrive - hocvienact.edu.vn/Ao IT/System";
        File folder = new File(path);
        File[] listOfFiles = folder.listFiles();
        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                BufferedImage cp, img;
                img = ImageIO.read(listOfFiles[i]);
                System.out.println(listOfFiles[i].getAbsolutePath());
                cp = deepCopy(img, i);
            } else if (listOfFiles[i].isDirectory()) {
                System.out.println("Directory " + listOfFiles[i].getName());
            }
        }
    }

    public static int add(String name) throws Exception {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO ITEM(idProduct, price, status, urlImage) VALUES(?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 4);
        pstmt.setDouble(2, 2000);
        pstmt.setString(3, "");
        pstmt.setString(4, "http://localhost:54130/SpringStarter/public/images/"+name);

        return pstmt.executeUpdate();
    }

    public static int addMacbook(int i) throws Exception {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO PRODUCT(idStore, nameProduct, quantity) VALUES(?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 2);
        pstmt.setString(2, "Macbook Air " + i);
        pstmt.setInt(3, 10);

        return pstmt.executeUpdate();
    }
    
    public static List<Item> getListItem () throws Exception {
        List<Item> list = new ArrayList<>();
        Connection conn = DBConnector.getConnection();
        String sql = "select * from ITEM";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while(rs.next()) {
            Item item = new Item.ItemBuilder(rs.getString("status"))
                        .setIdItem(rs.getInt("idItem"))
                        .setIdProduct(rs.getInt("idProduct"))
                        .setPrice(rs.getDouble("price"))
                        .setUrlImage(rs.getString("urlImage"))
                        .setNote(rs.getString("note"))
                        .setName(rs.getString("name"))
                        .build();
            
            list.add(item);
        }
        return list;
    } 
    
    public static int updateName(String name) throws Exception {
        Connection conn = DBConnector.getConnection();
        String sql = "update ITEM set ITEM.`name` = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        int result = pstmt.executeUpdate();
        return result;
    }
    
    static class Runnable1 implements Runnable {
        public void run() {
            for (int i = 1; i <= 1000; i += 2) {
                System.out.println(i);
            }
        }
    }

    static class Runnable2 implements Runnable {

        public void run() {
            for (int i = 0; i < 1000; i += 2) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
        try {
//            String path = "/Users/chellong/OneDriver/OneDrive - hocvienact.edu.vn/Ao IT/System/system";
//            File folder = new File(path);
//            File[] listOfFiles = folder.listFiles();
//
//            for (int i = 0; i < listOfFiles.length; i++) {
//                System.out.println("result " + TestModel.add(listOfFiles[i].getName()));
//            }
//            TestModel.renameFile();
//            Runnable r = new Runnable1();
//            Thread t = new Thread(r);
//            Runnable r2 = new Runnable2();
//            Thread t2 = new Thread(r2);
//            t.start();
//            t2.start();
//            int ceil = (int)Math.ceil((double)35/15);
//            System.out.println("ceil " + ceil);
//            for (int i = 2012; i < 2018; i++) {
//                int addMacbook = TestModel.addMacbook(i);
//                System.out.println("result " + addMacbook);
//            }
//            String str = "0-1000";
//            String[] strs = str.split("[-]+");
//            for (int i = 0; i < strs.length; i++) {
//                System.out.println("strs " + strs[i]);
//            }
//            System.out.println("s1 " + strs[0] + " " + strs[1]);
//                String url = "http://localhost:54130/SpringStarter/public/images/java01.jpg";
//                String[] arr = url.split("/");
//                for (String string : arr) {
//                    System.out.println("string " + string );
//                    
//                }
            List<Item> list = getListItem();
            for (Item item : list) {
                System.out.println("item " + item);
                String url = item.getUrlImage();
                String[] arr = url.split("/");
                String[] result = arr[arr.length - 1].split("[.]");
                int updateName = TestModel.updateName(result[0]);
                if(updateName > 0) System.out.println("ok ");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
