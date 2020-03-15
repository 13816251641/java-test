package guanchazhemoshi.two;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class Student implements Observer {

    private String name;

    public Student(Subject subject){
        subject.registerObserver(this);
    }

    @Override
    public void update(String weather) {
        System.out.println("学生"+name+"接受天气预报:"+weather);
    }
}
