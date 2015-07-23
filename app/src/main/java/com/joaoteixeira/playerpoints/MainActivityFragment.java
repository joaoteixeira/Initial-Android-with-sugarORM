package com.joaoteixeira.playerpoints;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.joaoteixeira.entity.Player;

import java.util.ArrayList;
import java.util.List;


/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    ListView listView;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        this.listView = (ListView) view.findViewById(R.id.list_players);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();

        List<Player> players = Player.listAll(Player.class);

        ArrayList<String> listPlayers = new ArrayList<String>();

        for(Player p: players) {
            listPlayers.add(p.getName());
        }

        ArrayAdapter<String> listOfPlayersAdapter = new ArrayAdapter<String>(
                getActivity(), // O contexto atual
                R.layout.list_players_item, // O arquivo de layout de cada item
                R.id.list_players_item_textview, // O ID do campo a ser preenchido
                listPlayers // A fonte dos dados
        );

        this.listView.setAdapter(listOfPlayersAdapter);
    }
}
