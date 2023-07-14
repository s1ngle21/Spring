package springApp.dao;

import springApp.entity.Cart;

import java.util.List;

public interface CartDao {
    void createTable(String sql);
    Cart add(Cart cart);
    Cart findById(Long id);
    boolean delete(Long id);
    List<Cart> getAllCarts();
}
