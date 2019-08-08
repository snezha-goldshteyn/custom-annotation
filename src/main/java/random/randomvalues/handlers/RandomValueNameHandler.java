package random.randomvalues.handlers;

import org.springframework.stereotype.Service;
import random.randomvalues.annotation.Types;

@Service
public class RandomValueNameHandler implements RandomHandler {
    @Override
    public Types type() {
        return Types.NAME;
    }

    @Override
    public Object getRandomValue() {
        return fairy.person().fullName();
    }
}
