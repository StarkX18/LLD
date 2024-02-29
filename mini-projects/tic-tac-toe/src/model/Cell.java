package model;

public class Cell {
    int row;
    int col;
    CellState state;
    Player player;

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public CellState getState() {
        return state;
    }

    public Player getPlayer() {
        return player;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    Cell(int row, int col){
        this.row=row;
        this.col=col;
        this.state = CellState.EMPTY;
        this.player=null;
    }

    public void displayCell(){
       if(player==null) System.out.println("| |");
       else System.out.println("|" + player.getSymbol() + "|");
    }
}
