package com.example.corsista.weatherapp;

import java.util.Arrays;

/**
 * Created by corsista on 30/03/2018.
 */

public class CityWeather {
    private Coordinates coord;
    private Weather[] weather;
    private String base;
    private AtmosphericData main;
    private int visibility;
    private Wind wind;
    private Clouds clouds;
    private String dt;
    private Sys sys;
    private int id;
    private String cityName;
    private int cod;

    public CityWeather(Coordinates coord, Weather[] weather, String base, AtmosphericData main, int visibility,
                       Wind wind, Clouds clouds, String dt, Sys sys, int id, String cityName, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.cityName = cityName;
        this.cod = cod;
    }



    @Override
    public String toString() {
        return "CityWeather{" +
                "coord=" + coord +
                ", weather=" + Arrays.toString(weather) +
                ", base='" + base + '\'' +
                ", main=" + main +
                ", visibility=" + visibility +
                ", wind=" + wind +
                ", clouds=" + clouds +
                ", dt='" + dt + '\'' +
                ", sys=" + sys +
                ", id=" + id +
                ", cityName='" + cityName + '\'' +
                ", cod=" + cod +
                '}';
    }

    public Coordinates getCoord() {
        return coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public AtmosphericData getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public String getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public int getCod() {
        return cod;
    }
}
