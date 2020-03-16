package guanchazhemoshi.two;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
    加入了注册和退出,实际不需要2个接口,当然2个接口的话更规范
 */
public class WeatherStation  {

    private List<Observer> list;
    private String weather;
    private String weathers[] = {"晴天","雨天","雪天","台风天"};

    public WeatherStation(){
        list = new ArrayList<>();
    }

    public void registerObserver(Observer observer) {
         list.add(observer);
    }

    public void removeObserver(Observer observer) {
        int index = list.indexOf(observer);
        if(index >= 0){
            list.remove(index);
        }
    }

    public void notifyObservers() {
        System.out.println(list.size());
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
        Student s1 = new Student(weatherStation).setName("张三");
        Student s2 = new Student(weatherStation).setName("李四");
        new Thread(()->{
            try {
                Thread.sleep(2500);
                System.out.println("执行了");
                //subject.removeObserver(s1);
                weatherStation.registerObserver(s1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        weatherStation.startWork();

    }
}
