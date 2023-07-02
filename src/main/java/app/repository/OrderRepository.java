package app.repository;

import app.entity.Order;

import java.util.Map;

public interface OrderRepository {
    Order getById(Long id);
    Map<Long, Order> getAll();
    Order add(Order order);

}
