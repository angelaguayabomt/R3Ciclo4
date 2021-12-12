/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Reto2C4.Reto2.servicio;

import com.Reto2C4.Reto2.modelo.Order;
import com.Reto2C4.Reto2.repositorio.OrderRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author angys
 */
@Service
public class OrderService {
      @Autowired
    private OrderRepositorio OrderRepositorio;

    public List<Order> getAll() {
        return OrderRepositorio.getAll();
    }

    public Optional<Order> getOrder(int id) {
        return OrderRepositorio.getOrder(id);
    }

    public Order create(Order order) {
        if (order.getId() == null) {
            return order;
        } else {
            return OrderRepositorio.create(order);
        }
    }

    public Order update(Order order) {

        if (order.getId() != null) {
            Optional<Order> orderDb = OrderRepositorio.getOrder(order.getId());
            if (!orderDb.isEmpty()) {
                if (order.getStatus() != null) {
                    orderDb.get().setStatus(order.getStatus());
                }
                OrderRepositorio.update(orderDb.get());
                return orderDb.get();
            } else {
                return order;
            }
        } else {
            return order;
        }
    }

    public boolean delete(int id) {
        Boolean aBoolean = getOrder(id).map(order -> {
            OrderRepositorio.delete(order);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public List<Order> findByZone(String zona) {
        return OrderRepositorio.findByZone(zona);
    }

    public List<Order> ordersSalesManByDate(String dateStr, int id) {
        return OrderRepositorio.ordersSalesManByDate(dateStr, id);
    }
    
    public List<Order> ordersSalesManByState(String state, Integer id) {
        return OrderRepositorio.ordersSalesManByState(state, id);
    }
}  

