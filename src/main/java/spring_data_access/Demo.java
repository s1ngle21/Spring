package spring_data_access;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring_data_access.dao.CartDao;
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

    private static final String CREATE_CART_TABLE_SQL = """
            Create table if not exists carts (
                id bigserial primary key,
                products varchar(255) 
                );
            """;

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("spring_data_access");
        ProductDao productDao = context.getBean(ProductDaoImpl.class);
        Cart cart = context.getBean(Cart.class);
        CartDao cartDao = context.getBean(CartDao.class);


        System.out.println(cartDao.findById(1L));


    }
}
