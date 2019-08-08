package random.randomvalues.handlers;

import org.springframework.stereotype.Service;
import random.randomvalues.annotation.Types;

@Service
public class RandomValuePhoneHandler implements RandomHandler{

    @Override
    public Types type() {
        return Types.PHONE;
    }

    @Override
    public Object getRandomValue() {
        return fairy.person().telephoneNumber();
    }
}
