package spring_data_access;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_data_access.dao.ProductDao;
import spring_data_access.dao.impl.ProductDaoImpl;
import spring_data_access.entity.Cart;
import spring_data_access.entity.Product;

public class Demo {
    private static final String CREATE_PRODUCT_TABLE_SQL = """
            Create table if not exists products (
                id bigserial primary key,
                name varchar(255) not null,
                price numeric not null
            ); 
            """;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("spring_data_access");
        ProductDao productDao = context.getBean(ProductDaoImpl.class);
        Cart cart = context.getBean(Cart.class);

        Product product = productDao.findById(1L);
        cart.add(product);
    }
}
