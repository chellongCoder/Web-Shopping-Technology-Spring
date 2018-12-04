/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.bean;

import java.io.Serializable;

/**
 *
 * @author chellong
 */
public class Customer implements Serializable, Cloneable{

    private int idCustomer;
    private String username;
    private String email;
    private String password;
    private String name;
    private String address;
    private String city;
    private String country;
    private int postcode;
    private String about;
    private String typeCustomer;

    public Customer(CustomerBuilder builder) {
        this.idCustomer = builder.idCustomer;
        this.username = builder.username;
        this.email = builder.email;
        this.password = builder.password;
        this.name = builder.name;
        this.address = builder.address;
        this.city = builder.city;
        this.country = builder.country;
        this.postcode = builder.postcode;
        this.about = builder.about;
        this.typeCustomer = builder.typeCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getAbout() {
        return about;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" + "email=" + email + ", password=" + password + ", name=" + name + '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new Customer.CustomerBuilder(this.email, this.password, this.name).build();
    }
    
    

    public static class CustomerBuilder {

        private int idCustomer;
        private String username;
        private String email;
        private String password;
        private String name;
        private String address;
        private String city;
        private String country;
        private int postcode;
        private String about;
        private String typeCustomer;

        public CustomerBuilder(String email, String password, String name) {
            this.email = email;
            this.password = password;
            this.name = name;
        }

        public void setIdCustomer(int idCustomer) {
            this.idCustomer = idCustomer;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public void setCountry(String country) {
            this.country = country;
        }

        public void setPostcode(int postcode) {
            this.postcode = postcode;
        }

        public void setAbout(String about) {
            this.about = about;
        }

        public void setTypeCustomer(String typeCustomer) {
            this.typeCustomer = typeCustomer;
        }
        
        public Customer build () {
            return new Customer(this);
        }

    }

}
