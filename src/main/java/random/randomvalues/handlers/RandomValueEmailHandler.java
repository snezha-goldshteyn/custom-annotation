package random.randomvalues.handlers;

import org.springframework.stereotype.Service;
import random.randomvalues.annotation.Types;

@Service
public class RandomValueEmailHandler implements RandomHandler {

    @Override
    public Types type() {
        return Types.EMAIL;
    }

    @Override
    public Object getRandomValue() {
        return fairy.person().email();
    }
}
