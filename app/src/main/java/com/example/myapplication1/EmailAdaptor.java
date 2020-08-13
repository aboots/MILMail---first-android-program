package com.example.myapplication1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class EmailAdaptor extends RecyclerView.Adapter<EmailAdaptor.ViewHolder> {

    private ArrayList<Email> data;
    private LayoutInflater layoutInflater;

    public EmailAdaptor(ArrayList<Email> data, Context context) {
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView senderTextView;
        TextView subjectTextView;
        ImageView image;
        ViewHolder(View itemView) {
            super(itemView);
            senderTextView = itemView.findViewById(R.id.senderInRow);
            subjectTextView = itemView.findViewById(R.id.subjectInRow);
            image = itemView.findViewById(R.id.imageViewEmail);
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(layoutInflater.inflate(R.layout.email_row, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.senderTextView .setText(data.get(position).getSender());
        holder.subjectTextView.setText(data.get(position).getSubject());
        Picasso.get().load(data.get(position).getImageURL()).into(holder.image);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

}
