package random.randomvalues.person;

import org.springframework.stereotype.Component;
import random.randomvalues.annotation.GetRandomValue;
import random.randomvalues.annotation.Types;

@Component
public class Person {
    @GetRandomValue(type = Types.NAME)
    private String name;
    @GetRandomValue(type = Types.EMAIL)
    private String email;
    @GetRandomValue(type = Types.PHONE)
    private String phone;
    @GetRandomValue(type = Types.ID_NUMBER)
    private Integer id;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", id=" + id +
                '}';
    }
}
