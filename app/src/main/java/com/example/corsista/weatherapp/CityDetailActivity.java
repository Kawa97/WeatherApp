package com.example.corsista.weatherapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class CityDetailActivity extends AppCompatActivity {

    CityWeather cityWeather;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_detail);
        Bundle dati= getIntent().getExtras();
        String url = "http://api.openweathermap.org/data/2.5/weather";
        String città=dati.getString("città");
        String appId="2439d518e81cee90fd7a61cfe1109dd4";
        final ImageView imageView= findViewById(R.id.imageTempo);
        final Bundle weatherimagesBundle = new Bundle();
        weatherimagesBundle.putInt("Rain",R.drawable.rain_cloud_icon);
        weatherimagesBundle.putInt("Clear",R.drawable.sun);
        weatherimagesBundle.putInt("Clouds",R.drawable.cloud_forecast);
        weatherimagesBundle.putInt("Fog",R.drawable.fog_mist);
        TextView textView= findViewById(R.id.cityname);
        textView.setText(città);
        final TextView tempo= findViewById(R.id.tempo);
        final TextView ora= findViewById(R.id.ora);
        ora.setText("15:55");
        final TextView data= findViewById(R.id.data);
        data.setText("Oggi");
        final TextView maxemin =findViewById(R.id.maxemin);

        GsonRequest gsonObjectReq = new GsonRequest(url+"?"+"q="+città+"&units=metric"+"&appid="+appId, CityWeather.class, null,
                new Response.Listener<CityWeather>() {
                    @Override
                    public void onResponse(CityWeather response) {
                        cityWeather=response;
                        tempo.setText(cityWeather.getWeather()[0].getMain());
                        imageView.setImageResource(weatherimagesBundle.getInt(cityWeather.getWeather()[0].getMain()));
                        maxemin.setText(cityWeather.getMain().getTemp_max()+"/"+cityWeather.getMain().getTemp_min());
                    }

                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast= Toast.makeText(getApplicationContext(),error.getMessage(),Toast.LENGTH_LONG);
                toast.show();
            }
        });

        ServiceQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(gsonObjectReq);



    }
}
