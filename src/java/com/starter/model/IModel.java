/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.starter.model;

import com.starter.db.DBConnector;
import java.sql.Connection;
import java.util.List;

/**
 *
 * @author chellong
 * @param <T>
 */
public interface IModel<T> {
    public List<T> getAll () throws Exception;
    public int add(T t) throws Exception;
    public int update(T c);
    public int delete(int id); 
    public T getById(int id) throws Exception;
    
}
