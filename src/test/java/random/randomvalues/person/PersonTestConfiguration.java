package random.randomvalues.person;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("random.randomvalues")
public class PersonTestConfiguration {

    @Bean
    public Person gerPerson() {
        return new Person();
    }
}
