package service.winningStrategy;

public class WinningStrategyFactory {
    public static WinningStrategy getWinningStrategy(WinningStrategyName name, int dimensions){
        return new LinearTimeWinningStrategy(dimensions);
    }
}
