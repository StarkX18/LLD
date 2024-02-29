package service.winningStrategy;

import model.Board;
import model.Move;
import model.Player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LinearTimeWinningStrategy implements WinningStrategy{
    private int dimensions;
    private List<HashMap<Character,Integer>> rowHashMap;
    private List<HashMap<Character,Integer>> colHashMap;
    private HashMap<Character,Integer> leftDiagonalHashMap;
    private HashMap<Character,Integer> rightDiagonalHashMap;

    LinearTimeWinningStrategy(int dimensions){
        this.dimensions = dimensions;
        rowHashMap = new ArrayList<>();
        colHashMap = new ArrayList<>();
        leftDiagonalHashMap = new HashMap<>();
        rightDiagonalHashMap = new HashMap<>();

        for(int i=0;i<dimensions;i++){
            rowHashMap.add(new HashMap<>());
            colHashMap.add(new HashMap<>());
        }
    }

    @Override
    public Player checkWinner(Board board, Move lastMove){
        int row = lastMove.getCell().getRow();
        int col = lastMove.getCell().getCol();

        if(checkRowHashMap(row, lastMove.getPlayer().getSymbol()))  return lastMove.getPlayer();
        if(row==col && checkLeftDiagonalHashMap(lastMove.getPlayer().getSymbol()))  return lastMove.getPlayer();
        if(row+col==dimensions-1 && checkRightDiagonalHashMap(lastMove.getPlayer().getSymbol()))    return lastMove.getPlayer();
        if(checkColHashMap(col,lastMove.getPlayer().getSymbol()))   return lastMove.getPlayer();

        return null;
    }

    public boolean checkRowHashMap(int row, char symbol){
        if(rowHashMap.get(row).containsKey(symbol)){
            rowHashMap.get(row).put(symbol, rowHashMap.get(row).get(symbol)+1);
            return rowHashMap.get(row).get(symbol) == dimensions;
        }
        else{
            rowHashMap.get(row).put(symbol,1);
        }
        return false;
    }

    public boolean checkColHashMap(int col, char symbol){
        if(colHashMap.get(col).containsKey(symbol)){
            colHashMap.get(col).put(symbol, colHashMap.get(col).get(symbol)+1);
            return colHashMap.get(col).get(symbol) == dimensions;
        }
        else{
            colHashMap.get(col).put(symbol,1);
        }
        return false;
    }

    public boolean checkLeftDiagonalHashMap(char symbol){
        if(leftDiagonalHashMap.containsKey(symbol)){
            leftDiagonalHashMap.put(symbol, leftDiagonalHashMap.get(symbol)+1);
            return leftDiagonalHashMap.get(symbol) == dimensions;
        }
        else{
            leftDiagonalHashMap.put(symbol,1);
        }
        return false;
    }

    public boolean checkRightDiagonalHashMap(char symbol){
        if(rightDiagonalHashMap.containsKey(symbol)){
            rightDiagonalHashMap.put(symbol, rightDiagonalHashMap.get(symbol)+1);
            return rightDiagonalHashMap.get(symbol) == dimensions;
        }
        else{
            rightDiagonalHashMap.put(symbol,1);
        }
        return false;
    }
}
