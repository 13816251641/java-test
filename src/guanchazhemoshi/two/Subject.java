package guanchazhemoshi.two;

public interface Subject {
     void registerObserver(Observer observer);
     void removeObserver(Observer observer);
     /*
        通知所有的观察者
      */
     void notifyObservers();
}
