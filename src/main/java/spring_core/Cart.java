package spring_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import spring_core.entity.Product;


import java.util.*;

@Component
@Scope(value = "prototype")
public class Cart {

    private Map<Long, Product> cart;

    @Autowired
    private ProductRepository productRepository;

    public Cart() {
        this.cart = new HashMap<>();
    }

    public void add(Long id) {
        Objects.requireNonNull(id);
        Product product = productRepository.getById(id);
        cart.put(product.getId(), product);
    }

    public void remove(Long id) {
        Objects.requireNonNull(id);
        cart.remove(id);
    }

    public String showAllProducts() {
        List<Product> products = new ArrayList<>(cart.values());
        return products.toString();
    }


}
