package com.example.matterport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int fish_id = -1;
    Fish current_fish;
    Fish[] fishes = new Fish[]{
        new Fish("Catfish",R.drawable.catfish,"These nifty little fish dont know whether they wanna drink the stale milk that i set out yesterday or do they wanna eat pathetic little creatures."),new Fish("Swordfish",R.drawable.swordfish,"This fella gonna give pinnochio a run for his money coz this guy is the embodiment of inigo monteya")
    };
    //This method is for pushing the fish stats ahead
    public void cycle_fish(){
        fish_id+=1;
        current_fish = fishes[fish_id%fishes.length];
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cycle_fish();
                TextView name = (TextView) findViewById(R.id.name);
                ImageView pic = (ImageView) findViewById(R.id.pic);
                TextView info = (TextView) findViewById(R.id.info);
                name.setText(current_fish.getName());
                pic.setImageResource(current_fish.getImage());
                info.setText(current_fish.getInfo());
            }
        });
        cycle_fish();
    }
}