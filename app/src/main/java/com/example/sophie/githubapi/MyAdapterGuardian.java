package com.example.sophie.githubapi;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapterGuardian extends RecyclerView.Adapter<MyAdapterGuardian.ViewHolder> {

    private ArrayList<Result> mDataset;
    private OnResultSelectedGuardian resultsInterface;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        public TextView titleTextView;
        public TextView sectionTextView;
        public TextView webTextView;



        public ViewHolder(View v){
            super(v);
            titleTextView = v.findViewById(R.id.item_name_guardian);
            sectionTextView = v.findViewById(R.id.item_section_guardian);
            webTextView = v.findViewById(R.id.item_web_guardian);

        }
    }

    public MyAdapterGuardian(ArrayList<Result> myDataset, OnResultSelectedGuardian resultsInterface) {

        mDataset = myDataset;
        this.resultsInterface = resultsInterface;
    }

    @Override
    public MyAdapterGuardian.ViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View v =  LayoutInflater.from(parent.getContext()).inflate(R.layout.item_result_guardian, parent, false);
        MyAdapterGuardian.ViewHolder vh = new MyAdapterGuardian.ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(MyAdapterGuardian.ViewHolder holder, int position){
        final Result result = mDataset.get(position);
        holder.titleTextView.setText(result.getTitle());
        holder.sectionTextView.setText(result.getSection());
        holder.webTextView.setText(result.getWeb());

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

