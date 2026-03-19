import java.util.ArrayList;
import java.util.List;

/*
    Publisher has 2 roles
    1. Maintain list of subscribers
    2. Give option to subscribe and unsubscribe

    This class is the publisher
 */
public class Amazon {
    private List<OrderPlacedEvent> subscribers;
    public Amazon(){
        this.subscribers = new ArrayList<>();
    }
    public void orderPlaced(){
        for(OrderPlacedEvent o : subscribers){
            o.orderPlacedEvent();
        }
    }

    public void addOrderPlaceSubscriber(OrderPlacedEvent orderPlacedSubscriber){
        subscribers.add(orderPlacedSubscriber);
    }

    public void removeOrderPlaceSubscriber(OrderPlacedEvent orderPlacedSubscriber){
        subscribers.remove(orderPlacedSubscriber);
    }

}
