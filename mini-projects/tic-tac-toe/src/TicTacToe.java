import controller.GameController;
import model.*;
import service.winningStrategy.WinningStrategyName;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        int id=1;
        List<Player> players = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to tic tac toe!");
        System.out.println("Enter dimensions for the board");
        int dimension = sc.nextInt();
        System.out.println("Want a bot?");
        String botRequired = sc.next();
        if(botRequired.equalsIgnoreCase("Y")){
            Player bot = new Bot(id++,'$', BotDifficultyLevel.EASY);
            players.add(bot);
        }
        while(id < dimension){
            System.out.println("Please enter the player name:");
            String playerName = sc.next();
            System.out.println("Please enter the player symbol:");
            char symbol = sc.next().charAt(0);
            Player newPlayer = new Player(id++, playerName, symbol, PlayerType.HUMAN);
            players.add(newPlayer);
        }
        Collections.shuffle(players); //randomise the player list
        Game game = gameController.createGame(dimension, players, WinningStrategyName.LinearTimeWinningStrategy);
        int playerIndex = -1;
        while(game.getState().equals(GameState.IN_PROGRESS)){
            System.out.println("Current board status");
            //TODO : add the undo logic, dont ask for undo when board is empty, and dont ask for undo when bot is the player, who played the last move.
            gameController.displayBoard(game);
            playerIndex++;
            playerIndex = playerIndex % players.size();
            Move movePlayed = gameController.executeMove(game, players.get(playerIndex));
            game.getMoves().add(movePlayed); // add moves
            game.getBoardStates().add(game.getBoard()); // add board states
            Player winner = gameController.checkWinner(game, movePlayed);
            if(winner != null){
                System.out.println("WINNER IS : " + winner.getName());
                break;
            }
            if(game.getMoves().size() == game.getBoard().getDimensions() * game.getBoard().getDimensions()){
                System.out.println("GAME IS DRAW");
                break;
            }
        }
        System.out.println("Final Board Status");
        gameController.displayBoard(game);
        System.out.println("Do you want to replay? ");
        //TODO : make the loop run again
    }
}