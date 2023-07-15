package app.service;

import app.entity.Order;
import app.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Objects;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(Long id) {
        Objects.requireNonNull(id);
        return orderRepository.getById(id);
    }

    @Override
    public Map<Long, Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order add(Order order) {
        Objects.requireNonNull(order);
        return orderRepository.add(order);
    }
}
