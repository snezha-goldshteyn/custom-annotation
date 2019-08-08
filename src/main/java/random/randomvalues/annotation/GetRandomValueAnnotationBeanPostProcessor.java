package random.randomvalues.annotation;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import random.randomvalues.handlers.RandomHandler;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.toMap;

@Component
public class GetRandomValueAnnotationBeanPostProcessor implements BeanPostProcessor {
    private Map <Types, RandomHandler> map;

    @Autowired
    public void initMap (List<RandomHandler> handlers) {
        map = handlers.stream().collect(toMap(RandomHandler::type, h -> h));
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field [] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            GetRandomValue randomValue = field.getAnnotation(GetRandomValue.class);
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