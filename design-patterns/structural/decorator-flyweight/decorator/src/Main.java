public class Main {
    public static void main(String[] args) {
        Icecream ic = new ChocoChip(
                            new ChocoCone(
                                    new ChocoChip(
                                            new ChocoCone()
                                    )
                            )
        );
        System.out.println(ic.getCost());
        System.out.println(ic.getDescription());
    }
}