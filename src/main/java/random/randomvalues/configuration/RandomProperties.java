package random.randomvalues.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("custom")
public class RandomProperties {
    List<String> emails;
    List<String> names;
    List<String> phones;
    List<String> ids;
}
