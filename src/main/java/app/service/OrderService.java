package app.service;

import app.entity.Order;

import java.util.Map;

public interface OrderService {
    Order getById(Long id);
    Map<Long, Order> getAll();
    Order add(Order order);
}
