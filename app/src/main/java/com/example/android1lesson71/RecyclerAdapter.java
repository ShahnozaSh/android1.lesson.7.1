package com.example.android1lesson71;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private ArrayList<Destination> list;
    private Context context;
    IFragments listener;

    public RecyclerAdapter(ArrayList<Destination> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        holder.onBind(list.get(position), position);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textTitle, textSubTitle;
        private Destination model;
        int pos = 0;


        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);

            textTitle = itemView.findViewById(R.id.tvTitle);
            textSubTitle = itemView.findViewById(R.id.tvDesc);

        }

        private void onBind(Destination model, int pos) {
            this.model = model;
            this.pos = pos;
            textTitle.setText(model.getTitle());
            textSubTitle.setText(model.getSubTitle());
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.displayDetails(model.getTitle(), model.getSubTitle(), model.getImageResourceId());
            }
        }
    }

    public void setOnClickListener(IFragments mListener) {
        this.listener = mListener;

    }
}
