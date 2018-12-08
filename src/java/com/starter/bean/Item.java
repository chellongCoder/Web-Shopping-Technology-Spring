/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.bean;

/**
 *
 * @author chellong
 */
enum Status {
    SALE, NEW, DEFAULT;
}
public class Item {
    private int idItem;
    private int idProduct;
    private double price;
    private Status status;
    private String urlImage;

    public Item(ItemBuilder builder) {
        this.idItem = builder.idItem;
        this.idProduct = builder.idProduct;
        this.price = builder.price;
        this.status = builder.status;
        this.urlImage = builder.urlImage;
    }

    public int getIdItem() {
        return idItem;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public double getPrice() {
        return price;
    }

    public Status getStatus() {
        return status;
    }

    public String getUrlImage() {
        return urlImage;
    }

    @Override
    public String toString() {
        return "Item{" + "idItem=" + idItem + ", idProduct=" + idProduct + ", price=" + price + ", status=" + status + ", urlImage=" + urlImage + '}';
    }
    
   
    public static class ItemBuilder {
        private int idItem;
        private int idProduct;
        private double price;
        private Status status;
        private String urlImage;
        public ItemBuilder(String status) {
            switch (status) {
                case "new":
                    this.status = Status.NEW;
                    break;
                 case "sale":
                    this.status = Status.SALE;
                    break;
                 case "":
                    this.status = Status.DEFAULT;
                    break;
                default:
                    throw new AssertionError();
            }
        }

        public ItemBuilder setIdItem(int idItem) {
            this.idItem = idItem;
            return this;
        }

        public ItemBuilder setIdProduct(int idProduct) {
            this.idProduct = idProduct;
            return this;
        }

        public ItemBuilder setPrice(double price) {
            this.price = price;
            return this;
        }

        public ItemBuilder setStatus(Status status) {
            this.status = status;
            return this;
        }

        public ItemBuilder setUrlImage(String urlImage) {
            this.urlImage = urlImage;
            return this;
        }
        
        public Item build() {
            return new Item(this);
        }
    }
    
}
