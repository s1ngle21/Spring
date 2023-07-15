package spring.dao.impl;

import org.springframework.stereotype.Repository;
import spring.dao.CartDao;
import spring.entity.Cart;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CartDaoImpl implements CartDao {
    private List<Cart> carts;

    public CartDaoImpl(List<Cart> carts) {
        this.carts = new ArrayList<>();
    }

    @Override
    public Cart findById(Long id) {
        return carts
                .stream()
                .filter(cart -> cart.getId().equals(id))
                .findFirst()
                .get();
    }

    @Override
    public void add(Cart cart) {
        carts.add(cart);
    }

    @Override
    public List<Cart> getAll() {
        return carts;
    }

    @Override
    public void delete(Long id) {
        Cart cartToDelete = this.findById(id);
        carts.remove(cartToDelete);
    }
}
