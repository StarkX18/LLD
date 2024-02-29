package model;

import java.util.ArrayList;
import java.util.List;

public class Board {
    int dimensions;
    List<List<Cell>> matrix;

    public Board(int dimensions){
        this.dimensions = dimensions;
        matrix = new ArrayList<>();
        for(int i=0;i<dimensions;i++){
            matrix.add(new ArrayList<>());
            for(int j=0;j<dimensions; j++){
                matrix.get(i).add(new Cell(i,j));
            }
        }
    }
    public void displayBoard(){
        for(int i=0;i<dimensions;i++){
            List<Cell> cells = matrix.get(i);
            for(Cell cell: cells){
                cell.displayCell();
            }
            System.out.println();
        }
    }

    public List<List<Cell>> getMatrix() {
        return matrix;
    }

    public void setMatrix(List<List<Cell>> matrix) {
        this.matrix = matrix;
    }

    public int getDimensions() {
        return dimensions;
    }

    public void setDimensions(int dimensions) {
        this.dimensions = dimensions;
    }
}
