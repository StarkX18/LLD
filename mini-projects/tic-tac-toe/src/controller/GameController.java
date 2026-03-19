package controller;

import model.*;
import service.winningStrategy.WinningStrategy;
import service.winningStrategy.WinningStrategyFactory;
import service.winningStrategy.WinningStrategyName;

import java.util.List;

public class GameController {
    public Game createGame(int dimensions, List<Player> players, WinningStrategyName strategy){
        return Game
                .builder()
                .setDimensions(dimensions)
                .setPlayers(players)
                .setStrategy(WinningStrategyFactory.getWinningStrategy(strategy, dimensions))
                .build();
    }
    public void displayBoard(Game game){
        game.getBoard().displayBoard();
    }

    public GameState getGameStatus(Game game){
        return game.getState();
    }

    public Move executeMove(Game game, Player player){
        return player.makeMove(game.getBoard());
    }

    public Player checkWinner(Game game, Move lastMove){
        return game.getStrategy().checkWinner(game.getBoard(), lastMove);
    }

    public Board undoMove(Game game, Move lastMove){
        return null;
    }

    public void replayGame(Game game){

    }
}
