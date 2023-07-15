package spring.dao;

import spring.entity.Cart;

import java.util.List;

public interface CartDao {
    Cart findById(Long id);

    void add(Cart cart);

    List<Cart> getAll();

    void delete(Long id);
}
