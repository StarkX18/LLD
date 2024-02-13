public class ChocoChip implements Icecream{
    private Icecream icecream;
    public ChocoChip(Icecream icecream){
        this.icecream = icecream;
    }
    @Override
    public int getCost(){
        return icecream.getCost() + 20;
    }
    @Override
    public String getDescription(){
        return icecream.getDescription() + ", ChocoChip";
    }
}
