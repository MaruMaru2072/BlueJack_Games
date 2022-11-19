package com.example.yes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.view.menu.MenuView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yes.R;
import com.example.yes.models.Image;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class CarouselAdapter extends RecyclerView.Adapter<CarouselAdapter.viewHolder> {
    private ArrayList<Image>images;

    public CarouselAdapter(ArrayList<Image> images) {
        this.images = images;
    }

    @NonNull
    @NotNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.carousel_item,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull CarouselAdapter.viewHolder holder, int position) {
        Image img = images.get(position);
        holder.imageView.setImageResource(img.getImg());
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public viewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
