package random.randomvalues.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import random.randomvalues.annotation.Types;
import random.randomvalues.configuration.RandomProperties;

import java.util.List;
import java.util.stream.Collectors;

public class CustomRandomNumberId implements RandomHandler {
    @Autowired
    RandomProperties properties;

    @Override
    public Types type() {
        return Types.ID_NUMBER;
    }

    @Override
    public Object getRandomValue() {
        List<String> ids = properties.getIds();
        String id = (String) getCustomRandomValue(ids);
        return Integer.valueOf(id);
    }
}
