package com.joaoteixeira.playerpoints;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.joaoteixeira.entity.Player;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements AdapterView.OnItemClickListener {

    ListView listView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        this.listView = (ListView) view.findViewById(R.id.list_players);
        this.listView.setOnItemClickListener(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        List<Player> players = Player.listAll(Player.class, "name ASC");

        ArrayList<String> listPlayers = new ArrayList<String>();

        for (Player p : players) {
            listPlayers.add(p.getName());
        }

        ArrayAdapter<Player> listOfPlayersAdapter = new ArrayAdapter<Player>(
                getActivity(), // O contexto atual
                R.layout.list_players_item, // O arquivo de layout de cada item
                R.id.list_players_item_textview, // O ID do campo a ser preenchido
                players // A fonte dos dados
        );

        this.listView.setAdapter(listOfPlayersAdapter);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        Intent intent = new Intent(view.getContext(), PlayerEditActivity.class);
        Player p = (Player) parent.getItemAtPosition(position);

        Bundle params = new Bundle();
        params.putLong("id", p.getId());

        intent.putExtras(params);
        startActivity(intent);

//        Toast.makeText(getActivity().getApplicationContext(),
//                "Click ListItem Number " + view.getId() +
//                        " id " + id +
//                        " Name " + p.getName(), Toast.LENGTH_SHORT)
//                .show();

    }

}
