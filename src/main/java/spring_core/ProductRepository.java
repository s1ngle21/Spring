package spring_core;


import org.springframework.stereotype.Repository;
import spring_core.entity.Product;

import java.util.*;

@Repository
public class ProductRepository {

    private Map<Long, Product> products;

    public ProductRepository() {
        this.products = new HashMap<>();
        products.put(1L, new Product(1L, "Banana", 10.49));
        products.put(2L, new Product(2L, "Apple", 5.89));
        products.put(3L, new Product(3L, "Orange", 7.98));
    }

    public List<Product> getAll() {
         List<Product> products = new ArrayList<>(this.products.values());
         return products;
    }

    public Product getById(Long id) {
        Objects.requireNonNull(id);
        Product product = products.get(id);
        return product;
    }


}
