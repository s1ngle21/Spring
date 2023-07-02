package app.controller;


import app.entity.Order;
import app.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



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
    ResponseEntity<?> getOrderById(@PathVariable(name = "id") @RequestBody Long id) {
            Order order = orderService.getById(id);
            return ResponseEntity
                    .ok()
                    .body(order);
    }

    @GetMapping
    ResponseEntity<?> getAllOrders() {
        Map<Long, Order> orders = orderService.getAll();
        return ResponseEntity
                .ok()
                .body(orders);
    }

    @PostMapping()
    @ResponseBody
    ResponseEntity<Order> addOrder(@RequestBody Order order) {
            Order addedOrder = orderService.add(order);
            return ResponseEntity
                    .ok()
                    .header("Added order", UUID.randomUUID().toString())
                    .body(addedOrder);
    }

}
