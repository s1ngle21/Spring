package spring_core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Demo {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext("spring_core");
        ConsoleProgram consoleProgram = context.getBean(ConsoleProgram.class);
        consoleProgram.start();
    }
}
