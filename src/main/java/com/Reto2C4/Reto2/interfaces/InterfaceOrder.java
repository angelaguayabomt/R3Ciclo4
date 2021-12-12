/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2C4.Reto2.interfaces;

import com.Reto2C4.Reto2.modelo.Order;
import java.util.List;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author angys
 */
public interface InterfaceOrder extends CrudRepository<Order, Integer>{
    @Query("{'salesMan.zone': ?0}")
    List<Order> findByZone(final String country);
    
    @Query("{status: ?0}")
    List<Order> findByStatus(final String status);
}
