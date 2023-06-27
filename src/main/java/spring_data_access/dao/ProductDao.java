package spring_data_access.dao;

import spring_data_access.entity.Product;

import java.util.List;

public interface ProductDao {
    void createTable(String sql);
    Product add(Product product);
    Product findById(Long id);
    boolean delete(Long id);
    List<Product> getAllProducts();

}
