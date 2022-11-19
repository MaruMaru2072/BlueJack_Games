package com.example.yes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.yes.adapters.GameAdapter;
import com.example.yes.models.Game;

import java.util.ArrayList;

public class Games extends AppCompatActivity{
    public static ArrayList<Game>games = new ArrayList<>();
    RecyclerView rvgame;
    GameAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_games);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Aqua)));
        setTitle("Games");
        insertDummyData();
        rvgame = findViewById(R.id.rvGame);
        rvgame.setLayoutManager(new LinearLayoutManager(Games.this,LinearLayoutManager.VERTICAL,false));
        adapter = new GameAdapter(games);
        rvgame.setAdapter(adapter);
    }
    public void setTitle(String title){
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView textView = new TextView(this);
        textView.setText(title);
        textView.setTextSize(32);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
        textView.setGravity(Gravity.CENTER);
        textView.setTextColor(getResources().getColor(R.color.black));
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(textView);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.item1:
                Intent toHome = new Intent(Games.this, Homepage.class);
                startActivity(toHome);
                break;

            case R.id.item2:
                Intent toGames = new Intent(Games.this, Games.class);
                startActivity(toGames);
                break;

            case R.id.item3:
                Intent toAbout = new Intent(Games.this, About.class);
                startActivity(toAbout);
                break;

            case R.id.item4:
                Intent toLogin = new Intent(Games.this, MainActivity.class);
                startActivity(toLogin);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    void insertDummyData(){
        games.add(new Game("Arknights","Free", "2020",getDrawable(R.drawable.arknights)));
        games.add(new Game("Clash Of Clans","Free", "2012",getDrawable(R.drawable.clash_of_clans)));
        games.add(new Game("Hatsune Miku Project Sekai","Free", "2020",getDrawable(R.drawable.hm_diva)));
        games.add(new Game("Genshin Impact","Free", "2020",getDrawable(R.drawable.genshin_impact)));
        games.add(new Game("Minecraft","Rp 109000", "2011",getDrawable(R.drawable.minecraft)));
        games.add(new Game("Stumble Guys","Free", "2021",getDrawable(R.drawable.stumble_guys)));
        games.add(new Game("Free Fire","Free", "2017",getDrawable(R.drawable.free_fire)));
        games.add(new Game("Mobile Legends","Free", "2016",getDrawable(R.drawable.mobile_legends)));
        games.add(new Game("Monster Hunter Stories","Rp279000", "2018",getDrawable(R.drawable.mhst)));
        games.add(new Game("Weeb Golf","Free", "2022",getDrawable(R.drawable.golf)));
    }

}