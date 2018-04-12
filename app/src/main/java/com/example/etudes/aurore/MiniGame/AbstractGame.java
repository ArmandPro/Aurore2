package com.example.etudes.aurore.MiniGame;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;


import com.example.etudes.aurore.MainActivity;
import com.example.etudes.aurore.R;


public class AbstractGame extends AppCompatActivity {

    protected CountDownTimer timer;
    protected int counter;
    protected ProgressBar progressBar;
    protected static int DEFAULT_COUNTDOWN = 15;
    protected static String EXPLAINATION="Beat the game in less than "+DEFAULT_COUNTDOWN+" seconds.";
    protected static String GAME_NAME = "ABSTRACT GAME";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abstract_game);



        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        decorView.setSystemUiVisibility(uiOptions);
    }

    @Override
    public void onPause(){
        super.onPause();
        timer.cancel();
    }

    protected void initGame(){

    }

    protected void hasFailed(){
        timer.cancel();
        initTimer();
        progressBar.setProgress(0);
        initGame();
    }


    protected void gameEnded(){
        timer.cancel();

        if(counter<=5){

            Log.d(GAME_NAME,"Faster than light !");
        }

        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(this);
        alerBuilder.setTitle("Congratulation you win!");
        alerBuilder.setNeutralButton("Thanks !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intentMain = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentMain);

            }
        });
        alerBuilder.create().show();

    }

    protected void displayExplanation(){
        AlertDialog.Builder alerBuilder = new AlertDialog.Builder(this);
        alerBuilder.setTitle(EXPLAINATION);
        alerBuilder.setNeutralButton("Ok !", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                initGame();
            }
        });
        alerBuilder.create().show();
    }

    protected void initTimer() {
        counter = 0;
        timer = new CountDownTimer(15000, 150) {
            @Override
            public void onTick(long l) {
                counter++;
                progressBar.setProgress(counter);
            }
            @Override
            public void onFinish() {
                Log.d(GAME_NAME, "TIMED OUT");
                hasFailed();
            }
        };
    }
}
