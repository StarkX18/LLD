public class NotificationService implements OrderPlacedEvent{
    @Override
    public void orderPlacedEvent(){
        System.out.println("Send sms to customer");
    }
}
