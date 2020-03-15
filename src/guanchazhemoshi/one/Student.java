package guanchazhemoshi.one;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student implements Weather {
    private String name;

    @Override
    public void notifyWeather(String weather) {
        System.out.println("学生"+name+"接受天气预报:"+weather);
    }
}
