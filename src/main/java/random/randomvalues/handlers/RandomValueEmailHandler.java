package random.randomvalues.handlers;

import io.codearte.jfairy.Fairy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import random.randomvalues.annotation.Types;

@Service
public class RandomValueEmailHandler implements RandomHandler {

    @Autowired
    Fairy fairy;

    @Override
    public Types type() {
        return Types.EMAIL;
    }

    @Override
    public Object getRandomValue() {
        return fairy.person().email();
    }
}
