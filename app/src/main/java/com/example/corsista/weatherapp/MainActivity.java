package com.example.corsista.weatherapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager linearLayoutManager;
    RecyclerAdapter recyclerAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        List<String> list = new ArrayList<String>(){};
        list.add("Roma");
        list.add("Milano");
        list.add("Scampia");
        recyclerView= findViewById(R.id.recyclerView);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerAdapter=new RecyclerAdapter(list,new RecyclerAdapter.OnItemClickListener() {
            @Override public void onItemClick(String item) {
                Toast.makeText(getApplicationContext(), item, Toast.LENGTH_LONG).show();
                Intent intent= new Intent(getApplicationContext(),CityDetailActivity.class);
                intent.putExtra("città",item);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(recyclerAdapter);

        String url = "http://api.openweathermap.org/data/2.5/weather";
        String città="Roma";
        String appId="2439d518e81cee90fd7a61cfe1109dd4";
        JsonObjectRequest jsonObjectReq = new JsonObjectRequest(url+"?"+"q="+città+"&appid="+appId, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast toast = Toast.makeText(getApplicationContext(), response.toString(), Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                        Toast toast = Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG);
                        toast.show();
            }
        });
        ServiceQueueSingleton.getInstance(getApplicationContext()).addToRequestQueue(jsonObjectReq);
    }
}
