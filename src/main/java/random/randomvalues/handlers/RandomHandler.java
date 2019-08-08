package random.randomvalues.handlers;

import io.codearte.jfairy.Fairy;
import random.randomvalues.annotation.Types;

public interface RandomHandler {
    Fairy fairy = Fairy.create();
    Types type();
    Object getRandomValue();
}
