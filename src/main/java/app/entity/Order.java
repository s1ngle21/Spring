package app.entity;


import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class Order {
    private Long id;
    private LocalDateTime date;
    private double totalCost;
    private List<Product> products;

    public Order() {
    }

    public Order(Long id, LocalDateTime date, double cost) {
        this.id = id;
        this.date = date;
        this.totalCost = cost;
        this.products = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Double.compare(order.totalCost, totalCost) == 0 && Objects.equals(id, order.id) && Objects.equals(date, order.date) && Objects.equals(products, order.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, date, totalCost, products);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", cost=" + totalCost +
                ", products=" + products +
                '}';
    }
}
