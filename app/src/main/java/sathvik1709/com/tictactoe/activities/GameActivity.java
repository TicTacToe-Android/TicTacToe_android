package sathvik1709.com.tictactoe.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sathvik1709.com.tictactoe.R;
import sathvik1709.com.tictactoe.objects.Cell;

public class GameActivity extends Activity {

    // Declare views
    TextView game_activity_player_turn_tv;
    LinearLayout game_activity_matrix_view;
    Button game_activity_btn_matrix_cell_00,game_activity_btn_matrix_cell_01,game_activity_btn_matrix_cell_02;
    Button game_activity_btn_matrix_cell_10,game_activity_btn_matrix_cell_11,game_activity_btn_matrix_cell_12;
    Button game_activity_btn_matrix_cell_20,game_activity_btn_matrix_cell_21,game_activity_btn_matrix_cell_22;

    // Java/Other declarations
    int playerTurnIndicator = 0;
    List<Integer> player_choice_icons;
    List<Integer> player_choice_colors;
    Map<Integer,Cell> gameMatrix;

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
        game_activity_btn_matrix_cell_00 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_00);
        game_activity_btn_matrix_cell_01 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_01);
        game_activity_btn_matrix_cell_02 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_02);
        game_activity_btn_matrix_cell_10 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_10);
        game_activity_btn_matrix_cell_11 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_11);
        game_activity_btn_matrix_cell_12 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_12);
        game_activity_btn_matrix_cell_20 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_20);
        game_activity_btn_matrix_cell_21 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_21);
        game_activity_btn_matrix_cell_22 = (Button) findViewById(R.id.game_activity_btn_matrix_cell_22);

        // Initializing objects
        player_choice_icons = new ArrayList<Integer>();
        player_choice_colors = new ArrayList<Integer>();
        gameMatrix = new HashMap<Integer,Cell>();
        initializeMatrix();

        // show indicators
        changePlayerTurnIndicator();

        // get Intents
        Intent intent = getIntent();
        player_choice_icons = getIntent().getIntegerArrayListExtra("player_choice_icons_intent");
        player_choice_colors = getIntent().getIntegerArrayListExtra("player_choice_colors_intent");

    }

    // initialize matrix
    private void initializeMatrix() {
        //Initialize cells
        cell_00 = new Cell(00);cell_01 = new Cell(01);cell_02 = new Cell(02);
        cell_10 = new Cell(10);cell_11 = new Cell(11);cell_12 = new Cell(12);
        cell_20 = new Cell(20);cell_21 = new Cell(21);cell_22 = new Cell(22);

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

        changePlayerTurnIndicator();

        switch(v.getId()) {
            // for row 0
            case R.id.game_activity_btn_matrix_cell_00:
                break;
            case R.id.game_activity_btn_matrix_cell_01:
                break;
            case R.id.game_activity_btn_matrix_cell_02:
                break;
            // for row 1
            case R.id.game_activity_btn_matrix_cell_10:
                break;
            case R.id.game_activity_btn_matrix_cell_11:
                break;
            case R.id.game_activity_btn_matrix_cell_12:
                break;
            // for row 2
            case R.id.game_activity_btn_matrix_cell_20:
                break;
            case R.id.game_activity_btn_matrix_cell_21:
                break;
            case R.id.game_activity_btn_matrix_cell_22:
                break;
            default:
                // do nothing
                break;
        }

    }

    private void changeCellProperties(Button toChangeBtn,Cell cell){

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
