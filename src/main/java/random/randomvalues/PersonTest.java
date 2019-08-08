package random.randomvalues;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import random.randomvalues.person.Person;

import static org.junit.Assert.assertNotNull;

@SpringBootApplication
public class PersonTest {
    ConfigurableApplicationContext ctx;
    Person person;

    @Before
    public void setUp() throws Exception {
        ctx = SpringApplication.run(PersonTest.class);
        person = ctx.getBean(Person.class);
    }

    @Test
    public void generateRandomValues() {
        assertNotNull(person.getName());
        assertNotNull(person.getId());
        assertNotNull(person.getEmail());
        assertNotNull(person.getPhone());
        System.out.println(person);
    }

    @After
    public void tearDown() throws Exception {
        ctx.close();
    }
}