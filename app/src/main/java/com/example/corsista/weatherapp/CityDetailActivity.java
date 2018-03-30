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
        ImageView imageView= findViewById(R.id.cityImage);
        imageView.setImageResource(R.drawable.ic_city);
        TextView textView= findViewById(R.id.cityName);
        textView.setText(città);
        final TextView textView2= findViewById(R.id.temperatura);
        final TextView textView3= findViewById(R.id.tempo);
        GsonRequest gsonObjectReq = new GsonRequest(url+"?"+"q="+città+"&units=metric"+"&appid="+appId, CityWeather.class, null,
                new Response.Listener<CityWeather>() {
                    @Override
                    public void onResponse(CityWeather response) {
                        cityWeather=response;
                        textView2.setText((String.valueOf(cityWeather.getMain().getTemp())));
                        textView3.setText(cityWeather.getWeather()[0].getMain());
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
