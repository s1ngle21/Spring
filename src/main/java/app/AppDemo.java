package app;

import app.entity.Order;
import app.entity.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "app")
public class AppDemo {
    public static void main(String[] args) {
        Product product1 = new Product(1L, "Orange", 4.99);
        Product product2 = new Product(2L, "Banana", 3.49);
        Product product3 = new Product(3L, "Apple", 2.49);
        Product product4 = new Product(4L, "Peach", 8.99);
        Order order = new
        SpringApplication.run(AppDemo.class);
    }
}
