package sathvik1709.com.tictactoe.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import sathvik1709.com.tictactoe.R;

public class StartActivity extends ActionBarActivity {

    //Views
    Toolbar start_activity_toolbar;
    Button start_activity_start_game_btn;
    ImageButton start_activity_swap_player_choice_btn;
    List<Integer> player_choice_icons;
    List<Integer> player_choice_colors;
    ImageView start_activity_player_1_choice, start_activity_player_2_choice;
    Button start_activity_btn_00, start_activity_btn_01, start_activity_btn_02, start_activity_btn_03;
    Button start_activity_btn_10, start_activity_btn_11, start_activity_btn_12, start_activity_btn_13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        //Initializing views
        start_activity_toolbar = (Toolbar) findViewById(R.id.start_activity_toolbar);
        setSupportActionBar(start_activity_toolbar);
        start_activity_start_game_btn = (Button) findViewById(R.id.start_activity_start_game_btn);
        start_activity_swap_player_choice_btn = (ImageButton) findViewById(R.id.start_activity_swap_player_choice_btn);
        start_activity_player_1_choice = (ImageView) findViewById(R.id.start_activity_player_1_choice);
        start_activity_player_2_choice = (ImageView) findViewById(R.id.start_activity_player_2_choice);

        start_activity_btn_00 = (Button) findViewById(R.id.start_activity_btn_00);
        start_activity_btn_01 = (Button) findViewById(R.id.start_activity_btn_01);
        start_activity_btn_02 = (Button) findViewById(R.id.start_activity_btn_02);
        start_activity_btn_03 = (Button) findViewById(R.id.start_activity_btn_03);

        start_activity_btn_10 = (Button) findViewById(R.id.start_activity_btn_10);
        start_activity_btn_11 = (Button) findViewById(R.id.start_activity_btn_11);
        start_activity_btn_12 = (Button) findViewById(R.id.start_activity_btn_12);
        start_activity_btn_13 = (Button) findViewById(R.id.start_activity_btn_13);

        // Initializing objects
        player_choice_icons = new ArrayList<Integer>();
        player_choice_colors = new ArrayList<Integer>();

        // Initializing player choices
        swapPlayerChoiceIcons();
        setPlayerChoiceColors();

        // Swap button action
        start_activity_swap_player_choice_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                swapPlayerChoiceIcons();
            }
        });

        // start activity click action
        start_activity_start_game_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StartActivity.this, GameActivity.class);
                intent.putIntegerArrayListExtra("player_choice_icons_intent", (ArrayList<Integer>) player_choice_icons);
                intent.putIntegerArrayListExtra("player_choice_colors_intent", (ArrayList<Integer>) player_choice_colors);
                startActivity(intent);
            }
        });
    }

    private void setPlayerChoiceColors() {
        if(player_choice_colors.size() != 2){
            player_choice_colors.add(getResources().getColor(R.color.darkgreen));
            player_choice_colors.add(getResources().getColor(R.color.darkblue));
        }

        //Log.d("choice_colors", player_choice_colors.toString());
    }

    private void swapPlayerChoiceIcons() {

        // Initialize if not set
        if (player_choice_icons.size() != 2) {
            player_choice_icons.add(getResources().getIdentifier("ic_tic", "drawable", getPackageName()));
            player_choice_icons.add(getResources().getIdentifier("ic_toe", "drawable", getPackageName()));
        } else {//else swap
            Collections.reverse(player_choice_icons);
        }

        start_activity_player_1_choice.setImageResource(player_choice_icons.get(0));
        start_activity_player_2_choice.setImageResource(player_choice_icons.get(1));

        //Log.d("choice_icons", player_choice_icons.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_start, menu);
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
