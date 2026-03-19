/*
    Publisher has 2 roles
    1. Maintain list of subscribers
    2. Give option to subscribe and unsubscribe

    This class is NOT the publisher - Amazon is.
*/
public class Main {
    public static void main(String[] args) {
        NotificationService notificationService = new NotificationService();
        InvoiceService invoiceService = new InvoiceService();
        Amazon amazon = new Amazon();

        amazon.addOrderPlaceSubscriber(notificationService);
        amazon.addOrderPlaceSubscriber(invoiceService);

        amazon.orderPlaced();
    }
}