package random.randomvalues.configuration;

import io.codearte.jfairy.Fairy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonConfiguration {

    @Bean
    public Fairy getFairy() {
        return Fairy.create();
    }
}
