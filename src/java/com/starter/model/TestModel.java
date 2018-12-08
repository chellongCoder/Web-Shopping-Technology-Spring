/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.model;

import com.starter.db.DBConnector;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.imageio.ImageIO;

/**
 *
 * @author chellong
 */
public class TestModel {

    static BufferedImage deepCopy(BufferedImage bi, int index) throws IOException {
        String saveAs = index < 9 ? "java0" + (index + 1) + ".jpg" : "java" + (index + 1) + ".jpg";
        ColorModel cm = bi.getColorModel();
        boolean isAlphaPremultiplied = cm.isAlphaPremultiplied();
        WritableRaster raster = bi.copyData(null);
        BufferedImage cImg = new BufferedImage(cm, raster, isAlphaPremultiplied, null);
        File saveImage = new File("/Users/chellong/OneDriver/OneDrive - hocvienact.edu.vn/Ao IT/code/javatest", saveAs);
        ImageIO.write(cImg, "jpg", saveImage);
        return cImg;
    }

    public static void renameFile() throws Exception {
        String path = "/Users/chellong/OneDriver/OneDrive - hocvienact.edu.vn/Ao IT/code/javatest";
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

    public static int add(int i) throws Exception {
        Connection conn = DBConnector.getConnection();
        PreparedStatement pstmt = null;

        String sql = "INSERT INTO ITEM(idProduct, price, status, urlImage) VALUES(?,?,?,?)";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, 1);
        pstmt.setDouble(2, 1000);
        pstmt.setString(3, "new");
        pstmt.setString(4, "http://localhost:54130/SpringStarter/public/images/item" + (i < 9 ? ("0" + i) : i) + ".jpg");

        return pstmt.executeUpdate();

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
//            for (int i = 1; i <=13 ; i++) {
//                System.out.println("result " + TestModel.add(i));
//            }
//            StoreModel.renameFile();
//            Runnable r = new Runnable1();
//            Thread t = new Thread(r);
//            Runnable r2 = new Runnable2();
//            Thread t2 = new Thread(r2);
//            t.start();
//            t2.start();
            int ceil = (int)Math.ceil((double)35/15);
            System.out.println("ceil " + ceil);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
