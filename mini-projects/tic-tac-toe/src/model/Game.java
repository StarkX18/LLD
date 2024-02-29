package model;

import exception.InvalidDimensionsException;
import service.winningStrategy.WinningStrategy;
import service.winningStrategy.WinningStrategyName;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private GameState state;

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public void setStrategy(WinningStrategy strategy) {
        this.strategy = strategy;
    }

    public void setBoardStates(List<Board> boardStates) {
        this.boardStates = boardStates;
    }

    public Board getBoard() {
        return board;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameState getState() {
        return state;
    }

    public WinningStrategy getStrategy() {
        return strategy;
    }

    public List<Board> getBoardStates() {
        return boardStates;
    }

    private WinningStrategy strategy;
    private List<Board> boardStates;
    private Game(Board board, List<Player> players, WinningStrategy strategy) {
        this.board = board;
        this.players = players;
        this.moves = new ArrayList<>();
        this.boardStates = new ArrayList<>();
        this.state = GameState.IN_PROGRESS;
        this.strategy = strategy;
    }
    public static GameBuilder builder(){
        return new GameBuilder();
    }

    public static class GameBuilder {
        private int dimensions;
        private Board board;
        private List<Player> players;
        private WinningStrategy strategy;
        public GameBuilder setDimensions(int dimensions){
            this.dimensions = dimensions;
            return this;
        }
        public GameBuilder setBoard(Board board) {
            this.board = board;
            return this;
        }
        public GameBuilder setPlayers(List<Player> players) {
            this.players = players;
            if(players.size() >= board.getDimensions() || players.size() < board.getDimensions()-2){
                throw new InvalidDimensionsException("Please set the dimensions of the board correctly");
            }
            return this;
        }
        public GameBuilder setStrategy(WinningStrategy strategy) {
            this.strategy = strategy;
            return this;
        }

        public Game build(){
            return new Game(new Board(dimensions), players, strategy);
        }
    }
}
