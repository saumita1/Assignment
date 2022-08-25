package com.saumita.assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import java.util.ArrayList;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsAdapter.myviewholder> {

    private ArrayList<DetailsList> detailsLists;

    public DetailsAdapter(ArrayList<DetailsList> detailsLists) {
        this.detailsLists = detailsLists;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recview_vertical, parent, false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.title.setText(detailsLists.get(position).getTitle());
        holder.created_at.setText(detailsLists.get(position).getCreated_at());
        //holder.updated_at.setText(detailsLists.get(position).getUpdated_at());
    }

    @Override
    public int getItemCount() {
        return detailsLists.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView title, created_at, updated_at;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            created_at = itemView.findViewById(R.id.created_at);
            //updated_at = itemView.findViewById(R.id.updated_at);
        }
    }
}
