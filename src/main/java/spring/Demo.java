package spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.AppConfig;
import spring.dao.CartDao;
import spring.dao.ProductDao;
import spring.dao.impl.ProductDaoImpl;
import spring.entity.Cart;
import spring.dao.impl.CartDaoImpl;
import spring.entity.Product;

import java.util.logging.Logger;

public class Demo {
    private static final Logger LOGGER = Logger.getLogger(Demo.class.getName());
    private static final String CREATE_PRODUCT_TABLE_SQL = """
            create table if not exists products (
                id bigserial primary key,
                name varchar(255) not null,
                price numeric not null
            ); 
            """;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        ProductDao productDao = context.getBean(ProductDaoImpl.class);
        Cart cart = context.getBean(Cart.class);
        CartDao cartDao = context.getBean(CartDaoImpl.class);

        Product product1 = productDao.findById(1L);
        Product product2 = productDao.findById(2L);
        Product product3 = productDao.findById(3L);

        cart.add(product1);
        cart.add(product2);
        cart.add(product3);


        cartDao.add(cart);

        LOGGER.info("" + cartDao.findById(1L));
    }
}
