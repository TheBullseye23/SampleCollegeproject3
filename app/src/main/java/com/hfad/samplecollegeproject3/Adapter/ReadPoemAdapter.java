package com.hfad.samplecollegeproject3.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.samplecollegeproject3.Data.PoemData;
import com.hfad.samplecollegeproject3.R;
import com.hfad.samplecollegeproject3.ReadPoem2;

import java.util.List;

public class ReadPoemAdapter extends RecyclerView.Adapter<ReadPoemAdapter.readPoemViewholder> {

    private List<PoemData> mPoems;
    private Context context;

    public ReadPoemAdapter(List<PoemData> mPoems, Context context) {
        this.mPoems = mPoems;
        this.context = context;
    }

    @NonNull
    @Override
    public readPoemViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_readpoem,parent,false);
        return new readPoemViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull readPoemViewholder holder, final int position) {
            PoemData POEM = mPoems.get(position);
            holder.poemtitle.setText(POEM.getPoemTitle());
            holder.poem.setText(POEM.getPoemLines());
            String AUTHOR = POEM.getUsers().get(0);
            holder.author.setText(AUTHOR);
            holder.fav.setText("FAV");
            holder.time.setText(POEM.getTime());
            holder.CV.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = mPoems.get(position).getKey();
                    Bundle mBundle = new Bundle();
                    mBundle.putString("KEY",key);
                    Intent intent = new Intent(context, ReadPoem2.class);
                    intent.putExtras(mBundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
            });
    }

    @Override
    public int getItemCount() {
        return mPoems.size();
    }

    public class readPoemViewholder extends RecyclerView.ViewHolder {

         TextView poemtitle;
         TextView poem;
         TextView author;
         TextView fav;
         TextView time;
         CardView CV;

        public readPoemViewholder(@NonNull View itemView) {
            super(itemView);
            poemtitle=itemView.findViewById(R.id.RPPoemTitle);
            poem=itemView.findViewById(R.id.RPPoem);
            author=itemView.findViewById(R.id.RPAuthor);
            fav=itemView.findViewById(R.id.RPfav);
            time=itemView.findViewById(R.id.RPTime);
            CV=itemView.findViewById(R.id.RPCardView);

        }
    }

}
