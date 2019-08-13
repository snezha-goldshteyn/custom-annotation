package random.randomvalues.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import random.randomvalues.annotation.Types;
import random.randomvalues.configuration.RandomProperties;

import java.util.List;

public class CustomRandomNameHandler implements RandomHandler {
    @Autowired
    RandomProperties properties;

    @Override
    public Types type() {
        return Types.NAME;
    }

    @Override
    public Object getRandomValue() {
        List<String> names = properties.getNames();
        return getCustomRandomValue(names);
    }
}
