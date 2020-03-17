package guanchazhemoshi.three;


import lombok.Data;
import java.util.Observable;
import java.util.Random;

/*
    利用jdk自带观察者模式实现,这里的Observable是一个类!!!
 */
@Data
public class WeatherStation extends Observable {
    private String weather;
    private String weathers[] = {"晴天","雨天","雪天","台风天"};

    public WeatherStation(){

    }


    public void notifyObservers() {
        //setChanged();//必须加,否则不会notify
        super.notifyObservers();//调用父类的notify方法,记住是父类
    }

    public void startWork() throws Exception{
        Random random = new Random();
        while (true){
            int index = random.nextInt(weathers.length);
            weather = weathers[index];
            System.out.println("气象局发布天气:"+weather);
            notifyObservers();
            Thread.sleep(1_000);
        }
    }

    public static void main(String[] args) throws Exception{
        WeatherStation weatherStation = new WeatherStation();
        Student student = new Student(weatherStation);
        weatherStation.startWork();
    }
}
