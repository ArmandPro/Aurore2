package com.example.etudes.aurore;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.etudes.aurore.MiniGame.MatrixGame;
import com.example.etudes.aurore.MiniGame.RouletteGame;
import com.example.etudes.aurore.MiniGame.TapTaupeGame;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();
    private InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get asynchron data of forecast
        Forecast forecast = new Forecast();
        forecast.upDateForecast();


        //DAILY NOTIFICATION
        //Daily nat 18:00
        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, 18);
        final Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
        final PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent, PendingIntent.FLAG_UPDATE_CURRENT);

        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis()+1000,AlarmManager.INTERVAL_DAY,pendingIntent);


        //AD interstitial
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");//test ad ID
        //mInterstitialAd.setAdUnitId("ca-app-pub-8844459388456125/2506991189");
        ///////////////////////////////////////////////////////////////////////// Following line for emulator only : on real device use the other one
        mInterstitialAd.loadAd(new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build());
        //mInterstitialAd.loadAd(new AdRequest.Builder().build());

        mInterstitialAd.setAdListener(new AdListener(){
            @Override
            public void onAdClosed(){
                Intent intentForecastActivity = new Intent(getApplicationContext(),ForecastActivity.class);
                startActivity(intentForecastActivity);

            }
        });





        //FORECAST
        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if (mInterstitialAd.isLoaded()) {

                    mInterstitialAd.show();
                } else {
                    Log.d("TAG", "The interstitial wasn't loaded yet.");
                    Intent intentForecastActivity = new Intent(getApplicationContext(),ForecastActivity.class);
                    startActivity(intentForecastActivity);
                }



            }
        });

        final Button weatherbtn = findViewById(R.id.weatherbtn);
        weatherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),WeatherActivity.class);
                startActivity(intent);



            }
        });

        final Button gallerybtn = findViewById(R.id.gallerybtn);
        gallerybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),GalleryActivity.class);
                startActivity(intent);



            }
        });

        final Button mapbtn = findViewById(R.id.mapbtn);
        mapbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),MapsActivity.class);
                startActivity(intent);
                Log.e("TAG", "onClick: Map");


            }
        });

        final Button logoutbtn = findViewById(R.id.logoutbtn);
        logoutbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mAuth.signOut();
                Toast.makeText(getApplicationContext(), "Log Out !",
                        Toast.LENGTH_LONG).show();
                startActivity(new Intent(getApplicationContext(), AuthenticationActivity.class));
                finish();




            }
        });



        /*final Button notifBttn = findViewById(R.id.button4);
        notifBttn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("TAG", "onClick: notify");
                //Daily notification
                final Calendar calendar = Calendar.getInstance();
                calendar.set(Calendar.HOUR_OF_DAY, 18);
                final Intent intent = new Intent(getApplicationContext(), NotificationReceiver.class);
                final PendingIntent pendingIntent = PendingIntent.getBroadcast(getApplicationContext(),0,intent, PendingIntent.FLAG_UPDATE_CURRENT);

                AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis()+1000,AlarmManager.INTERVAL_DAY,pendingIntent);


            }
        });*/


        //button open random game
        final Button game = findViewById(R.id.button5);
        game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<Intent> gameList = new ArrayList<>();
                gameList.add(new Intent(MainActivity.this, MatrixGame.class));
                gameList.add(new Intent(MainActivity.this, TapTaupeGame.class));
                gameList.add(new Intent(MainActivity.this, RouletteGame.class));
                startActivity(gameList.get(new Random().nextInt(gameList.size())));



            }
        });





    }
}
