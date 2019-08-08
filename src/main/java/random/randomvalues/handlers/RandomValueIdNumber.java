package random.randomvalues.handlers;

import org.springframework.stereotype.Service;
import random.randomvalues.annotation.Types;

import java.util.Random;

@Service
public class RandomValueIdNumber implements RandomHandler {
    private Random generator = new Random();
    @Override
    public Types type() {
        return Types.ID_NUMBER;
    }

    @Override
    public Object getRandomValue() {
        return Math.abs(generator.nextInt());
    }
}
