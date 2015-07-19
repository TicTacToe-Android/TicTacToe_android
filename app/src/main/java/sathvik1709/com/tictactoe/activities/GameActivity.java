package sathvik1709.com.tictactoe.activities;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import sathvik1709.com.tictactoe.R;

public class GameActivity extends Activity {


    TextView game_activity_player_turn_tv;

    List<Integer> player_choice_icons;
    List<Integer> player_choice_colors;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        // Initializing views
        game_activity_player_turn_tv = (TextView) findViewById(R.id.game_activity_player_turn_tv);

        //Initializing views for matrix

        // Initializing objects
        player_choice_icons = new ArrayList<Integer>();
        player_choice_colors = new ArrayList<Integer>();



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
