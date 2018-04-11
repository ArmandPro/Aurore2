package com.example.etudes.aurore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    FirebaseAuth mAuth = FirebaseAuth.getInstance();

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
        final Button weatherbtn = findViewById(R.id.weatherbtn);
        weatherbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(getApplicationContext(),WeatherActivity.class);
                startActivity(intent);



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


    }
}
