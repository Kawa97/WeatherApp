package com.example.corsista.weatherapp;

/**
 * Created by corsista on 30/03/2018.
 */

class Sys {
    private int type;
    private int id;
    private String message;
    private String country;
    private float sunrise;
    private float sunset;

    public Sys(int type, int id, String message, String country, float sunrise, float sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    @Override
    public String toString() {
        return "Sys{" +
                "type=" + type +
                ", id=" + id +
                ", message='" + message + '\'' +
                ", country='" + country + '\'' +
                ", sunrise=" + sunrise +
                ", sunset=" + sunset +
                '}';
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public float getSunrise() {
        return sunrise;
    }

    public float getSunset() {
        return sunset;
    }
}
