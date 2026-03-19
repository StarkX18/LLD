package model;

import java.util.Scanner;

public class Player {
    char symbol;
    int id;
    String name;
    private PlayerType playerType;
    public Player(int id, String name, char symbol, PlayerType playerType) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.playerType = playerType;
    }
    public char getSymbol() {
        return symbol;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PlayerType getType() {
        return type;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(PlayerType type) {
        this.type = type;
    }

    PlayerType type;
    public Move makeMove(Board board){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input R for target cell");
        int r = scanner.nextInt();
        System.out.println("Input C for tARGET CELL");
        int c = scanner.nextInt();

        Cell cell = board.getMatrix().get(r).get(c);
        cell.state = CellState.FILLED;
        cell.setPlayer(this);
        return new Move(cell, this);
    }
}
