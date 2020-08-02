package com.resistthedevil5947.download;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;

public class Singleton {

    private static Singleton INSTANCE;
    private String info = "Initial info class";
    RequestQueue queue;

    private Singleton(Context context) {
        queue = Volley.newRequestQueue(context);
    }

    public static Singleton getInstance(Context context) {
        if(INSTANCE == null) {
            INSTANCE = new Singleton(context);
        }

        return INSTANCE;
    }

    // getters and setters

    public String getInfo(){
        return info;
    }

    public void addToRequestQueue(JsonArrayRequest jsonArrayRequest){
         queue.add(jsonArrayRequest);
    }


}