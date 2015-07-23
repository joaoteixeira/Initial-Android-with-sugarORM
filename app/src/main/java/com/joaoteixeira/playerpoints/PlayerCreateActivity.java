package com.joaoteixeira.playerpoints;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.joaoteixeira.entity.Player;


public class PlayerCreateActivity extends ActionBarActivity implements View.OnClickListener {

    EditText editName;
    Button btnSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_create);

        this.editName = (EditText) findViewById(R.id.editName);
        this.btnSave = (Button) findViewById(R.id.btnSave);

        this.btnSave.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player_create, menu);
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

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btnSave:
                playerCreate();
                break;
        }

    }

    private void playerCreate() {
        Player player = new Player(this.editName.getText().toString());
        player.save();

        Toast.makeText(getApplicationContext(), "Novo jogador adicionado", Toast.LENGTH_LONG).show();
        finish();
    }
}
