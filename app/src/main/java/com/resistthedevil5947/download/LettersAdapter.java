package com.resistthedevil5947.download;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class LettersAdapter extends RecyclerView.Adapter<LettersAdapter.MyViewHolder> {

    private ArrayList<DataModel2> dataSet;
    private Context context;
    public static class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView textView;
        Button downloadButton;
        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            this.textView = (TextView) itemView.findViewById(R.id.letter);
            this.downloadButton = (Button) itemView.findViewById(R.id.download_button);
        }

        public void onClick(View view) {
            Log.i("test", textView.getText().toString());
            String filename = textView.getText().toString();
            if(filename.length()>2){
                Context context = view.getContext();
                Intent intent = new Intent(context, FullscreenActivity.class);
                intent.putExtra("filename", filename);
                context.startActivity(intent);
            }


        }
    }

    public LettersAdapter(Context context, ArrayList<DataModel2> data) {

        this.context = context;
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.cards2_layout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textView = holder.textView;
        final Button downloadButton = holder.downloadButton;
        String groupletter = dataSet.get(listPosition).getLetter();
        final String title = dataSet.get(listPosition).getTitle();

        if (groupletter!=null){
            textView.setText(groupletter);
            downloadButton.setVisibility(View.GONE);
        }
        if(title!=null){
            String filename = title.replace(" ", "_") + ".json";

            textView.setText(title);
            if(checkFileExist(filename)){
                downloadButton.setVisibility(View.GONE);
            }else{
                downloadButton.setVisibility(View.VISIBLE);

            }

        }
       downloadButton.setOnClickListener(new View.OnClickListener() {

           @Override
           public void onClick(View view) {
               String filename = title.replace(" ", "_") + ".json";

               String githuburl = "https://gesab001.github.io/assets/story/articles/"+filename;
               String localurl = "http://192.168.1.70/assets/story/articles/"+filename;
               Log.i("downloadbutton", title);
               getArticle(filename, githuburl, localurl, downloadButton);
           }
       });
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public void getArticle(String filename, String githuburl, String homeurl, Button downloadbutton){
        MyData2 myData2 = new MyData2(context, filename, githuburl, homeurl);
        myData2.getArticleFromGithubStorage();
        if(checkFileExist(filename)){
            downloadbutton.setVisibility(View.GONE);
        }

    }

    public boolean checkFileExist(String filename){
        FileWriter fileWriter= new FileWriter(context);
        return fileWriter.fileExists(filename);

    }


}