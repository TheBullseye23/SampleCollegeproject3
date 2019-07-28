package com.hfad.samplecollegeproject3.Adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.samplecollegeproject3.Data.PoemData;
import com.hfad.samplecollegeproject3.R;

import java.util.List;

public class UserPoemAdapter extends RecyclerView.Adapter<UserPoemAdapter.UserPoemViewHolder > {

    private List<PoemData> mPoems;

    @NonNull
    @Override
    public UserPoemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_userspoem,parent,false);
        return new UserPoemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserPoemViewHolder holder, int position) {
            holder.favPoem.setText("Favourite it!");
            holder.poemTime.setText(mPoems.get(position).getTime());
            holder.poem.setText(mPoems.get(position).getPoemLines());
            holder.poemTitle.setText(mPoems.get(position).getPoemTitle());

    }

    @Override
    public int getItemCount() {
        return mPoems.size();
    }

    public class UserPoemViewHolder extends RecyclerView.ViewHolder {

        TextView poemTitle;
        TextView poem;
        TextView poemTime;
        TextView favPoem;

        public UserPoemViewHolder(@NonNull View itemView) {
            super(itemView);
            poemTitle=itemView.findViewById(R.id.UP_Title);
            poem=itemView.findViewById(R.id.UP_PoemLines);
            poemTime=itemView.findViewById(R.id.UP_Time);
            favPoem=itemView.findViewById(R.id.UP_fav);

        }
    }


}
