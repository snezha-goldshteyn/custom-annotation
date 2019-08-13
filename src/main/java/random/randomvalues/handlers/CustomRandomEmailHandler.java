package random.randomvalues.handlers;

import io.codearte.jfairy.Fairy;
import org.springframework.beans.factory.annotation.Autowired;
import random.randomvalues.annotation.Types;
import random.randomvalues.configuration.RandomProperties;

import java.util.List;
import java.util.Random;

public class CustomRandomEmailHandler implements RandomHandler {

    @Autowired
    RandomProperties properties;

    @Override
    public Types type() {
        return Types.EMAIL;
    }

    @Override
    public Object getRandomValue() {
        List<String> emails = properties.getEmails();
        return getCustomRandomValue(emails);
    }
}
