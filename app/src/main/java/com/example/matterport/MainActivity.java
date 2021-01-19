package com.example.matterport;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.util.Log;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

class MyException extends Exception{
    @Override
    public String getMessage(){
        return "MGMT says this is is my exception.I agree with them.";
    }
}
public class MainActivity extends AppCompatActivity {
    private static final String tag = "MainActivity";
    private static final String key = "question_id";
    private static int count = 0;
    int fish_id = 0;
    Fish current_fish;
    Fish[] fishes = new Fish[]{
        new Fish("Catfish",R.drawable.catfish,"These nifty little fish dont know whether they wanna drink the stale milk that i set out yesterday or do they wanna eat pathetic little creatures."),new Fish("Swordfish",R.drawable.swordfish,"This fella gonna give pinnochio a run for his money coz this guy is the embodiment of inigo monteya"),new Fish("Sardine",R.drawable.sardine,"This little nigglet is gonna fill my little hearth and gonna let me sleep through life much more peacefully")
    };
    //This method is for rotating the fish stats
    public void cycle_fish(int dir){
        if (dir==0) fish_id+=1;else fish_id-=1;
        current_fish = fishes[fish_id%fishes.length];
        Log.e(key,"this is a sample error for stack trace",new MyException());
    }
    public void change_fish(){
        TextView name = (TextView) findViewById(R.id.name);
        ImageView pic = (ImageView) findViewById(R.id.pic);
        TextView info = (TextView) findViewById(R.id.info);
        name.setText(current_fish.getName());
        pic.setImageResource(current_fish.getImage());
        info.setText(current_fish.getInfo());
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState!=null){
            fish_id = savedInstanceState.getInt(key);
            current_fish = fishes[fish_id%fishes.length];
            Log.i(tag,String.valueOf(fish_id));
            change_fish();
        }
        ImageButton next = (ImageButton) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cycle_fish(0);
                change_fish();
            }
        });
        ImageButton prev = (ImageButton) findViewById(R.id.prev);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                cycle_fish(1);
                change_fish();
            }
        });
        //makeText is a factory method
        //Toast t = Toast.makeText(getApplicationContext(),R.string.msg,Toast.LENGTH_SHORT);
        //t.show();
        Log.d(tag,String.format("Activity %s created",count));
    }
    @Override
    protected void onSaveInstanceState(Bundle savedstate){
        super.onSaveInstanceState(savedstate);
        Log.d(tag,"State saved");
        savedstate.putInt(key,fish_id);
    }
    @Override
    protected void onStart(){
        super.onStart();
        count++;
        Log.d(tag,String.format("Activity %s started",count));
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(tag,String.format("Activity %s resumed",count));
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(tag,String.format("Activity %s stopped",count));
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(tag,String.format("Activity %s paused",count));
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(tag,String.format("Activity %s destroyed",count));
    }
    }