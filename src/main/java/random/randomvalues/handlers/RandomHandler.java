package random.randomvalues.handlers;

import io.codearte.jfairy.Fairy;
import random.randomvalues.annotation.Types;

import java.util.List;
import java.util.Random;

public interface RandomHandler {

    Types type();
    Object getRandomValue();

    default Object getCustomRandomValue(List values) {
        Random random = new Random();
        int size = values.size();
        return values.get(random.nextInt(size)-1);
    }
}
