package spring_core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import spring_core.service.LoggerService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


@Controller
public class ConsoleProgram {

    private final Cart cart;
    private final LoggerService logger;
    private final BufferedReader reader;

    @Autowired
    public ConsoleProgram(Cart cart, LoggerService logger) {
        this.cart = cart;
        this.logger = logger;
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    public void start() {
        String option;

        while (true) {
            logger.log("""
                    \nChoose option:
                    1. Add product to cart
                    2. Remove product from cart
                    3. Show cart
                    4. Exit
                    Enter your option:
                    """);

            try {
                option = reader.readLine().trim();
                processUserOption(option.trim());
            } catch (IOException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void processUserOption(String userOption) throws IOException, InterruptedException {
        String optionForSubMenu = "";
        switch (userOption) {
            case "1":
                logger.log("Please, enter product id to add");
                Long productId = Long.parseLong(reader.readLine());
                cart.add(productId);
                logger.log("""
                        \nTo go back to main menu type: menu
                        To check cart type: cart
                        To exit type: exit
                        """);
                optionForSubMenu = reader.readLine().trim();
                processUserSubMenuOption(optionForSubMenu);
                break;
            case "2":
                logger.log("Please, enter product id to remove");
                Long productIdToRemove = Long.parseLong(reader.readLine());
                cart.remove(productIdToRemove);
                logger.log("""
                        \nTo go back to main menu type: menu 
                        To check cart type: cart                  
                        To exit type: exit
                        """);
                optionForSubMenu = reader.readLine().trim();
                processUserSubMenuOption(optionForSubMenu);
                break;
            case "3":
                logger.log(cart.showAllProducts());
                logger.log("""
                        \nTo go back to main menu type: menu
                        To check cart type: cart
                        To exit type: exit
                        """);
                optionForSubMenu = reader.readLine().trim();
                processUserSubMenuOption(optionForSubMenu);
                break;
            case "4":
                logger.log("Exiting program");
                Thread.sleep(3000);
                System.exit(0);
            default:
                logger.log("Wrong input, please try again!");
        }
    }

    public void processUserSubMenuOption(String userOption) throws InterruptedException {
        switch (userOption) {
            case "menu":
                start();
                break;
            case "cart":
                logger.log(cart.showAllProducts());
                break;
            case "exit":
                logger.log("Exiting program");
                Thread.sleep(3000);
                System.exit(0);
            default:
                logger.log("Wrong input, please try again!");
        }
    }
}
