package app.service;

import app.entity.Order;

import java.util.List;

public interface OrderService {
    Order getById(Long id);
    List<Order> getAll();
    void add(Order order);
}
