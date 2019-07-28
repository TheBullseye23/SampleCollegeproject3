package com.hfad.samplecollegeproject3.Adapter;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hfad.samplecollegeproject3.ContinuedPoems2;
import com.hfad.samplecollegeproject3.Data.PoemData;
import com.hfad.samplecollegeproject3.R;

import java.util.List;

 public class ContinuedPoemAdapter extends RecyclerView.Adapter<ContinuedPoemAdapter.CPViewHolder> {

    private List<PoemData> ContinuedPoems;
    Context context;

    public ContinuedPoemAdapter(List<PoemData> ContinuedPoems, Context context)
    {
        this.ContinuedPoems=ContinuedPoems;
        this.context=context;
    }

    @NonNull
    @Override
    public CPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_continuepoem,parent,false);
        return new CPViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CPViewHolder holder, final int position) {
            PoemData mPoemData = ContinuedPoems.get(position);
            holder.poemtitle.setText(mPoemData.getPoemTitle());
            holder.TimeMade.setText(mPoemData.getTime());
            holder.poempreview.setText(mPoemData.getPoemLines());
            holder.turnsleft.setText("300 turns left");
            String author=ContinuedPoems.get(position).getUsers().get(0);
            holder.Author.setText(author);
            holder.cpcardview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key=ContinuedPoems.get(position).getKey();
                    Bundle mBundle = new Bundle();
                    mBundle.putString("KEY",key);
                    Intent intent = new Intent(context,ContinuedPoems2.class);
                    intent.putExtras(mBundle);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });


    }

    @Override
    public int getItemCount() {
        return ContinuedPoems.size();
    }


    public class CPViewHolder extends RecyclerView.ViewHolder {

        TextView poemtitle;
        TextView poempreview;
        TextView TimeMade;
        TextView turnsleft;
        TextView Author;
        CardView cpcardview;
        // get data from firebase and update text values here
        public CPViewHolder(@NonNull View itemView) {
            super(itemView);
            poemtitle=itemView.findViewById(R.id.poemtitle);
            poempreview=itemView.findViewById(R.id.continuedpoem);
            TimeMade=itemView.findViewById(R.id.timemade);
            turnsleft=itemView.findViewById(R.id.TurnLeft);
            Author=itemView.findViewById(R.id.CPAuthor);
            cpcardview=itemView.findViewById(R.id.CPcardview);


        }

    }

}
