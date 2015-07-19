package sathvik1709.com.tictactoe.tictactoechecker;

import java.util.Map;

import sathvik1709.com.tictactoe.objects.Cell;

/**
 * Created by Sathvik on 18/07/15.
 */
public class TicTacToeChecker {

    public String checkForGame(Map<Integer,Cell> matrixToCheck,int player){
        //Check for rows
        if(// Check for row 0
                matrixToCheck.get(00).isSelected() && matrixToCheck.get(00).getSelectedByPlayer() == player
                    && matrixToCheck.get(01).isSelected() && matrixToCheck.get(01).getSelectedByPlayer() == player
                    && matrixToCheck.get(02).isSelected() && matrixToCheck.get(02).getSelectedByPlayer() == player){
                return "row0";
        }else if(// check for row 1
                matrixToCheck.get(10).isSelected() && matrixToCheck.get(10).getSelectedByPlayer() == player
                        && matrixToCheck.get(11).isSelected() && matrixToCheck.get(11).getSelectedByPlayer() == player
                        && matrixToCheck.get(12).isSelected() && matrixToCheck.get(12).getSelectedByPlayer() == player){
            return "row1";
        }else if(// check for row 2
                matrixToCheck.get(20).isSelected() && matrixToCheck.get(20).getSelectedByPlayer() == player
                        && matrixToCheck.get(21).isSelected() && matrixToCheck.get(21).getSelectedByPlayer() == player
                        && matrixToCheck.get(22).isSelected() && matrixToCheck.get(22).getSelectedByPlayer() == player){
            return "row2";
        }
        // Check for columns
        else if(// check for column 0
                matrixToCheck.get(00).isSelected() && matrixToCheck.get(00).getSelectedByPlayer() == player
                    && matrixToCheck.get(10).isSelected() && matrixToCheck.get(10).getSelectedByPlayer() == player
                    && matrixToCheck.get(20).isSelected() && matrixToCheck.get(20).getSelectedByPlayer() == player){
            return "col0";
        }else if(// check for column 1
                matrixToCheck.get(01).isSelected() && matrixToCheck.get(01).getSelectedByPlayer() == player
                        && matrixToCheck.get(11).isSelected() && matrixToCheck.get(11).getSelectedByPlayer() == player
                        && matrixToCheck.get(21).isSelected() && matrixToCheck.get(21).getSelectedByPlayer() == player){
            return "col1";
        }else if(// check for column 2
                matrixToCheck.get(02).isSelected() && matrixToCheck.get(02).getSelectedByPlayer() == player
                        && matrixToCheck.get(12).isSelected() && matrixToCheck.get(12).getSelectedByPlayer() == player
                        && matrixToCheck.get(22).isSelected() && matrixToCheck.get(22).getSelectedByPlayer() == player){
            return "col2";
        }else if(// check diagonal top-left to bottom-right
                matrixToCheck.get(00).isSelected() && matrixToCheck.get(00).getSelectedByPlayer() == player
                        && matrixToCheck.get(11).isSelected() && matrixToCheck.get(11).getSelectedByPlayer() == player
                        && matrixToCheck.get(22).isSelected() && matrixToCheck.get(22).getSelectedByPlayer() == player){
            return "diagonal1";
        }else if(// check diagonal top-right to bottom-left
                matrixToCheck.get(02).isSelected() && matrixToCheck.get(02).getSelectedByPlayer() == player
                        && matrixToCheck.get(11).isSelected() && matrixToCheck.get(11).getSelectedByPlayer() == player
                        && matrixToCheck.get(20).isSelected() && matrixToCheck.get(20).getSelectedByPlayer() == player){
            return "diagonal2";
        }

        return "none";
    }
}
