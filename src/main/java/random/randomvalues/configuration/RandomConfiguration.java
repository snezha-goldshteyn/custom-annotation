package random.randomvalues.configuration;

import io.codearte.jfairy.Fairy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import random.randomvalues.annotation.Types;
import random.randomvalues.handlers.*;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Configuration
@ComponentScan("random.randomvalues")
public class RandomConfiguration {

    @Bean
    public Fairy getFairy() {
        return Fairy.create();
    }

    @Bean
    public Map<Types, RandomHandler> initMap (
    List<RandomHandler> handlers) {
        return handlers.stream().collect(toMap(RandomHandler::type, h -> h));
    }

    @Bean
    public RandomValueEmailHandler emailHandler () {
        return new RandomValueEmailHandler();
    }

    @Bean
    public RandomValueIdNumber randomValueIdNumber() {
        return new RandomValueIdNumber();
    }

    @Bean
    public RandomValueNameHandler nameHandler() {
        return new RandomValueNameHandler();
    }

    @Bean
    public RandomValuePhoneHandler phoneHandler() {
        return new RandomValuePhoneHandler();
    }
}
