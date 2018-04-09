package com.example.etudes.aurore;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ForecastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forecast);

        TextView tv0 = findViewById(R.id.textView5);
        TextView tv1 = findViewById(R.id.textView6);
        TextView tv2 = findViewById(R.id.textView7);

        tv0.setText(ForecastValue.FORECAST[1][0]);
        tv1.setText(ForecastValue.FORECAST[1][1]);
        tv2.setText(ForecastValue.FORECAST[1][2]);


    }
}
