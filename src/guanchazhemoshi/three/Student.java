package guanchazhemoshi.three;

import java.util.Observable;
import java.util.Observer;

public class Student implements Observer {

    /*
        将观察者放入列表中
     */
    public Student(Observable observable){
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        if(o instanceof WeatherStation){
            WeatherStation weatherStation = (WeatherStation) o;
            System.out.println("学生受到天气预报:"+weatherStation.getWeather());
        }
    }
}
