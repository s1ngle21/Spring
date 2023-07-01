package app.repository;

import app.config.exeptions.OrderWithSuchIdAlreadyExistException;
import app.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

@Repository
public class SimpleOrderRepository implements OrderRepository {

    private final Order order;

    private final Map<Long, Order> orders;

    public SimpleOrderRepository(final Order order) {
        this.order = order;
        this.orders = new HashMap<>();
    }

    @Override
    public void add(Order order) {
        Objects.requireNonNull(order);
        if (orders.containsKey(order.getId())) {
            throw new OrderWithSuchIdAlreadyExistException();
        } else {
            orders.put(order.getId(), order);
        }
    }

    @Override
    public Order getById(Long id) {
        Objects.requireNonNull(id);
        return orders.get(id);
    }

    @Override
    public List<Order> getAll() {
        return (List<Order>) orders.values();
    }


}
