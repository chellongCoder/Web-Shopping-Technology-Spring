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
public class Product {

    private int idProduct;
    private int idStore;
    private String nameProduct;
    private int quantity;

    public Product(ProductBuilder builder) {
        this.idProduct = builder.idProduct;
        this.idStore = builder.idStore;
        this.nameProduct = builder.nameProduct;
        this.quantity = builder.quantity;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public int getIdStore() {
        return idStore;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public String toString() {
        return "Product{" + "idProduct=" + idProduct + ", idStore=" + idStore + ", nameProduct=" + nameProduct + ", quantity=" + quantity + '}';
    }

    public static class ProductBuilder {

        private int idProduct;
        private int idStore;
        private String nameProduct;
        private int quantity;

        public ProductBuilder(int idProduct, int idStore, String nameProduct) {
            this.idProduct = idProduct;
            this.idStore = idStore;
            this.nameProduct = nameProduct;
        }

        public ProductBuilder setIdProduct(int idProduct) {
            this.idProduct = idProduct;
            return this;
        }

        public ProductBuilder setIdStore(int idStore) {
            this.idStore = idStore;
            return this;
        }

        public ProductBuilder setNameProduct(String nameProduct) {
            this.nameProduct = nameProduct;
            return this;
        }

        public ProductBuilder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
            
        }

        public Product build() {
            return new Product(this);
        }
    }
}
