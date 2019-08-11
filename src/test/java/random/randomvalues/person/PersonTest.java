package random.randomvalues.person;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = PersonTestConfiguration.class)
public class PersonTest {

    @Autowired
    Person person;

    @Test
    public void generateRandomValues() {
        assertNotNull(person.getName());
        assertNotNull(person.getId());
        assertNotNull(person.getEmail());
        assertNotNull(person.getPhone());
        System.out.println(person);
    }

}