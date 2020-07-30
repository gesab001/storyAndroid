package com.resistthedevil5947.download;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class NamesAdapter extends RecyclerView.Adapter<NamesAdapter.MyViewHolder> {

    private ArrayList<DataModelName> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;


        public MyViewHolder(View itemView) {
            super(itemView);
            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);

        }
    }

    public NamesAdapter(ArrayList<DataModelName> data) {
        this.dataSet = data;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent,
                                           int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.names_layout, parent, false);

        view.setOnClickListener(MainActivity.myOnClickListener);

        MyViewHolder myViewHolder = new MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;

        textViewName.setText(dataSet.get(listPosition).getName());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }
}