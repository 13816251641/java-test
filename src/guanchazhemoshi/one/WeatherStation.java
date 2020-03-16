package guanchazhemoshi.one;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 观察者模式,没有注册和退出
 */
public class WeatherStation {

    private List<Weather> list = new ArrayList<>();//重点

    private String weathers[] = {"晴天","雨天","雪天","台风天"};

    public void addListener(Weather weather){
        list.add(weather);
    }

    public void startWork() throws Exception{
        Random random = new Random();
        while (true){
            int index = random.nextInt(weathers.length);
            String weather = weathers[index];
            System.out.println("气象局发布天气:"+weather);
            for (Weather w:list) {
                w.notifyWeather(weather);
            }
            Thread.sleep(1_000);
        }
    }


    public static void main(String[] args) throws Exception{
        WeatherStation weatherStation = new WeatherStation();
        weatherStation.addListener(new Student().setName("张三"));
        weatherStation.addListener(new Student().setName("李四"));
        weatherStation.startWork();
    }
}
