
import java.util.ArrayList;
import java.util.List;

public class ObserverPattern {
    NewsAgency newsAgency = new NewsAgency();

    // Create observers (News Channels)
    Observer channel1 = new NewsChannel("CNN");
    Observer channel2 = new NewsChannel("BBC");
    Observer channel3 = new NewsChannel("Al Jazeera");

    // Attach observers to the subject
    newsAgency.attach(channel1);
    newsAgency.attach(channel2);
    newsAgency.attach(channel3);

    // Update the news (this will notify all observers)
    newsAgency.setNews("Breaking News: Observer Pattern Explained!");

    // Detach one observer
    newsAgency.detach(channel2);

    // Update the news again
    newsAgency.setNews("Update: Observer Pattern is Awesome!");

}

interface Subject{
    void attach(Observer observer);
    void detach (Observer observer);
    void notifyObservers();
}

interface Observer{
    void update(String news);
}


class NewsAgency implements Subject{
    private List<Observer> observers = new ArrayList<>();
    private String news;

     @Override
    public void attach(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detach(Observer observer) {
        observers.remove(observer);
    }

     @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(news); // Notify each observer
        }
    }

    // Method to update the news and notify observers
    public void setNews(String news) {
        this.news = news;
        notifyObservers(); // Notify all observers when news changes
    }

}

class NewsChannel implements Observer {
    private String name;

    public NewsChannel(String name) {
        this.name = name;
    }

    @Override
    public void update(String news) {
        System.out.println(name + " received news: " + news);
    }
}
