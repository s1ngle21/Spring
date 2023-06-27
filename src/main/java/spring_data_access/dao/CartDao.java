package spring_data_access.dao;

import spring_data_access.entity.Cart;
import spring_data_access.entity.Product;

import java.util.List;
import java.util.Map;

public interface CartDao {
    void createTable(String sql);
    Cart add(Cart cart);
    Cart findById(Long id);
    boolean delete(Long id);
    List<Cart> getAllCarts();
}
