package random.randomvalues.handlers;

import io.codearte.jfairy.Fairy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import random.randomvalues.annotation.Types;

@Service
public class RandomValuePhoneHandler implements RandomHandler{

    @Autowired
    Fairy fairy;

    @Override
    public Types type() {
        return Types.PHONE;
    }

    @Override
    public Object getRandomValue() {
        return fairy.person().telephoneNumber();
    }
}
