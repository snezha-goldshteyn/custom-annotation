package random.randomvalues.handlers;

import io.codearte.jfairy.Fairy;
import random.randomvalues.annotation.Types;

public interface RandomHandler {

    Types type();
    Object getRandomValue();
}
