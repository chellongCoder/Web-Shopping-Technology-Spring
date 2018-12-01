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
public class Customer {
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

    public Customer() {
        this.idCustomer = 0;
        this.username = "";
        this.email = "";
        this.password = "";
        this.name = "";
        this.address = "";
        this.city = "";
        this.country = "";
        this.postcode = 0;
        this.about = "";
        this.typeCustomer = "";

    }

    public Customer(int idCustomer, String username, String email, String password, String name, String address, String city, String country, int postcode, String about, String typeCustomer) {
        this.idCustomer = idCustomer;
        this.username = username;
        this.email = email;
        this.password = password;
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.postcode = postcode;
        this.about = about;
        this.typeCustomer = typeCustomer;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    @Override
    public String toString() {
        return "Customer{" + "email=" + email + ", password=" + password + ", name=" + name + '}';
    }

}
