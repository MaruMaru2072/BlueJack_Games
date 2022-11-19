package com.example.yes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.yes.adapters.CarouselAdapter;
import com.example.yes.models.Image;

import java.util.ArrayList;

public class About extends AppCompatActivity {
ArrayList<Image> images;
RecyclerView recyclerView;
CarouselAdapter carouselAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        ActionBar actionBar = getSupportActionBar();
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.Aqua)));
        setTitle("About Us");
        images = new ArrayList<>();
        setData();
        setAdapter();
    }

    private void setAdapter() {
        recyclerView = findViewById(R.id.rvSlider);
        recyclerView.setLayoutManager(new LinearLayoutManager(About.this,LinearLayoutManager.HORIZONTAL, true));
        carouselAdapter = new CarouselAdapter(images);
        recyclerView.setAdapter(carouselAdapter);
        final int setInterval = 3000;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            int count;
            @Override
            public void run() {
                if (count < images.size()){
                    recyclerView.scrollToPosition(count++);
                    handler.postDelayed(this,setInterval);
                    if (count == images.size()){
                        count = 0;

                    }
                }

            }
        };
        handler.postDelayed(runnable,setInterval);
    }

    public void setData(){
        images.add(new Image(R.drawable.arknights,"Image one"));
        images.add(new Image(R.drawable.clash_of_clans,"Image two"));
        images.add(new Image(R.drawable.hm_diva,"Image three"));
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
                Intent toHome = new Intent(About.this, Homepage.class);
                startActivity(toHome);
                break;

            case R.id.item2:
                Intent toGames = new Intent(About.this, Games.class);
                startActivity(toGames);
                break;

            case R.id.item3:
                Intent toAbout = new Intent(About.this, About.class);
                startActivity(toAbout);
                break;

            case R.id.item4:
                Intent toLogin = new Intent(About.this, MainActivity.class);
                startActivity(toLogin);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}

