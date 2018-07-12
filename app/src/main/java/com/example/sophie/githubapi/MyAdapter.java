package com.example.sophie.githubapi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private ArrayList<GitHubResult> mDataset;
    private OnResultSelectedInterface resultsInterface;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView nameTextView;
        public TextView descriptionTextView;
        public TextView languageTextView;
        public TextView urlTextView;



        public ViewHolder(View v){
            super(v);
            nameTextView = v.findViewById(R.id.item_name);
            descriptionTextView = v.findViewById(R.id.item_description);
            languageTextView = v.findViewById(R.id.item_language);
            urlTextView = v.findViewById(R.id.item_url);
        }
    }

    public MyAdapter(ArrayList<GitHubResult> myDataset, OnResultSelectedInterface resultsInterface) {

        mDataset = myDataset;
        this.resultsInterface = resultsInterface;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position){
        final GitHubResult result = mDataset.get(position);
        holder.nameTextView.setText(result.getName());
        holder.descriptionTextView.setText(result.getDescription());
        holder.languageTextView.setText(result.getLanguage());
        holder.urlTextView.setText(result.getUrl());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                resultsInterface.onResultSelected(result);
            }

        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
    }

