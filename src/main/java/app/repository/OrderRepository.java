package app.repository;

import app.entity.Order;

import java.util.List;

public interface OrderRepository {
    Order getById(Long id);
    List<Order> getAll();
    void add(Order order);

}
