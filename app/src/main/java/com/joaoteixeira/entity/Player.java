package com.joaoteixeira.entity;

import com.orm.SugarRecord;

/**
 * Created by joao on 7/23/15.
 */
public class Player extends SugarRecord {

    protected String name;

    public Player() {

    }

    public Player(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name;
    }

}

