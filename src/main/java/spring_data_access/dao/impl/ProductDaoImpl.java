package spring_data_access.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import spring_data_access.dao.ProductDao;
import spring_data_access.entity.Product;
import spring_data_access.mapper.ProductRowMapper;

import java.util.List;
import java.util.Objects;


@Repository
public class ProductDaoImpl implements ProductDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private ProductRowMapper productRowMapper;

    @Override
    public void createTable(String sql) {
        jdbcTemplate.execute(Objects.requireNonNull(sql));
    }

    @Override
    public Product add(Product product) {
        Objects.requireNonNull(product);
        if (!Objects.isNull(product.getId())) {
            throw new IllegalArgumentException("Id must not be provided while adding product!");
        }
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("products")
                .usingGeneratedKeyColumns("id");

        Number id = jdbcInsert.executeAndReturnKey(
                new MapSqlParameterSource()
                        .addValue("name", product.getName())
                        .addValue("price", product.getPrice())
        );
        product.setId(id.longValue());
        return product;
    }

    @Override
    public Product findById(Long id) {
        Objects.requireNonNull(id);
        String sql = "Select id, name, price from products where id = ?";
        return jdbcTemplate.queryForObject(sql, productRowMapper, id);
    }

    @Override
    public boolean delete(Long id) {
        Objects.requireNonNull(id);
        String sql = "DELETE from products where id = ?";
        int rowsDeleted = jdbcTemplate.update(sql, id);
        return rowsDeleted >= 1;

    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> products;
        String sql = "Select * from products";
        products = jdbcTemplate.query(sql, productRowMapper);
        return products;
    }
}
