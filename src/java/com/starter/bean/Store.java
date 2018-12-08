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
public class Store {

    private int idStore;
    private Type type;

    public Store(StoreBuilder builder) {
        this.idStore = builder.idStore;
        this.type = builder.type;
    }

    public int getIdStore() {
        return idStore;
    }

    public Type getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Store{" + "idStore=" + idStore + ", type=" + type + '}';
    }

    public static class Type {

        static final String ITSHIRT = "IT Shirt";
        static final String MACBOOK = "Macbook";
        static final String SMARTPHONE = "Smart Phone";
        static final String WATCH = "Watch";
        static final String ACCESSORY = "Accessory";
        private String type;

        public Type(String type) {
            switch (type) {
                case ITSHIRT:
                    this.type = ITSHIRT;
                    break;
                case MACBOOK:
                    this.type = MACBOOK;
                    break;
                case SMARTPHONE:
                    this.type = SMARTPHONE;
                    break;
                case WATCH:
                    this.type = WATCH;
                    break;
                case ACCESSORY:
                    this.type = ACCESSORY;
                    break;
                default:
                    this.type = "";
                    throw new AssertionError();
            }
            
        }

        @Override
        public String toString() {
            return this.type;
        }

    }

    public static class StoreBuilder {

        private int idStore;
        private Type type;

        public StoreBuilder(int idStore, Type type) {
            this.idStore = idStore;
            this.type = type;
        }

        public StoreBuilder setIdStore(int idStore) {
            this.idStore = idStore;
            return this;
        }

        public StoreBuilder setType(Type type) {
            this.type = type;
            return this;
        }

        public Store build() {
            return new Store(this);
        }
    }
}
