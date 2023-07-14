package springApp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import springApp.dao.CartDao;
import springApp.dao.ProductDao;
import springApp.dao.impl.ProductDaoImpl;
import springApp.entity.Cart;

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
        ApplicationContext context = new AnnotationConfigApplicationContext("springApp/data/access");
        ProductDao productDao = context.getBean(ProductDaoImpl.class);
        Cart cart = context.getBean(Cart.class);
        CartDao cartDao = context.getBean(CartDao.class);


        System.out.println(cartDao.findById(1L));


    }
}
