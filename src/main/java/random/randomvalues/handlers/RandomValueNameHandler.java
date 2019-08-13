package random.randomvalues.handlers;

import io.codearte.jfairy.Fairy;
import org.springframework.beans.factory.annotation.Autowired;
import random.randomvalues.annotation.Types;

public class RandomValueNameHandler implements RandomHandler {

    @Autowired
    Fairy fairy;

    @Override
    public Types type() {
        return Types.NAME;
    }

    @Override
    public Object getRandomValue() {
        return fairy.person().fullName();
    }
}
