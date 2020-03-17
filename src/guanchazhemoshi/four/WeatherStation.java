package guanchazhemoshi.four;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
    利用lambda表达式,这样我们就不需要每个监听者都要有具体的类了
 */
public class WeatherStation {

    private List<Listener> list;
    private String weather;
    private String weathers[] = {"晴天","雨天","雪天","台风天"};

    public WeatherStation(){
        list = new ArrayList<>();
    }

    public Listener registerListener(Listener listener) {
         list.add(listener);
         return listener;
    }

    public void removeListener(Listener listener) {
        int index = list.indexOf(listener);
        if(index >= 0){
            list.remove(index);
        }
    }

    public void notifyObservers() {
        list.forEach(e->{
            e.update(weather);
        });
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
        Listener student = weatherStation.registerListener(weather -> {
            System.out.println("学生受到天气预报:"+weather);
        });
        Listener worker = weatherStation.registerListener(weather -> {
            System.out.println("工人受到天气预报:"+weather);
        });
        new Thread(()->{
            try {
                weatherStation.startWork();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
        Thread.sleep(3_000);
        weatherStation.removeListener(student);
    }
}
