package com.example.yes;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class HomeFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(@NonNull @org.jetbrains.annotations.NotNull View view, @Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        TextView username = findViewById(R.id.welcomeText);
//        Intent getName = getIntent();
//        username.setText("Welcome, "+getName.getStringExtra("name"));
        TextView username = (TextView) getView().findViewById(R.id.welcomeText);
        Intent getName = getActivity().getIntent();
        username.setText("Welcome, "+getName.getStringExtra("name"));
        Button toGames = (Button) getView().findViewById(R.id.buttonToGames);
        toGames.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toGames = new Intent(getActivity(), Games.class);
                startActivity(toGames);
            }
        });

    }
}