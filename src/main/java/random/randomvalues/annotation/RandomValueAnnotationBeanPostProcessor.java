package random.randomvalues.annotation;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import random.randomvalues.handlers.RandomHandler;

import java.lang.reflect.Field;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Component
@RequiredArgsConstructor
public class RandomValueAnnotationBeanPostProcessor implements BeanPostProcessor {
    private final Map <Types, RandomHandler> map;

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field [] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            RandomValue randomValue = field.getAnnotation(RandomValue.class);
            if (randomValue != null) {
                Types type = randomValue.type();
                RandomHandler handler = map.get(type);
                Object value = handler.getRandomValue();
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, value);
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
