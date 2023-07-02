package app.service;

import app.entity.Order;
import app.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    public OrderServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public Order getById(Long id) {
        return orderRepository.getById(id);
    }

    @Override
    public Map<Long, Order> getAll() {
        return orderRepository.getAll();
    }

    @Override
    public Order add(Order order) {
        return orderRepository.add(order);
    }
}
