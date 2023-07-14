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
        if (orders.containsKey(order.getId())) {
            throw new OrderWithSuchIdAlreadyExistException(String.format("Order with such id: [%d] already exist", order.getId()));
        } else {
            return orders.put(order.getId(), order);
        }
    }

    @Override
    public Order getById(Long id) {
        if (orders.get(id) == null) {
            throw new OrderWithSuchIdDoesNotExistException(String.format("Order with this id: [%d] does not exist", id));
        }
        return orders.get(id);
    }

    @Override
    public Map<Long, Order> getAll() {
        return orders;
    }


}
