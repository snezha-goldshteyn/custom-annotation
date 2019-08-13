package random.randomvalues.configuration;

import io.codearte.jfairy.Fairy;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import random.randomvalues.annotation.Types;
import random.randomvalues.handlers.*;

import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Configuration
@EnableConfigurationProperties(RandomProperties.class)
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
    @ConditionalOnProperty(value="custom.emails")
    public CustomRandomEmailHandler customEmailHandler() {
        return new CustomRandomEmailHandler();
    }

    @Bean
    @ConditionalOnProperty(value="custom.ids")
    public CustomRandomNumberId customRandomNumberId() {
        return new CustomRandomNumberId();
    }

    @Bean
    @ConditionalOnProperty(value = "custom.names")
    public CustomRandomNameHandler customRandomNameHandler() {
        return new CustomRandomNameHandler();
    }

    @Bean
    @ConditionalOnProperty(value = "custom.phones")
    public CustomRandomPhoneHandler customRandomPhoneHandler() {
        return new CustomRandomPhoneHandler();
    }

    @Bean
    @ConditionalOnMissingBean(CustomRandomEmailHandler.class)
    public RandomValueEmailHandler emailHandler () {
        return new RandomValueEmailHandler();
    }

    @Bean
    @ConditionalOnMissingBean(CustomRandomNumberId.class)
    public RandomValueIdNumber randomValueIdNumber() {
        return new RandomValueIdNumber();
    }

    @Bean
    @ConditionalOnMissingBean(CustomRandomNameHandler.class)
    public RandomValueNameHandler nameHandler() {
        return new RandomValueNameHandler();
    }

    @Bean
    @ConditionalOnMissingBean(CustomRandomPhoneHandler.class)
    public RandomValuePhoneHandler phoneHandler() {
        return new RandomValuePhoneHandler();
    }
}
