package app.controller;


import app.entity.Order;
import app.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/{id}")
    ResponseEntity<Order> getOrderById(@PathVariable(name = "id") Long id) {
            Order order = orderService.getById(id);
            return ResponseEntity
                    .ok()
                    .body(order);
    }

    @GetMapping
    ResponseEntity<Map<Long, Order>> getAllOrders() {
        Map<Long, Order> orders = orderService.getAll();
        return ResponseEntity
                .ok()
                .body(orders);
    }

    @PostMapping
    ResponseEntity<Order> addOrder(@RequestBody Order order) {
            Order addedOrder = orderService.add(order);
            return ResponseEntity
                    .ok()
                    .body(addedOrder);
    }

}
