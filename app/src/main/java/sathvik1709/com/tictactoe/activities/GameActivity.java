package sathvik1709.com.tictactoe.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sathvik1709.com.tictactoe.R;
import sathvik1709.com.tictactoe.objects.Cell;
import sathvik1709.com.tictactoe.tictactoechecker.TicTacToeChecker;

public class GameActivity extends Activity {

    // Declare views
    TextView game_activity_player_turn_tv;
    LinearLayout game_activity_matrix_view;
    ImageButton game_activity_btn_matrix_cell_00,game_activity_btn_matrix_cell_01,game_activity_btn_matrix_cell_02;
    ImageButton game_activity_btn_matrix_cell_10,game_activity_btn_matrix_cell_11,game_activity_btn_matrix_cell_12;
    ImageButton game_activity_btn_matrix_cell_20,game_activity_btn_matrix_cell_21,game_activity_btn_matrix_cell_22;

    // Java/Other declarations
    int playerTurnIndicator = 0;
    List<Integer> player_choice_icons;
    List<Integer> player_choice_colors;
    Map<Integer,Cell> gameMatrix;
    TicTacToeChecker ticTacToeChecker;

    // Declare cells
    Cell cell_00,cell_01,cell_02;
    Cell cell_10,cell_11,cell_12;
    Cell cell_20,cell_21,cell_22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initializing views
        game_activity_player_turn_tv = (TextView) findViewById(R.id.game_activity_player_turn_tv);

        //Initializing views for matrix
        game_activity_btn_matrix_cell_00 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_00);
        game_activity_btn_matrix_cell_01 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_01);
        game_activity_btn_matrix_cell_02 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_02);
        game_activity_btn_matrix_cell_10 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_10);
        game_activity_btn_matrix_cell_11 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_11);
        game_activity_btn_matrix_cell_12 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_12);
        game_activity_btn_matrix_cell_20 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_20);
        game_activity_btn_matrix_cell_21 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_21);
        game_activity_btn_matrix_cell_22 = (ImageButton) findViewById(R.id.game_activity_btn_matrix_cell_22);

        //Initialize cells
        cell_00 = new Cell(00);cell_01 = new Cell(01);cell_02 = new Cell(02);
        cell_10 = new Cell(10);cell_11 = new Cell(11);cell_12 = new Cell(12);
        cell_20 = new Cell(20);cell_21 = new Cell(21);cell_22 = new Cell(22);

        // Initializing objects
        player_choice_icons = new ArrayList<Integer>();
        player_choice_colors = new ArrayList<Integer>();
        ticTacToeChecker = new TicTacToeChecker();
        //initializeMatrix();

        // show indicators
        changePlayerTurnIndicator();

        // get Intents
        Intent intent = getIntent();
        player_choice_icons = getIntent().getIntegerArrayListExtra("player_choice_icons_intent");
        player_choice_colors = getIntent().getIntegerArrayListExtra("player_choice_colors_intent");

    }

    // initialize matrix
    private void initializeMatrix() {
        gameMatrix = new HashMap<Integer,Cell>();
        // row 0
        gameMatrix.put(00,cell_00);
        gameMatrix.put(01,cell_01);
        gameMatrix.put(02,cell_02);
        // row 1
        gameMatrix.put(10,cell_10);
        gameMatrix.put(11,cell_11);
        gameMatrix.put(12,cell_12);
        // row 2
        gameMatrix.put(20,cell_20);
        gameMatrix.put(21,cell_21);
        gameMatrix.put(22,cell_22);
    }

    // on matrix button click action
    public void onPlayerSelected(View v){
        //Log.d("game_activity_click",String.valueOf(v.getId()));
        switch(v.getId()) {
            // for row 0
            case R.id.game_activity_btn_matrix_cell_00:
                changeCellProperties(cell_00,game_activity_btn_matrix_cell_00);
                break;
            case R.id.game_activity_btn_matrix_cell_01:
                changeCellProperties(cell_01,game_activity_btn_matrix_cell_01);
                break;
            case R.id.game_activity_btn_matrix_cell_02:
                changeCellProperties(cell_02,game_activity_btn_matrix_cell_02);
                break;
            // for row 1
            case R.id.game_activity_btn_matrix_cell_10:
                changeCellProperties(cell_10,game_activity_btn_matrix_cell_10);
                break;
            case R.id.game_activity_btn_matrix_cell_11:
                changeCellProperties(cell_11,game_activity_btn_matrix_cell_11);
                break;
            case R.id.game_activity_btn_matrix_cell_12:
                changeCellProperties(cell_12,game_activity_btn_matrix_cell_12);
                break;
            // for row 2
            case R.id.game_activity_btn_matrix_cell_20:
                changeCellProperties(cell_20,game_activity_btn_matrix_cell_20);
                break;
            case R.id.game_activity_btn_matrix_cell_21:
                changeCellProperties(cell_21,game_activity_btn_matrix_cell_21);
                break;
            case R.id.game_activity_btn_matrix_cell_22:
                changeCellProperties(cell_22,game_activity_btn_matrix_cell_22);
                break;
            default:
                // do nothing
                break;
        }
    }

    private void changeCellProperties(Cell cell,ImageButton cellBtn){
        if(!cell.isSelected()) {
            // Change the properties of cell
            cell.setSelected(true);
            cell.setSelectedByPlayer(playerTurnIndicator);
            // change icon indicator based on players choice
            if (playerTurnIndicator == 1) {
                cellBtn.setImageResource(player_choice_icons.get(0));
            } else if (playerTurnIndicator == 2) {
                cellBtn.setImageResource(player_choice_icons.get(1));
            }

            // initialize matrix to reflect changes of the cell
            initializeMatrix();
            // check for game
            //Log.d("Game Results",ticTacToeChecker.checkForGame(gameMatrix, playerTurnIndicator));
            String gameResult = ticTacToeChecker.checkForGame(gameMatrix, playerTurnIndicator);
            if(gameResult.equalsIgnoreCase("none")){
                // change playerTurnIndicator
                changePlayerTurnIndicator();
            }else{
                announceWinner(playerTurnIndicator,gameResult);
            }

        }
    }

    // Announce winner
    private void announceWinner(int winner,String markWinningLine) {
        int imgResId = player_choice_icons.get(winner-1);
        int playerColorChoice = player_choice_colors.get(winner-1);

        if(markWinningLine.equalsIgnoreCase("row0")){
            markWinningCells(game_activity_btn_matrix_cell_00,game_activity_btn_matrix_cell_01,game_activity_btn_matrix_cell_02,playerColorChoice);
        }else if (markWinningLine.equalsIgnoreCase("row1")){
            markWinningCells(game_activity_btn_matrix_cell_10,game_activity_btn_matrix_cell_11,game_activity_btn_matrix_cell_12,playerColorChoice);
        }else if (markWinningLine.equalsIgnoreCase("row2")){
            markWinningCells(game_activity_btn_matrix_cell_20,game_activity_btn_matrix_cell_21,game_activity_btn_matrix_cell_22,playerColorChoice);
        }else if (markWinningLine.equalsIgnoreCase("col0")){
            markWinningCells(game_activity_btn_matrix_cell_00,game_activity_btn_matrix_cell_10,game_activity_btn_matrix_cell_20,playerColorChoice);
        }else if (markWinningLine.equalsIgnoreCase("col1")){
            markWinningCells(game_activity_btn_matrix_cell_01,game_activity_btn_matrix_cell_11,game_activity_btn_matrix_cell_21,playerColorChoice);
        }else if (markWinningLine.equalsIgnoreCase("col2")){
            markWinningCells(game_activity_btn_matrix_cell_02,game_activity_btn_matrix_cell_12,game_activity_btn_matrix_cell_22,playerColorChoice);
        }else if (markWinningLine.equalsIgnoreCase("diagonal1")){
            markWinningCells(game_activity_btn_matrix_cell_00,game_activity_btn_matrix_cell_11,game_activity_btn_matrix_cell_22,playerColorChoice);
        }else if (markWinningLine.equalsIgnoreCase("diagonal2")){
            markWinningCells(game_activity_btn_matrix_cell_20,game_activity_btn_matrix_cell_11,game_activity_btn_matrix_cell_02,playerColorChoice);
        }
    }

    private void markWinningCells(ImageButton imgBtn1,ImageButton imgBtn2, ImageButton imgBtn3,int backgroundColor){
        imgBtn1.setBackgroundColor(backgroundColor);
        imgBtn2.setBackgroundColor(backgroundColor);
        imgBtn3.setBackgroundColor(backgroundColor);
    }

    private void printCells(){
        for (Map.Entry<Integer, Cell> entry : gameMatrix.entrySet()) {
            if(entry.getValue().isSelected()){
                System.out.println(entry.getKey()+"--"+entry.getValue().getSelectedByPlayer());
            }
        }
    }

    // events taking place after a player's turn
    private void changePlayerTurnIndicator(){
        if(playerTurnIndicator == 0){ // if not initialized
            playerTurnIndicator = 1;
        }else if(playerTurnIndicator == 1){
            playerTurnIndicator = 2;
        }else if(playerTurnIndicator == 2){
            playerTurnIndicator = 1;
        }
        //Log.d("game_activity_indicator", String.valueOf(playerTurnIndicator));
        game_activity_player_turn_tv.setText("Player "+String.valueOf(playerTurnIndicator)+"'s Turn ");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_game, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
