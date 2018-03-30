package com.example.corsista.weatherapp;

/**
 * Created by corsista on 30/03/2018.
 */

class Clouds {
    private String all;

    public Clouds(String all) {
        this.all = all;
    }


    @Override
    public String toString() {
        return "Clouds{" +
                "all='" + all + '\'' +
                '}';
    }

    public String getAll() {
        return all;
    }
}
