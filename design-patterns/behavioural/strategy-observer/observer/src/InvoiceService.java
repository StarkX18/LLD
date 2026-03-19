public class InvoiceService implements OrderPlacedEvent{
    @Override
    public void orderPlacedEvent(){
        System.out.println("generating invoice for customer");
    }
}
