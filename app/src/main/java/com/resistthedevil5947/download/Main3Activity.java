package com.resistthedevil5947.download;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Main3Activity extends AppCompatActivity {

    JSONArray story = new JSONArray();
    JSONObject article = new JSONObject();
    JSONArray slides = new JSONArray();
     TextView textView;
    int slideNumber = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bundle bundle = getIntent().getExtras();
        String filename = bundle.getString("filename");
        textView = findViewById(R.id.textView);
        textView.setText(filename);
        // Instantiate the RequestQueue.
        Button prev = (Button) findViewById(R.id.button);
        Button next = (Button) findViewById(R.id.button2);
        String url = "https://gesab001.github.io/assets/story/articles/"+filename;
        getArticle(url);

        prev.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (slideNumber>0){
                    slideNumber = slideNumber - 1;
                    try {
                        getImage();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        });

        next.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (slideNumber<10){
                    slideNumber = slideNumber + 1;
                    try {
                        getImage();
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }


            }
        });
    }



    public void getArticle(String url){

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            loadArticle(response);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText(error.toString());

                    }
                });

// Access the RequestQueue through your singleton class.
        queue.add(jsonObjectRequest);
    }

    public void loadArticle(JSONObject response) throws JSONException {
        article = response;
        loadSlides();
        getImage();

    }

    public void loadSlides() {
        try {
            slides = (JSONArray) article.get("slides");
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }

    public void getImage() throws JSONException {
        JSONObject slide = (JSONObject) slides.get(slideNumber);
        String imgurl = (String) slide.get("image");
        String caption = (String) slide.get("text");
        textView.setText(caption);
        ImageView imageView = findViewById(R.id.imageView2);

        //Loading image using Picasso
        Picasso.get().load(imgurl).into(imageView);
    }

    }

