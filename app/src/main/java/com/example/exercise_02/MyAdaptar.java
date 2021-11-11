package com.example.exercise_02;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyAdaptar extends RecyclerView.Adapter<MyAdaptar.MyViewHolder> {
    String houseNames[];
    int images[];
    Context context;

    public MyAdaptar(Context ct, String names[], int img[]){
        context = ct;
        houseNames = names;
        images = img;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.my_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.name.setText(houseNames[position]);
        holder.image.setImageResource(images[position]);
    }

    @Override
    public int getItemCount() {
        return houseNames.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        ImageView image;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.textView);
            image = itemView.findViewById(R.id.imageView);
        }
    }
}
