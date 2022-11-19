package com.example.yes.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.yes.R;
import com.example.yes.models.Game;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.myViewHolder> {
    private ArrayList<Game>games;
//    private GameClickListener listener;
//
//    public GameAdapter(ArrayList<Game> games, GameClickListener listener) {
//        this.games = games;
//        this.listener = listener;
//    }

    public GameAdapter(ArrayList<Game> games) {
        this.games = games;
    }


    @NonNull
    @NotNull
    @Override
    public myViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.games_item,parent,false);
        return new myViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull @NotNull GameAdapter.myViewHolder holder, int position) {
        holder.images.setImageDrawable(games.get(position).getImages());
        holder.title.setText(games.get(position).getTitle());
        holder.price.setText(games.get(position).getPrice());
        holder.year.setText(games.get(position).getYear());

    }


    @Override
    public int getItemCount() {
        return games.size();
    }
    static class myViewHolder extends RecyclerView.ViewHolder{
        TextView title,price,year;
        ImageView images;
//        CardView cardView;

        public myViewHolder(@NonNull @NotNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            price = itemView.findViewById(R.id.price);
            year = itemView.findViewById(R.id.year);
            images = itemView.findViewById(R.id.images);
//            cardView = itemView.findViewById(R.id.cardView);
//            cardView.setOnClickListener(new View.OnClickListener() {
//                @Override
////                public void onClick(View view) {
////                    listener.onGameClicked(getAdapterPosition());
////
////
////                }
//            });
        }
    }
////    public interface GameClickListener{
////        void onGameClicked(int position);
//    }
}
