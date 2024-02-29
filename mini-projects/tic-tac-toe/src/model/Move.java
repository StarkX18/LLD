package model;

public class Move {
    Cell cell;
    Player player;

    public Cell getCell() {
        return cell;
    }

    public Player getPlayer() {
        return player;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }


    public Move(Cell playedCell, Player currPlayer){
        cell = playedCell;
        player = currPlayer;
    }
}
