package model;

import service.botPlayingStrategy.BotPlayingStrategy;
import service.botPlayingStrategy.BotPlayingStrategyFactory;

public class Bot extends Player{
    BotDifficultyLevel level;
    public Bot(int id, char symbol, BotDifficultyLevel botDifficultyLevel) {
        super(id, "CHITTI", symbol, PlayerType.BOT);
        this.level = botDifficultyLevel;
    }

    @Override
    public Move makeMove(Board board){
        return BotPlayingStrategyFactory.getBotPlayingStrategy().makeMove(board, this);
    }
}
