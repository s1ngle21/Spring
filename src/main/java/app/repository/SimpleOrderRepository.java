package app.repository;

import app.exeptions.OrderWithSuchIdAlreadyExistException;
import app.entity.Order;
import app.exeptions.OrderWithSuchIdDoesNotExistException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Repository
public class SimpleOrderRepository implements OrderRepository {

    private Order order;

    private final Map<Long, Order> orders;

    public SimpleOrderRepository(final Order order) {
        this.order = order;
        this.orders = new HashMap<>();
    }

    @Override
    public Order add(Order order) {
        Objects.requireNonNull(order);
        if (orders.containsKey(order.getId())) {
            throw new OrderWithSuchIdAlreadyExistException("Order with such id: [" + order.getId() + "] already exist");
        } else {
            return orders.put(order.getId(), order);
        }
    }

    @Override
    public Order getById(Long id) {
        Objects.requireNonNull(id);
        if (orders.get(id) == null) {
            throw new OrderWithSuchIdDoesNotExistException("Order with this id: [" + id + "] does not exist");
        }
        return orders.get(id);
    }

    @Override
    public Map<Long, Order> getAll() {
        return orders;
    }


}
