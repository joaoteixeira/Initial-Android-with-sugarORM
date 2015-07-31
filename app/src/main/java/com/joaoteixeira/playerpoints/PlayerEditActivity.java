package com.joaoteixeira.playerpoints;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.joaoteixeira.entity.Player;


public class PlayerEditActivity extends ActionBarActivity
        implements View.OnClickListener, DialogInterface.OnClickListener {

    private EditText editName;
    private Button btnSave;
    private Player player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_edit);

        Intent intent = getIntent();
        Long id = intent.getExtras().getLong("id");

        this.player = Player.findById(Player.class, id);

        this.editName = (EditText) findViewById(R.id.editName);
        this.btnSave = (Button) findViewById(R.id.btnSave);
        this.btnSave.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_player_edit, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (item.getItemId()) {
            case R.id.action_player_remove:
                PlayerRemove();
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

        this.editName.setText(this.player.getName());
    }

    @Override
    public void onClick(View v) {
        this.player.setName(this.editName.getText().toString());
        this.player.save();

        Toast.makeText(getApplicationContext(), R.string.message_player_edit, Toast.LENGTH_LONG).show();
        finish();
    }

    @Override
    public void onClick(DialogInterface dialog, int which) {
        switch (which) {
            case DialogInterface.BUTTON_POSITIVE:
                this.player.delete();
                Toast.makeText(getApplicationContext(), R.string.message_player_remove, Toast.LENGTH_LONG).show();
                finish();
                break;
        }
    }

    private void PlayerRemove() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        builder.setMessage(R.string.alert_message)
                .setPositiveButton(R.string.alert_dialog_yes, this)
                .setNegativeButton(R.string.alert_dialog_no, this)
                .show();
    }
}
