package com.example.etudes.aurore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Get asynchron data of forecast
        Forecast forecast = new Forecast();
        forecast.upDateForecast();


        final Button button = findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intentForecastActivity = new Intent(getApplicationContext(),ForecastActivity.class);
                startActivity(intentForecastActivity);



            }
        });

    }
}
