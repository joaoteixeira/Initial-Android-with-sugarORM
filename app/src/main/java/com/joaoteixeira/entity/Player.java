package com.joaoteixeira.entity;

import com.orm.SugarRecord;

/**
 * Created by joao on 7/23/15.
 */
public class Player extends SugarRecord {

    String name;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name.toString();
    }

}

