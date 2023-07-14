package springApp.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import springApp.dao.ProductDao;
import springApp.entity.Product;
import springApp.mapper.ProductRowMapper;

import java.util.List;
import java.util.Objects;


@Repository
public class ProductDaoImpl implements ProductDao {
    private JdbcTemplate jdbcTemplate;
    private ProductRowMapper productRowMapper;

    public ProductDaoImpl(JdbcTemplate jdbcTemplate, ProductRowMapper productRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.productRowMapper = productRowMapper;
    }

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
        String sql = "select id, name, price from products where id = ?";
        return jdbcTemplate.queryForObject(sql, productRowMapper, id);
    }

    @Override
    public boolean delete(Long id) {
        Objects.requireNonNull(id);
        String sql = "delete from products where id = ?";
        int rowsDeleted = jdbcTemplate.update(sql, id);
        return rowsDeleted >= 1;

    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "select * from products";
        return jdbcTemplate.query(sql, productRowMapper);
    }
}
