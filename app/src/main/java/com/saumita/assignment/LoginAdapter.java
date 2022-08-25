package com.saumita.assignment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class LoginAdapter extends RecyclerView.Adapter<LoginAdapter.myviewholder> {

    private ArrayList<LoginList> loginLists;

    public LoginAdapter(ArrayList<LoginList> loginLists) {
        this.loginLists = loginLists;
    }

    @NonNull
    @Override
    public LoginAdapter.myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_recview_horizontal, parent, false);
        return new LoginAdapter.myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoginAdapter.myviewholder holder, int position) {
        holder.name.setText(loginLists.get(position).getName());
        holder.qualification.setText(loginLists.get(position).getQualification());
    }

    @Override
    public int getItemCount() {
        return loginLists.size();
    }

    class myviewholder extends RecyclerView.ViewHolder {
        TextView name, qualification;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            qualification = itemView.findViewById(R.id.qualification);
        }
    }
}
