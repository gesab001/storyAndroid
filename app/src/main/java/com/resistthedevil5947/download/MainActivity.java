package com.resistthedevil5947.download;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TextView textView;
    JSONArray story = new JSONArray();
    JSONObject article = new JSONObject();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.textView);
// ...

// Instantiate the RequestQueue.

        String url ="https://gesab001.github.io/assets/story/stories.json";

        RequestQueue queue = Volley.newRequestQueue(this);

        JsonArrayRequest jsonObjectRequest = new JsonArrayRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONArray>() {

                    @Override
                    public void onResponse(JSONArray response) {

                            JSONArray story = (JSONArray) response;

                        try {
                            getStory(story);
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

    public void getStory(JSONArray response) throws JSONException {
        story = response;
        JSONObject titles = (JSONObject) story.get(0);
        JSONArray names = (JSONArray) titles.get("names");
        String url = "https://gesab001.github.io/assets/story/articles/"+names.get(0).toString().replace(" ", "_") + ".json";
        textView.setText(url);

        getArticle(url);

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
        JSONArray slides = (JSONArray) article.get("slides");
        JSONObject slide = (JSONObject) slides.get(0);
        String imgurl = (String) slide.get("image");
        textView.setText(imgurl);
        getImage(imgurl);



    }

    public void getImage(String imageUrl){
        ImageView imageView = findViewById(R.id.imageView2);

        //Loading image using Picasso
        Picasso.get().load(imageUrl).into(imageView);
    }


}
