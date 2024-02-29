package service.botPlayingStrategy;

import exception.GameOverException;
import model.Board;
import model.Move;
import model.Player;

public class RandomBotPlayingStrategy implements BotPlayingStrategy{
    public Move makeMove(Board board, Player bot){
        for(int i=0;i<board.getDimensions();i++){
            for(int j = 0; j<board.getDimensions(); j++){
                if(board.getMatrix().get(i).get(j).getPlayer() == null){
                    return new Move(board.getMatrix().get(i).get(j),bot);
                }
            }
        }
        throw new GameOverException("Game has ended!");
    }
}
