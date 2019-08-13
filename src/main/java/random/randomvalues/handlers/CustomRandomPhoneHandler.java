package random.randomvalues.handlers;

import org.springframework.beans.factory.annotation.Autowired;
import random.randomvalues.annotation.Types;
import random.randomvalues.configuration.RandomProperties;

import java.util.List;

public class CustomRandomPhoneHandler implements RandomHandler {
    @Autowired
    RandomProperties properties;

    @Override
    public Types type() {
        return Types.PHONE;
    }

    @Override
    public Object getRandomValue() {
        List<String> phones = properties.getPhones();
        return getCustomRandomValue(phones);
    }
}
