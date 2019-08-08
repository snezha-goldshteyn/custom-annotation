package random.randomvalues;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import random.randomvalues.person.Person;

@SpringBootApplication
public class RandomValuesApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(RandomValuesApplication.class, args);
        System.out.println(ctx.getBean(Person.class).toString());
    }

}
